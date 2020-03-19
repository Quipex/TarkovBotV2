package tarkov.notifier.telegram;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

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
