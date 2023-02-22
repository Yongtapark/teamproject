package first.teamproject.web.main;

import first.teamproject.domain.member.Member;
import first.teamproject.domain.service.MemberServiceImpl;
import first.teamproject.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/com.solponge")
public class HomeController {

   private final MemberServiceImpl memberService;

    @GetMapping("/main")
    public String homeLogin(@SessionAttribute(name = SessionConst.LOGIN_MEMBER,required = false)Member loginMember, Model model){

        //세션에 회원 데이터가 없으면 home
        if(loginMember==null){
            return "main";
        }
        //세션이 유지되면 로그인으로 이동
        model.addAttribute("member",loginMember);
        return "main";
    }
    @GetMapping("/join")
    String getJoin(@ModelAttribute("member") Member member){
        return "member/joinForm";
    }

    @PostMapping("/join")
    public String postJoin(@Validated @ModelAttribute("member") Member member,BindingResult bindingResult){
        log.info("member={}",member);
        if(bindingResult.hasErrors()){
            return "member/joinForm";
        }

        combineString(member); //문자열 합치기 주소,이메일,폰

        Long join = memberService.join(member);
        log.info("joinedMember={}",join);
        return "redirect:addComplete";
    }

    @GetMapping("/member/cart")
    public String cart(@SessionAttribute(name = SessionConst.LOGIN_MEMBER,required = false)Member loginMember, Model model){
        //세션에 회원 데이터가 없으면 home
        if(loginMember==null){
            return "main";
        }
        //로그인 시
        model.addAttribute("member",loginMember);
        return "member/cart";

    }



    private static void combineString(Member member) {
        String address = member.getMEMBER_ADDRESS1() + "/" + member.getMEMBER_ADDRESS2() + "/" + member.getMEMBER_ADDRESS3();
        member.setMEMBER_ADDRESS(address);

        String email = member.getMEMBER_EMAIL1() +"@"+ member.getMEMBER_EMAIL2();
        member.setMEMBER_EMAIL(email);

        String phone = member.getMEMBER_PHONE1() + "-" + member.getMEMBER_PHONE2() + "-" + member.getMEMBER_PHONE3();
        member.setMEMBER_PHONE(phone);
    }


}
