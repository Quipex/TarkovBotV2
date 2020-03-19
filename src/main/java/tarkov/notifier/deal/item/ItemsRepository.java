package tarkov.notifier.deal.item;

import java.util.Collection;
import java.util.Set;

public interface ItemsRepository {
    String getUidByItemName(String itemName);
    Set<String> getUidsByItemNames(Collection<String> itemNames);

    String getItemNameByUid(String uid);
    Set<String> getItemNamesByUids(Collection<String> uid);
}
