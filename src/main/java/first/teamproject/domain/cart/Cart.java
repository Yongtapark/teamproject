package first.teamproject.domain.cart;

import first.teamproject.domain.item.Item;
import first.teamproject.domain.order.OrderItem;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cart {

    private Long cartNo;
    private List<OrderItem> orderItems = new ArrayList<>(); // 주문 상품 목록

    // 생성자
    public Cart(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    // 상품 총 가격
    public int getTotalPrice(){
        int totalPrice = 0;
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getItem().getItemPrice() * orderItem.getItemQuantity();
        }
        return totalPrice;
}
    /**

     주문 상품 추가
     @param orderItem 주문 상품
     */
    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

}
