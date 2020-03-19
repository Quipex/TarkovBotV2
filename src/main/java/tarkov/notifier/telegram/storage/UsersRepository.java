package tarkov.notifier.telegram.storage;

import tarkov.notifier.Configuration;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class UsersRepository {
    private static UsersRepository INSTANCE;
    private Set<TelegramUser> users;

    private UsersRepository() {
        users = new HashSet<>();
        for (String chatId : Configuration.getOSVariable("RECEIVERS").split(";")) {
            TelegramUser user = new TelegramUser();
            user.setActive(true);
            user.setChatId(chatId);
            users.add(user);
        }
    }

    public static UsersRepository instance() {
        if (INSTANCE == null) {
            INSTANCE = new UsersRepository();
        }
        return INSTANCE;
    }

    public Set<TelegramUser> getReceivers() {
        return users.stream().filter(TelegramUser::isActive).collect(Collectors.toSet());
    }

    public Optional<TelegramUser> findUser(String chatId) {
        List<TelegramUser> collect = users.stream().filter(telegramUser -> chatId.equals(telegramUser.getChatId())).collect(Collectors.toList());
        if (collect.size() == 1) {
            return Optional.of(collect.get(0));
        } else {
            return Optional.empty();
        }
    }
}
