package tarkov.notifier.telegram;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import tarkov.notifier.deal.profit.Profit;
import tarkov.notifier.deal.profit.TelegramMessage;
import tarkov.notifier.market.TMarketException;
import tarkov.notifier.telegram.storage.TelegramUser;
import tarkov.notifier.telegram.storage.UsersRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public abstract class DealNotificationBot extends TelegramLongPollingBot {
    public static final int MIN_PROFIT_PERCENTS = 15;
    public static final int MIN_PROFIT_ROUBLES = 100000;
    public static final int MAX_PROFITS_IN_A_MESSAGE = 15;
    protected final UsersRepository usersRepository = UsersRepository.instance();

    public void send(Map<String, List<Profit>> dealCategoriesToDeals) {
        dealCategoriesToDeals.forEach(this::broadcastToActives);
    }

    public void send(String title, List<Profit> dealProfits) {
        broadcastToActives(title, dealProfits);
    }

    protected void broadcastToActives(String category, List<Profit> profits) {
        List<Profit> filteredProfits = profits.stream().filter(ifUseful()).limit(MAX_PROFITS_IN_A_MESSAGE)
                .sorted(sortProfitsComparator())
                .collect(Collectors.toList());
        TelegramMessage message = generateMessage(category, filteredProfits);
        for (TelegramUser receiver : usersRepository.getReceivers()) {
            sendTextMessage(message, receiver);
        }
    }

    protected Comparator<? super Profit> sortProfitsComparator() {
        return (o1, o2) -> o2.getProfit() - o1.getProfit();
    }

    protected abstract TelegramMessage generateMessage(String category, List<Profit> filteredProfits);

    protected Predicate<Profit> ifUseful() {
        return profit -> (profit.getProfit() > MIN_PROFIT_ROUBLES) ||
                (profit.getProfitPercents() > MIN_PROFIT_PERCENTS);
    }

    protected void sendTextMessage(TelegramMessage message, TelegramUser receiver) {
        SendMessage sendMessage = new SendMessage(receiver.getChatId(), message.generateMessage());
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error("Can't send message", e);
            throw new TMarketException(e);
        }
    }
}
