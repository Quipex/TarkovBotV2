package tarkov.notifier;

import lombok.extern.slf4j.Slf4j;
import tarkov.notifier.deal.Deal;
import tarkov.notifier.deal.DealRepository;
import tarkov.notifier.deal.barter.BarterRepository;
import tarkov.notifier.deal.craft.CraftRepository;
import tarkov.notifier.deal.item.ItemsRepository;
import tarkov.notifier.deal.item.ItemsRepositoryStub;
import tarkov.notifier.deal.profit.Profit;
import tarkov.notifier.deal.profit.ProfitCalculator;
import tarkov.notifier.deal.profit.TelegramDealNotifier;
import tarkov.notifier.market.TMarketBridge;
import tarkov.notifier.market.TMarketItem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class Worker {
    private DealRepository[] dealRepositories = {new BarterRepository(), new CraftRepository()};
    private ItemsRepository itemsRepository = ItemsRepositoryStub.instance();
    private TMarketBridge tMarket = new TMarketBridge();
    private Set<String> uidsOfDealItems = new HashSet<>();
    private ProfitCalculator profitCalculator = new ProfitCalculator();
    private TelegramDealNotifier notifier = new TelegramDealNotifier();

    public Worker() {
        for (DealRepository dealRepository : dealRepositories) {
            List<String> dealItemNames = dealRepository.itemNames();
            uidsOfDealItems.addAll(itemsRepository.getUidsByItemNames(dealItemNames));
        }
    }

    public void work() {
        profitCalculator.updatePrices(fetchMarketItems());
        List<Deal> allDeals = new ArrayList<>();
        for (DealRepository dealRepository : dealRepositories) {
            allDeals.addAll(dealRepository.getDeals());
        }
        List<Profit> profits = allDeals.stream().map(deal -> profitCalculator.calculate(deal)).collect(Collectors.toList());
        notifier.processDeals(profits);
    }

    private List<TMarketItem> fetchMarketItems() {
        List<TMarketItem> fetchedMarketItems = new ArrayList<>();
        for (String uid : uidsOfDealItems) {
            fetchedMarketItems.add(tMarket.getItemByUID(uid));
        }
        return fetchedMarketItems;
    }
}
