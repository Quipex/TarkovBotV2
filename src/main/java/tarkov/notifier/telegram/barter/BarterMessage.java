package tarkov.notifier.telegram.barter;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tarkov.notifier.deal.barter.Barter;
import tarkov.notifier.deal.profit.Profit;
import tarkov.notifier.telegram.TelegramMessage;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class BarterMessage extends TelegramMessage {

    public BarterMessage(String category, List<Profit> profit) {
        super(category, profit);
    }

    @Override
    protected String additionalInfo(Profit profit) {
        int limit = ((Barter) profit.getDeal()).getLimit();
        if (limit == 0) {
            return "Бесконечный трейд.";
        }

        if (limit == 1) {
            return "";
        }

        return "За завоз " + limit + " обмена.";
    }
}
