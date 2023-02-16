/*
package first.teamproject.web.main;

import first.teamproject.domain.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @GetMapping("/")
    public String main(){
        return "main";
    }
    @GetMapping("/join")
    String joinGet(){
        return "registform";
    }

    @PostMapping("/join")
    String joinPost(@Valid @ModelAttribute("member") Member member, BindingResult bindingResult){
        return "itsponge/registComplete";
    }


}
*/
