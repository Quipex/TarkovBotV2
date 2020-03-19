package tarkov.notifier;

public interface Configuration {
    static String getOSVariable(String key) {
        return System.getenv(key);
    }
}
