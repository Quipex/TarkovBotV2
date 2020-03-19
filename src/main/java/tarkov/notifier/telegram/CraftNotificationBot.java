package tarkov.notifier.telegram;

import org.telegram.telegrambots.meta.api.objects.Update;
import tarkov.notifier.Configuration;
import tarkov.notifier.deal.craft.Craft;
import tarkov.notifier.deal.profit.CraftMessage;
import tarkov.notifier.deal.profit.Profit;
import tarkov.notifier.deal.profit.TelegramMessage;

import java.util.Comparator;
import java.util.List;

public class CraftNotificationBot extends DealNotificationBot {
    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotUsername() {
        return "Craft notificator";
    }

    @Override
    public String getBotToken() {
        return Configuration.getOSVariable("CRAFT_BOT");
    }

    @Override
    protected TelegramMessage generateMessage(String category, List<Profit> filteredProfits) {
        return new CraftMessage(category, filteredProfits);
    }

    @Override
    protected Comparator<? super Profit> sortProfitsComparator() {
        return (o1, o2) -> roublesPerMinute(o2) - roublesPerMinute(o1);
    }

    private int roublesPerMinute(Profit o2) {
        return o2.getProfit() / ((Craft) o2.getDeal()).getCraftTimeMinutes();
    }
}
