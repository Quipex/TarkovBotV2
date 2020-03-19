package tarkov.notifier;

public class Main {

    public static final int MINUTES_BETWEEN_CYCLES = Integer.parseInt(Configuration.getOSVariable("MINUTES_BETWEEN_CYCLES"));

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        while (true) {
            worker.work();
            Thread.sleep(MINUTES_BETWEEN_CYCLES * 60 * 1000);
        }
    }
}
