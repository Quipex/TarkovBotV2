package tarkov.notifier;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static final int MINUTES_BETWEEN_CYCLES = Integer.parseInt(Configuration.getOSVariable("MINUTES_BETWEEN_CYCLES"));

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        //noinspection InfiniteLoopStatement
        while (true) {
            worker.work();
            log.info("Sleeping for " + MINUTES_BETWEEN_CYCLES + " minutes.");
            Thread.sleep(MINUTES_BETWEEN_CYCLES * 60 * 1000);
        }
    }
}
