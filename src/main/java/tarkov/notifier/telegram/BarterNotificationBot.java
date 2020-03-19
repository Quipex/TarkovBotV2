package tarkov.notifier.telegram;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.objects.Update;
import tarkov.notifier.Configuration;
import tarkov.notifier.deal.profit.BarterMessage;
import tarkov.notifier.deal.profit.Profit;
import tarkov.notifier.deal.profit.TelegramMessage;

import java.util.List;

@Slf4j
public class BarterNotificationBot extends DealNotificationBot {

    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotUsername() {
        return "Barter notifications";
    }

    @Override
    public String getBotToken() {
        return Configuration.getOSVariable("BARTER_BOT");
    }

    @Override
    protected TelegramMessage generateMessage(String category, List<Profit> filteredProfits) {
        return new BarterMessage(category, filteredProfits);
    }
}
