package first.teamproject.domain.repository;

import first.teamproject.domain.item.Item;
import first.teamproject.domain.repository.interfaces.ItemRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryItemRepository implements ItemRepository {
    private static final Map<Long, Item> store=new HashMap<>();
    private static long sequence=0L;

    @Override
    public Item ItemSave(Item item) {
        item.setItemNo(sequence++);
        store.put(item.getItemNo(),item);
        return item;
    }

    @Override
    public void ItemDelete(Item item) {
        store.remove(item.getItemNo());
    }

    @Override
    public void ItemUpdate(Long itemId, Item item) {
        Item updateItem = store.get(itemId);
        updateItem.setItemName(item.getItemName());
        updateItem.setItemPrice(item.getItemPrice());
        updateItem.setItemQuantity(item.getItemQuantity());
    }

    @Override
    public List<Item> ItemFindAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Item ItemFindByNo(Long itemNo) {
        return store.get(itemNo);
    }

    @Override
    public void ItemClear() {
        store.clear();
    }
}
