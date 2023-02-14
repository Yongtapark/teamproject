package first.teamproject.domain.order;

import first.teamproject.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItem {

    private Long orderItemNo;
    private Item item; //주문상품
    private Order order;
    private int orderPrice;
    private int itemQuantity;

    /**
     * 생성메서드
     **/
    public static OrderItem createOrderItem(Item item, int orderPrice, int itemQuantity) throws Exception {
       OrderItem orderItem =new OrderItem();
       orderItem.setItem(item);
       orderItem.setOrderPrice(orderPrice);
       orderItem.setItemQuantity(itemQuantity);

        item.removeQuantity(itemQuantity);
       return orderItem;
    }

    /**
     * 비즈니스 로직
     */
    /*주문취소*/
    public void cancel(){
        getItem().addQuantity(itemQuantity);
    }
    /**
     * 조회로직
     */
    /*주문상품 전체 가격 조회*/
    public int getTotalPrice(){
        return getOrderPrice()*getItemQuantity();
    }

}
