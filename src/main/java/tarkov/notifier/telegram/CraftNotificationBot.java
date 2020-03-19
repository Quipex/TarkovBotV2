package tarkov.notifier.telegram;

import org.telegram.telegrambots.meta.api.objects.Update;
import tarkov.notifier.Configuration;
import tarkov.notifier.deal.profit.CraftMessage;
import tarkov.notifier.deal.profit.Profit;
import tarkov.notifier.deal.profit.TelegramMessage;

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
}
