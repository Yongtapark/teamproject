package first.teamproject.domain.service;

import first.teamproject.domain.item.Item;
import first.teamproject.domain.member.Member;
import first.teamproject.domain.order.Order;
import first.teamproject.domain.order.OrderItem;
import first.teamproject.domain.repository.MemoryOrderRepository;
import first.teamproject.domain.repository.OracleMemberRepository;
import first.teamproject.domain.repository.interfaces.ItemRepository;
import first.teamproject.domain.repository.interfaces.MemberRepository;
import first.teamproject.domain.repository.MemoryItemRepository;
import first.teamproject.domain.repository.MemoryMemberRepository;
import first.teamproject.domain.repository.interfaces.OrderRepository;
import first.teamproject.domain.service.interfaces.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository= new MemoryMemberRepository();
    private final ItemRepository itemRepository=new MemoryItemRepository();
    private final OrderRepository orderRepository=new MemoryOrderRepository();

    @Override
    public Long Order(Long memberNo, Long itemNo, int quantity) throws Exception {
        //조회
        Member member = memberRepository.memberFindByNo(memberNo);
        Item item = itemRepository.ItemFindByNo(itemNo);


        //주문상품 생성

            OrderItem orderItem = OrderItem.createOrderItem(item,item.getItemPrice(),quantity);



        //주문생성
        Order order =Order.createOrder(member,member.getMEMBER_ADDRESS());
        order.getOrderItems().add(orderItem);

        orderRepository.OrderSave(order);
        log.info("order={}",order);


        return order.getOrderNo();
    }

}
