package first.teamproject.domain.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book extends Item {
    private String BookAuthor;
    private String BookPublisher;


    public Book(String itemName, int itemPrice, int itemStock, String bookAuthor, String bookPublisher) {
        super(itemName, itemPrice, itemStock);
        BookAuthor = bookAuthor;
        BookPublisher = bookPublisher;
    }
}
