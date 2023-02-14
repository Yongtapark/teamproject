package first.teamproject.domain.order;

import first.teamproject.domain.member.Member;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Order {

    private Long orderNo;
    private Member member;
    private List<OrderItem> orderItems = new ArrayList<>();
    private java.lang.String memberAddress;
    private LocalDateTime orderDate;
    private OrderStatus status;

    private Order() {
    }

    public Order(Member member, java.lang.String memberAddress, LocalDateTime orderDate, OrderStatus status) {
        this.member = member;
        this.memberAddress = memberAddress;
        this.orderDate = orderDate;
        this.status = status;
    }

    @Override
    public java.lang.String toString() {
        return "Order{" +
                "orderNo=" + orderNo +
                ", member=" + member +
                ", orderItems=" + orderItems +
                ", memberAddress=" + memberAddress +
                ", orderDate=" + orderDate +
                ", status=" + status +
                '}';
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public static Order createOrder(Member member, java.lang.String memberAddress, OrderItem...orderItems){
        Order order =new Order();
        order.setMember(member);
        order.setMemberAddress(memberAddress);
        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }
        order.setStatus(OrderStatus.ORDER);
        order.setOrderDate(LocalDateTime.now());
        return order;
    }
    /**
     * 비즈니스로직
     */
    /*주문 취소*/
    public void cancel(){
        this.setStatus(OrderStatus.CANCEL);
        for (OrderItem orderItem : orderItems) {
            orderItem.cancel();
        }
    }

    /**
     * 조회로직
     */
    /*전체 주문 가격 조회*/
    public int getTotalPrice(){
        int totalPrice=0;
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getTotalPrice();
        }
        return totalPrice;
    }
}
