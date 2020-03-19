package tarkov.notifier.telegram.storage;

import lombok.Data;

@Data
public class TelegramUser {
    private boolean isActive = false;
    private String chatId;
}
