package first.teamproject.domain.service.interfaces;

import first.teamproject.domain.order.Order;

public interface OrderService {
    Long Order(Long memberNo, Long itemNo, int quantity) throws Exception;

}
