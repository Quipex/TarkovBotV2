package tarkov.notifier.telegram.craft;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tarkov.notifier.deal.craft.Craft;
import tarkov.notifier.deal.profit.Profit;
import tarkov.notifier.telegram.TelegramMessage;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class CraftMessage extends TelegramMessage {

    public CraftMessage(String category, List<Profit> profit) {
        super(category, profit);
    }

    @Override
    protected String additionalInfo(Profit profit) {
        return bold(formatPrice(roublesPerMinute(profit)))
                + " рублей в минуту. " + getTime(profit);
    }

    private int roublesPerMinute(Profit profit) {
        return Math.round(profit.getProfit() / (float) (((Craft) profit.getDeal()).getCraftTimeMinutes()));
    }

    private String getTime(Profit profit) {
        int craftTimeMinutes = ((Craft) profit.getDeal()).getCraftTimeMinutes();
        int hours = craftTimeMinutes / 60;
        int mins = craftTimeMinutes - hours * 60;
        return hours + "ч. " + mins + "мин.";
    }
}
