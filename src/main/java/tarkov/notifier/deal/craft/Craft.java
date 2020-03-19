package tarkov.notifier.deal.craft;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import tarkov.notifier.deal.Deal;
import tarkov.notifier.deal.ResourceAmount;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Craft extends Deal {
    private int craftTimeMinutes;
    private CraftPlace place;

    public Craft(String itemName, int itemAmount, Integer baseValue, int craftTimeMinutes, CraftPlace place, List<ResourceAmount> resources) {
        super(itemName, itemAmount, baseValue, resources);
        this.craftTimeMinutes = craftTimeMinutes;
        this.place = place;
    }

    @Override
    public String category() {
        return place.getLocalizedName();
    }

    @Getter
    public enum CraftPlace {
        BENCH("Верстак"),
        TOILET("Санузел"),
        MEDICAL("Мед. центр"),
        INTELLIGENCE("Развед. центр"),
        KITCHEN("Кухня");

        private String localizedName;

        CraftPlace(String localizedName) {
            this.localizedName = localizedName;
        }
    }
}

