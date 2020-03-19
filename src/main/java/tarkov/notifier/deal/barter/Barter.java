package tarkov.notifier.deal.barter;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import tarkov.notifier.deal.Deal;
import tarkov.notifier.deal.ResourceAmount;

import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Barter extends Deal {
    private String vendor;
    private int limit;

    public Barter(String itemName, int itemAmount, Integer baseValue, String vendor, int limit, List<ResourceAmount> resources) {
        super(itemName, itemAmount, baseValue, resources);
        this.vendor = vendor;
        this.limit = limit;
    }

    @Override
    public String category() {
        return vendor;
    }
}
