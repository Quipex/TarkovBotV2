package tarkov.notifier.deal;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public abstract class Deal {
    private String itemName;
    private int itemAmount;
    private Integer baseValue;
    private List<ResourceAmount> resources = new ArrayList<>();

    public Deal(String itemName, int itemAmount, Integer baseValue, List<ResourceAmount> resources) {
        this.itemName = itemName;
        this.itemAmount = itemAmount;
        this.baseValue = baseValue;
        this.resources = resources;
    }

    public abstract String category();
}
