package first.teamproject.domain.service;

import first.teamproject.domain.item.Book;
import first.teamproject.domain.item.Item;
import first.teamproject.domain.member.Grade;
import first.teamproject.domain.member.Member;
import first.teamproject.domain.order.OrderItem;
import first.teamproject.domain.order.OrderStatus;
import first.teamproject.domain.order.String;
import first.teamproject.domain.order.Order;
import first.teamproject.domain.repository.MemoryItemRepository;
import first.teamproject.domain.repository.MemoryOrderRepository;
import first.teamproject.domain.repository.interfaces.ItemRepository;
import first.teamproject.domain.repository.interfaces.OrderRepository;
import first.teamproject.domain.service.interfaces.ItemService;
import first.teamproject.domain.service.interfaces.MemberService;
import first.teamproject.domain.service.interfaces.OrderService;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
                "asdasdasdasdas",
                "email",
                "101-2131-5135"
        );
        memberService.join(member);
        Item item1 =new Book("itemName",1000,50,"author","publisher");
        Item item2 =new Book("itemName2",2000,20,"author","publisher");


        itemService.insert(item1);
        itemService.insert(item2);
        List<Item> items = itemRepository.ItemFindAll();

        OrderItem orderItem1 =new OrderItem();
        orderItem1.setOrderItemNo(item1.getItemNo());
        orderItem1.setItemQuantity(3);
        OrderItem orderItem2 =new OrderItem();
        orderItem2.setOrderItemNo(item2.getItemNo());
        orderItem2.setItemQuantity(3);




        assertThat(itemRepository.ItemFindAll()).contains(item1,item2);
        int itemQuantity = itemRepository.ItemFindByNo(item2.getItemNo()).getItemQuantity();

        Order newOrder =new Order(member,"asdasd", LocalDateTime.now(), OrderStatus.ORDER);
        newOrder.addOrderItem(orderItem1);
        newOrder.addOrderItem(orderItem2);

        //when
    

       Long order = orderService.Order(member.getMemberNo(),item1.getItemNo(),3);
        order = orderService.Order(member.getMemberNo(), item2.getItemNo(), 5);
        Order order1 = orderRepository.OrderFindByNo(order);

        //then
        assertThat(itemRepository.ItemFindByNo(item1.getItemNo()).getItemQuantity()).isEqualTo(47);
        assertThat(itemRepository.ItemFindByNo(item2.getItemNo()).getItemQuantity()).isEqualTo(15);
        assertThat(itemRepository.ItemFindByNo(item1.getItemNo()).getItemName()).isEqualTo("itemName");
        assertThat(itemRepository.ItemFindByNo(item2.getItemNo()).getItemName()).isEqualTo("itemName2");
        assertThat(order1.getTotalPrice()).isEqualTo(11000);






    }
    @Test
    void test() throws Exception {

        //given
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
        Item item2 =new Book("itemName2",2000,20,"author","publisher");


        itemService.insert(item1);
        itemService.insert(item2);
        List<Item> items = itemRepository.ItemFindAll();

        OrderItem orderItem1 =new OrderItem();
        orderItem1.setOrderItemNo(item1.getItemNo());
        orderItem1.setItemQuantity(3);
        OrderItem orderItem2 =new OrderItem();
        orderItem2.setOrderItemNo(item2.getItemNo());
        orderItem2.setItemQuantity(3);

        long order = orderService.Order(member.getMemberNo(), item1.getItemNo(), 3);
        order = orderService.Order(member.getMemberNo(), item2.getItemNo(), 5);
        Order order1 = orderRepository.OrderFindByNo(order);

//then
        for (OrderItem orderItem : order1.getOrderItems()) {
            if (orderItem.getItem().getItemNo() == item1.getItemNo()) {
                assertThat(orderItem.getItem().getItemPrice()).isEqualTo(3000);
                assertThat(orderItem.getItemQuantity()).isEqualTo(3);
                assertThat(orderItem.getTotalPrice()).isEqualTo(9000);
            } else if (orderItem.getItem().getItemNo() == item2.getItemNo()) {
                assertThat(orderItem.getItem().getItemPrice()).isEqualTo(2000);
                assertThat(orderItem.getItemQuantity()).isEqualTo(5);
                assertThat(orderItem.getTotalPrice()).isEqualTo(10000);
            }
        }

    }

}