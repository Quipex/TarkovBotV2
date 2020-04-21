package tarkov.notifier.telegram;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import tarkov.notifier.telegram.barter.BarterNotificationBot;
import tarkov.notifier.telegram.craft.CraftNotificationBot;

@Slf4j
public class BotInitializer {
    public void initialize() {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new BarterNotificationBot());
            telegramBotsApi.registerBot(new CraftNotificationBot());
        } catch (TelegramApiRequestException e) {
            log.error("Ошибка регистрации ботов", e);
            throw new RuntimeException(e);
        }
    }
}
