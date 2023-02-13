package first.teamproject.domain.service;

import first.teamproject.domain.item.Book;
import first.teamproject.domain.item.Item;
import first.teamproject.domain.repository.MemoryItemRepository;
import first.teamproject.domain.service.interfaces.ItemService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemServiceImplTest {
    MemoryItemRepository repository=new MemoryItemRepository();
    ItemService service = new ItemServiceImpl(repository);

    @AfterEach
    void afterEach(){
        repository.ItemClear();
    }

    @Test
    void insert() {
        Item item =new Book("itemName",1000,50,"author","publisher");
        Item insertItem = service.insert(item);
        assertThat(insertItem).isEqualTo(item);
    }

    @Test
    void update() {
        //given
        Item item =new Book("itemName",1000,50,"author","publisher");
        Item insertItem = service.insert(item);
        Item updateItem = new Book("itemName2",1002,52,"author","publisher");
        //when
        service.update(insertItem.getItemNo(),updateItem);
        assertThat(insertItem.getItemName()).isEqualTo(updateItem.getItemName());
        assertThat(insertItem.getItemPrice()).isEqualTo(1002);
        //then

    }

    @Test
    void delete() {
        //given
        Item item =new Book("itemName",1000,50,"author","publisher");
        Item insertItem = service.insert(item);
        //when
        service.delete(insertItem);

        //then
        assertThat(repository.ItemFindByNo(item.getItemNo())).isNull();

    }

    @Test
    void findByNo() {
        //given
        Item item =new Book("itemName",1000,50,"author","publisher");
        Item insertItem = service.insert(item);
        //when
        Item findItem = service.findByNo(item.getItemNo());
        //then
        assertThat(findItem).isEqualTo(item);
    }

    @Test
    void findAll() {
        //given
        Item item1 =new Book("itemName",1000,50,"author","publisher");
        Item item2 =new Book("itemName2",10002,502,"author","publisher");
        service.insert(item1);
        service.insert(item2);
        //when
        List<Item> itemList = service.findAll();
        //then
        assertThat(itemList.size()).isEqualTo(2);
        assertThat(itemList).contains(item1,item2);
    }
}