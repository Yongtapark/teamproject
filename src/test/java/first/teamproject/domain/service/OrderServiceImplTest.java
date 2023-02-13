package first.teamproject.domain.service;

import first.teamproject.domain.item.Book;
import first.teamproject.domain.item.Item;
import first.teamproject.domain.member.Grade;
import first.teamproject.domain.member.Member;
import first.teamproject.domain.order.Address;
import first.teamproject.domain.order.Order;
import first.teamproject.domain.order.OrderItem;
import first.teamproject.domain.repository.MemoryItemRepository;
import first.teamproject.domain.repository.MemoryMemberRepository;
import first.teamproject.domain.repository.MemoryOrderRepository;
import first.teamproject.domain.repository.interfaces.ItemRepository;
import first.teamproject.domain.repository.interfaces.MemberRepository;
import first.teamproject.domain.repository.interfaces.OrderRepository;
import first.teamproject.domain.service.interfaces.ItemService;
import first.teamproject.domain.service.interfaces.MemberService;
import first.teamproject.domain.service.interfaces.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    ItemService itemService =new ItemServiceImpl(new MemoryItemRepository());
    MemberService memberService=new MemberServiceImpl();
    OrderService orderService =new OrderServiceImpl();
    OrderRepository orderRepository =new MemoryOrderRepository();
    ItemRepository itemRepository=new MemoryItemRepository();

    @Test
    void order() throws Exception {
        //given
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
        Item item2 =new Book("itemName2",2000,20,"author","publisher");


        itemService.insert(item1);
        itemService.insert(item2);
        List<Item> items = itemRepository.ItemFindAll();

        assertThat(itemRepository.ItemFindAll()).contains(item1,item2);
        int itemQuantity = itemRepository.ItemFindByNo(item2.getItemNo()).getItemQuantity();

        //when
       Long order = orderService.Order(member.getMemberNo(),item1.getItemNo(),3);
        Order order1 = orderRepository.OrderFindByNo(order);

        //then
        assertThat(itemRepository.ItemFindByNo(item1.getItemNo()).getItemQuantity()).isEqualTo(47);
        assertThat(itemRepository.ItemFindByNo(item1.getItemNo()).getItemName()).isEqualTo("itemName");


    }
}