package first.teamproject.domain.repository;

import first.teamproject.domain.item.Book;
import first.teamproject.domain.item.Item;
import first.teamproject.domain.repository.interfaces.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
//@Repository
public class OracleBookRepository implements BookRepository {

    private final SqlSessionTemplate sqlSession;

    @Autowired
    public OracleBookRepository(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public String bookSave(Book book) {
        Map<String,Object> param = new HashMap<>();
        param.put("book_name", book.getItemName());
        param.put("book_price", book.getItemPrice());
        param.put("book_quantity",book.getItemQuantity());
        param.put("book_author", book.getBookAuthor());
        param.put("book_publisher", book.getBookPublisher());

        sqlSession.insert("book.insertItem", param);
        return param.get("BOOK_NO").toString();
    }

    @Override
    public void bookDelete(Book book) {

    }

    @Override
    public void bookUpdate(Long bookNo, Book book) {

    }

    @Override
    public List<Book> bookFindAll() {
        return null;
    }

    @Override
    public Book bookFindByNo(Long bookNo) {
        return null;
    }

    @Override
    public void bookClear() {

    }


    @Override
    public Item ItemSave(Item item) {
        return null;
    }

    @Override
    public void ItemDelete(Item item) {

    }

    @Override
    public void ItemUpdate(Long itemId, Item item) {

    }

    @Override
    public List<Item> ItemFindAll() {
        return null;
    }

    @Override
    public Item ItemFindByNo(Long itemNo) {
        return null;
    }

    @Override
    public void ItemClear() {

    }
}
