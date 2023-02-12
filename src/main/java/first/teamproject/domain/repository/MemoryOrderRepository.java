package first.teamproject.domain.repository;

import first.teamproject.domain.item.Item;
import first.teamproject.domain.order.Order;
import first.teamproject.domain.order.OrderItem;
import first.teamproject.domain.repository.interfaces.OrderRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryOrderRepository implements OrderRepository {
    private static final Map<Long, Order> store=new HashMap<>();
    private static long sequence=0L;

    @Override
    public Order OrderSave(Order Order) {
        Order.setOrderNo(sequence++);
        store.put(Order.getOrderNo(),Order);
        return Order;
    }


    @Override
    public void OrderDelete(Order order) {
        store.remove(order.getOrderNo());
    }


    @Override
    public void OrderUpdate(Long orderNo, Order order, OrderItem orderItem) {
        Order updateOrder = store.get(orderNo);
        updateOrder.setOrderItems(orderItem.getOrder().getOrderItems());
    }

    @Override
    public List<Order> OrderFindAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Order OrderFindByNo(Long OrderNo) {
        return store.get(OrderNo);
    }

    @Override
    public void OrderClear() {
        store.clear();
    }
}
