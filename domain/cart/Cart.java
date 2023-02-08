package first.teamproject.domain.cart;

import first.teamproject.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {

    private Long id;
    private Item item; // 상품 정보
    private int count; // 상품 수량

    // 생성자
    public Cart(Item item, int count) {
        this.item = item;
        this.count = count;
    }

    // 상품 총 가격
    public int getTotalPrice(){
        return item.getItemPrice() * count;
    }
}
