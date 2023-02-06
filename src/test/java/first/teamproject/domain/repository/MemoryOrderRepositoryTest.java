package first.teamproject.domain.repository;

import first.teamproject.domain.item.Book;
import first.teamproject.domain.item.Item;
import first.teamproject.domain.member.Grade;
import first.teamproject.domain.member.Member;
import first.teamproject.domain.order.Address;
import first.teamproject.domain.order.Delivery;
import first.teamproject.domain.order.Order;
import first.teamproject.domain.order.OrderStatus;
import first.teamproject.domain.repository.interfaces.OrderRepository;
import first.teamproject.domain.service.ItemServiceImpl;
import first.teamproject.domain.service.MemberServiceImpl;
import first.teamproject.domain.service.interfaces.ItemService;
import first.teamproject.domain.service.interfaces.MemberService;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

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
                new Address("city","street","zipcode"),
                "email",
                "101-2131-5135"
        );
        memberService.join(member);

        Item item1 =new Book("itemName",1000,50,"author","publisher");
        itemService.insert(item1);

        Delivery delivery =new Delivery();


        Order order=new Order(1L,member,delivery, LocalDateTime.now(),OrderStatus.ORDER);
        repository.OrderSave(order);

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