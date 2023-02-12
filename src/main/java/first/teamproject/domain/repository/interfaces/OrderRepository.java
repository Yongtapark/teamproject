package first.teamproject.domain.repository.interfaces;

import first.teamproject.domain.order.Order;
import first.teamproject.domain.order.OrderItem;

import java.util.List;

public interface OrderRepository {
    Order OrderSave(Order order);
    void OrderDelete(Order order);
    void OrderUpdate(Long orderId, Order order, OrderItem orderItem);
    List<Order> OrderFindAll();
    Order OrderFindByNo(Long orderNo);
    void OrderClear();


}
