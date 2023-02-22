/*
package first.teamproject.web.item;


import first.teamproject.domain.member.Member;
import first.teamproject.domain.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/com.solponge")
@RequiredArgsConstructor // 초기화 되지 않게 알아서 실행되는 녀석
@Slf4j
public class BasicItemController {
    @Autowired
    MemberServiceImpl memberService;

    //회원가입
    @GetMapping("/join")
    public String getJoin(@ModelAttribute("member") Member member) {
        return "register";
    }

    @PostMapping("/join")
    public String postJoin(@ModelAttribute("member") Member member){
        log.info("member={}",member);
        Long join = memberService.join(member);
        log.info("joinedMember={}",join);
        return "main";
    }
    //회원가입
    */
/*@GetMapping("")
    public String item(@PathVariable Long itemId, Model model) {
        Item item = itemService.getBoard(itemId);
        System.out.println(itemId);
        model.addAttribute("item", item);
        return "item";
    }
    @GetMapping("/add")
    public String addForm() {
        return "addForm";
    }
    @PostMapping("/add")
    public String addItemV6(Item item, RedirectAttributes redirectAttributes) {
        String itemId = itemService.insertBoard(item);
        redirectAttributes.addAttribute("itemId", itemId);
        redirectAttributes.addAttribute("status", "add");

        return "redirect:/basic/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        System.out.println(itemId);
        Item item = itemService.getBoard(itemId);
        model.addAttribute("item", item);
        return "editForm";
    }
    @GetMapping("/{itemId}/delete")
    public String delete(@PathVariable Long itemId) {
        System.out.println(itemId);
        itemService.deleteBoard(itemId);
        return "redirect:/basic/items";
    }
    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item, RedirectAttributes redirectAttributes) {
        itemService.updateBoard(item);
        redirectAttributes.addAttribute("status", "edit");
        System.out.println("호출됨");
        return "redirect:./";
    }*//*

}


*/
