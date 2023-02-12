package first.teamproject.domain.repository.interfaces;

import first.teamproject.domain.item.Item;

import java.util.List;

public interface ItemRepository {
    Item ItemSave(Item item);
    void ItemDelete(Item item);
    void ItemUpdate(Long itemId, Item item);
    List<Item>  ItemFindAll();
    Item ItemFindByNo(Long itemNo);
    void ItemClear();


}
