package first.teamproject.domain.service;

import first.teamproject.domain.item.Item;
import first.teamproject.domain.repository.interfaces.ItemRepository;
import first.teamproject.domain.repository.MemoryItemRepository;
import first.teamproject.domain.service.interfaces.ItemService;

import java.util.ArrayList;
import java.util.List;

public class ItemServiceImpl implements ItemService {
    ItemRepository repository;

    public ItemServiceImpl(MemoryItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public Item insert(Item item) {
        Item insertItem = repository.ItemSave(item);
        return insertItem;
    }

    @Override
    public void update(Long itemNo, Item item) {
        repository.ItemUpdate(itemNo,item);
    }

    @Override
    public void delete(Item item) {
        repository.ItemDelete(item);
    }

    @Override
    public Item findByNo(Long itemNo) {
        return repository.ItemFindByNo(itemNo);
    }

    @Override
    public List<Item> findAll() {
        return new ArrayList<>(repository.ItemFindAll());
    }
}
