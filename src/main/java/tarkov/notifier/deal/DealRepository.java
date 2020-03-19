package tarkov.notifier.deal;

import java.util.Arrays;
import java.util.List;

public abstract class DealRepository {
    protected static List<ResourceAmount> resources(ResourceAmount[] resources) {
        return Arrays.asList(resources);
    }

    public abstract List<String> itemNames();

    public abstract List<Deal> getDeals();
}
