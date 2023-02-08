package first.teamproject.domain.order;
import first.teamproject.domain.cart.Cart;
import first.teamproject.domain.member.Member;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**

 주문 관련 클래스
 */
@Getter
@Setter
public class Order {

    private Long orderNo; // 주문 번호
    private Member member; // 주문 회원
    private List<OrderItem> orderItems = new ArrayList<>(); // 주문 상품 목록
    private Delivery delivery; // 배송 정보
    private LocalDateTime orderDate; // 주문 날짜
    private OrderStatus status; // 주문 상태

    private Cart cart;

    /**

     기본 생성자 (외부에서 호출 불가)
     */
    private Order() {
    }
    /**

     주문 객체 생성자
     @param orderNo 주문 번호
     @param member 주문 회원
     @param delivery 배송 정보
     @param orderDate 주문 날짜
     @param status 주문 상태
     */
    // 주문 객체 생성 메서드
    public Order(Member member, Delivery delivery, Cart cart){
        this.member = member;
        this.delivery = delivery;
        this.cart = cart;
        this.orderDate = LocalDateTime.now();
    }
    @Override
    public String toString() {
        return "Order{" +
                "orderNo=" + orderNo +
                ", member=" + member +
                ", orderItems=" + orderItems +
                ", delivery=" + delivery +
                ", orderDate=" + orderDate +
                ", status=" + status +
                '}';
    }

    /**

     주문 상품 추가
     @param orderItem 주문 상품
     */
    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
/**

 주문 객체 생성 메서드
 @param member 주문 회원
 @param delivery 배송 정보
 @param orderItems 주문 항목 목록
 @return 생성된 주문 객체
 */
public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) {
    Order order = new Order();
    order.setMember(member);
    order.setDelivery(delivery);
    for (OrderItem orderItem : orderItems) {
        order.addOrderItem(orderItem);
    }
    order.setStatus(OrderStatus.ORDER);
    order.setOrderDate(LocalDateTime.now());
    return order;
}
}