package tarkov.notifier.market;

public class TMarketException extends RuntimeException {
    public TMarketException(String s) {
        super(s);
    }

    public TMarketException() {
        super();
    }

    public TMarketException(String message, Throwable cause) {
        super(message, cause);
    }

    public TMarketException(Throwable cause) {
        super(cause);
    }
}
