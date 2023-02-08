package first.teamproject.web.mypage;

import first.teamproject.domain.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/itsponge/{memberid}")
public class memberController {
    @GetMapping
    String getmember(@ModelAttribute("member")Member member){
        return "itsponge/mypage/member";
    }

    @GetMapping("/mypage/updatemember")
    String getUpdateMember() {
        return"itsponge/mypage/updateMember";
    }

   /* @PostMapping("/member/updatemember")
    String postUpdateMember() {
        return null;
    }*/

    @GetMapping("/mypage/orders")
    String getOrders() {
        return"itsponge/mypage/orders";
    }

    @GetMapping("/mypage/orders/{orderid}")
    String getOrdersDetail() {
        return"itsponge/mypage/ordersDetail";
    }

    @GetMapping("/mypage/cart")
    String getCart() {
        return"itsponge/mypage/cart";
    }

    @GetMapping("/payment/{orderid}")
    String getPayment(){
       return "itsponge/mypage/payment";
    }

}
