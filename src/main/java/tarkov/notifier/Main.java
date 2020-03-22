package tarkov.notifier;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class Main {

    public static final int MINUTES_BETWEEN_CYCLES = Integer.parseInt(Configuration.getOSVariable("MINUTES_BETWEEN_CYCLES"));

    public static void main(String[] args) throws InterruptedException {
        disableLoggers();
        Worker worker = new Worker();
        //noinspection InfiniteLoopStatement
        while (true) {
            try {
                worker.work();
            } catch (Exception e) {
                Telegram.sendError(e);
            }
            log.info("Sleeping for " + MINUTES_BETWEEN_CYCLES + " minutes.");
            Thread.sleep(MINUTES_BETWEEN_CYCLES * 60 * 1000);
        }
    }

    private static void disableLoggers() {
        Set<String> loggers = new HashSet<>(Arrays.asList("org.apache.http", "groovyx.net.http"));

        for (String log : loggers) {
            var logger = (Logger) LoggerFactory.getLogger(log);
            logger.setLevel(Level.INFO);
            logger.setAdditive(false);
        }
    }
}
