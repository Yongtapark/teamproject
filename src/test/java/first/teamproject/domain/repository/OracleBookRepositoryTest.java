package first.teamproject.domain.repository;

import first.teamproject.domain.item.Book;
import first.teamproject.domain.item.Item;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class OracleBookRepositoryTest {
    @Autowired
    OracleBookRepository oracleBookRepository;
    @Test
    void save(){
        Book book = new Book("item1",1000,50,"작가","한음사");
        oracleBookRepository.bookSave(book);
    }


}