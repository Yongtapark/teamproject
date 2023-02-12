package first.teamproject.domain.service.interfaces;

import first.teamproject.domain.item.Item;

import java.util.List;

public interface ItemService {
    Item insert(Item item);
    void update(Long itemNo, Item item);
    void delete(Item item);
    Item findByNo(Long itemNo);
    List<Item> findAll();
}
