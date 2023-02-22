package first.teamproject.domain.repository;

import first.teamproject.domain.item.Book;
import first.teamproject.domain.item.Item;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class OracleItemRepositoryTest {

    @Autowired
    OracleBookRepository itemRepository;

    @Test
    void memberSave(){
        Item item = new Book("item1",1000,50,"작가","한음사");
        itemRepository.ItemSave(item);
    }



}