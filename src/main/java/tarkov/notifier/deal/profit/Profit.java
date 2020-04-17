package tarkov.notifier.deal.profit;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tarkov.notifier.deal.Deal;
import tarkov.notifier.deal.ResourceAmount;

import java.util.Map;

@Getter
@Setter
@ToString
public class Profit {
    private int forcedFleaPrice;
    private int fleaPrice;
    private int realPrice;
    private int profit;
    private int profitPercents;
    private int taxes;
    private Deal deal;
    private Map<ResourceAmount, Integer> resourcesToPrice;

    /**
     * Must call calculate() to calculate all the getters
     */
    public Profit(int fleaPrice, Deal deal, Map<ResourceAmount, Integer> resourcesToPrice) {
        this.fleaPrice = fleaPrice * deal.getItemAmount();
        this.deal = deal;
        this.resourcesToPrice = resourcesToPrice;
    }

    private Profit() {}

    public void calculate() {
        for (Map.Entry<ResourceAmount, Integer> resourceToPrice : resourcesToPrice.entrySet()) {
            realPrice += resourceToPrice.getKey().getAmount() * resourceToPrice.getValue();
        }
        profit = fleaPrice - realPrice;
        if (deal.getBaseValue() > 0) {
            taxes = (int) taxes(fleaPrice);
            profit -= taxes;
        }
        profitPercents = percentOf(profit, fleaPrice);
    }

    private int percentOf(int smallerPart, int whole) {
        return (int)((smallerPart / (float) whole) * 100);
    }

    private long taxes(int price) {
        int offerVal = deal.getBaseValue() * deal.getItemAmount();
        return Math.round(offerVal * 0.025 * Math.pow(4, Math.log10(offerVal / (float) price)) +
                price * 0.025 * Math.pow(4, Math.log10(price / (float) offerVal)));
    }
}
