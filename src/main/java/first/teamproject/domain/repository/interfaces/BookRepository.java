package first.teamproject.domain.repository.interfaces;

import first.teamproject.domain.item.Book;

import java.util.List;

public interface BookRepository extends ItemRepository{
    String bookSave(Book book);
    void bookDelete(Book book);
    void bookUpdate(Long bookNo, Book book);
    List<Book> bookFindAll();
    Book bookFindByNo(Long bookNo);
    void bookClear();

}
