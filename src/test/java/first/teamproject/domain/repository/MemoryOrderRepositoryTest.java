package first.teamproject.domain.repository;

import first.teamproject.domain.item.Book;
import first.teamproject.domain.item.Item;
import first.teamproject.domain.member.Grade;
import first.teamproject.domain.member.Member;
import first.teamproject.domain.order.*;
import first.teamproject.domain.order.String;
import first.teamproject.domain.repository.interfaces.OrderRepository;
import first.teamproject.domain.service.ItemServiceImpl;
import first.teamproject.domain.service.MemberServiceImpl;
import first.teamproject.domain.service.interfaces.ItemService;
import first.teamproject.domain.service.interfaces.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class MemoryOrderRepositoryTest {
    OrderRepository repository=new MemoryOrderRepository();
    MemberService memberService =new MemberServiceImpl();
    ItemService itemService = new ItemServiceImpl(new MemoryItemRepository());

    @Test
    void orderSave() {
        Member member=new Member(
                Grade.ADMIN,
                "memberId",
                "memberPassword",
                "memberName",
               "asdasdasdasdas",
                "email",
                "101-2131-5135"
        );
        memberService.join(member);

        Item item1 =new Book("itemName",1000,50,"author","publisher");
        Item item2 =new Book("itemNam2",10020,52,"author2","publisher2");
        itemService.insert(item1);
        itemService.insert(item2);

        OrderItem orderItem1 =new OrderItem();
        orderItem1.setOrderItemNo(item1.getItemNo());
        orderItem1.setItemQuantity(3);
        OrderItem orderItem2 =new OrderItem();
        orderItem2.setOrderItemNo(item2.getItemNo());
        orderItem2.setItemQuantity(3);


        Delivery delivery =new Delivery();


        Order order=new Order(member, member.getMemberAddress(), LocalDateTime.now(),OrderStatus.ORDER);
        Order asdasdas = order.createOrder(member, "asdasdas", orderItem1, orderItem2);
        repository.OrderSave(order);
        repository.OrderSave(asdasdas);

        //validation
        Order order1 = repository.OrderFindByNo(1L);
        Assertions.assertThat(order1.getOrderItems()).contains(orderItem1,orderItem2);


    }

    @Test
    void orderDelete() {
    }

    @Test
    void orderUpdate() {
    }

    @Test
    void orderFindAll() {
    }

    @Test
    void orderFindByNo() {
    }

    @Test
    void orderClear() {
    }
}