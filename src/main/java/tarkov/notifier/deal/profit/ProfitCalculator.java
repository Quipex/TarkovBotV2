package tarkov.notifier.deal.profit;

import lombok.extern.slf4j.Slf4j;
import tarkov.notifier.deal.Deal;
import tarkov.notifier.deal.ResourceAmount;
import tarkov.notifier.deal.item.ItemsRepository;
import tarkov.notifier.deal.item.ItemsRepositoryStub;
import tarkov.notifier.market.TMarketException;
import tarkov.notifier.market.TMarketItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

@Slf4j
public class ProfitCalculator {
    private List<TMarketItem> marketItems;
    private ItemsRepository itemsRepository = ItemsRepositoryStub.instance();

    public void updatePrices(List<TMarketItem> marketItems) {
        checkNotNull(marketItems);
        this.marketItems = marketItems;
    }

    public Profit calculate(Deal deal) {
        checkNotNull(deal);
        TMarketItem resultItem = getTMarketItem(deal.getItemName());
        List<ResourceAmount> resources = deal.getResources();
        Map<ResourceAmount, Integer> resourcesToPrice = new HashMap<>();
        for (ResourceAmount resource : resources) {
            TMarketItem foundItem = getTMarketItem(resource.getName());
            resourcesToPrice.put(resource, resourcePrice(foundItem));
        }
        Profit profit = new Profit(resultPrice(resultItem), deal, resourcesToPrice);
        profit.calculate();
        return profit;
    }

    /**
     * @return max of 24h and last price as we need the highest price not to fake our expectations
     */
    private int resourcePrice(TMarketItem resource) {
        return Math.max(resource.getAvg24hPrice(), resource.getPrice());
    }

    /**
     * @return min of 24h and last price as we need the lowest price not to fake our expectations
     */
    private int resultPrice(TMarketItem resultItem) {
        return Math.min(resultItem.getAvg24hPrice(), resultItem.getPrice());
    }

    private TMarketItem getTMarketItem(String resultItemName) {
        String resultItemUid = itemsRepository.getUidByItemName(resultItemName);
        return getItemOfUid(resultItemUid);
    }

    private TMarketItem getItemOfUid(String resultItemUid) {
        List<TMarketItem> items = marketItems.stream()
                .filter(item -> item.getUid().equals(resultItemUid)).collect(Collectors.toList());
        if (items.size() != 1) {
            TMarketException tMarketException = new TMarketException("Wrong list size");
            log.error("Must have found 1 item, but found {}", items.size(), tMarketException);
            throw tMarketException;
        }
        return items.get(0);
    }
}
