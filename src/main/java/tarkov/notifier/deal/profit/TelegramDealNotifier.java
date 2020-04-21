package tarkov.notifier.deal.profit;

import tarkov.notifier.deal.Deal;
import tarkov.notifier.deal.barter.Barter;
import tarkov.notifier.deal.craft.Craft;
import tarkov.notifier.telegram.barter.BarterNotificationBot;
import tarkov.notifier.telegram.craft.CraftNotificationBot;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TelegramDealNotifier {
    private CraftNotificationBot craftNotificationBot = new CraftNotificationBot();
    private BarterNotificationBot barterNotificationBot = new BarterNotificationBot();

    public void processDeals(Collection<Profit> profits) {
        List<Profit> barters = profits.stream().filter(instanceOf(Barter.class))
                .sorted(expensiveFirst()).collect(Collectors.toList());
        List<Profit> crafts = profits.stream().filter(instanceOf(Craft.class))
                .sorted(expensiveFirst()).collect(Collectors.toList());
//        Map<String, List<Profit>> barterCategoriesToBarters = getDealCategoriesToDeals(profits, Barter.class);
//        Map<String, List<Profit>> craftCategoriesToCrafts = getDealCategoriesToDeals(profits, Craft.class);
        barterNotificationBot.send("Barter", barters);
        craftNotificationBot.send("Crafts", crafts);
    }

    private Map<String, List<Profit>> getDealCategoriesToDeals(Collection<Profit> profits, Class<? extends Deal> dealClass) {
        List<Profit> barters = profits.stream()
                .filter(instanceOf(dealClass))
                .collect(Collectors.toList());
        List<String> categories = barters.stream()
                .map(profit -> profit.getDeal().category())
                .collect(Collectors.toList());
        Map<String, List<Profit>> categoryToBarterProfits = new HashMap<>();
        for (String category : categories) {
            List<Profit> profitsByCategory = barters.stream()
                    .filter(equalCategory(category))
                    .sorted(expensiveFirst())
                    .collect(Collectors.toList());
            categoryToBarterProfits.put(category, profitsByCategory);
        }
        return categoryToBarterProfits;
    }

    private Comparator<Profit> expensiveFirst() {
        return (profit1, profit2) -> profit2.getProfit() - profit1.getProfit();
    }

    private Predicate<Profit> equalCategory(String category) {
        return profit -> category.equals(profit.getDeal().category());
    }

    private Predicate<Profit> instanceOf(Class<? extends Deal> barterClass) {
        return profit -> barterClass.isAssignableFrom(profit.getDeal().getClass());
    }
}
