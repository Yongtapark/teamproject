/*
package first.teamproject.web.item;

import hello.itemservice.domain.item.*;
import hello.itemservice.domain.item.impl.ItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller a
@RequestMapping("/basic/items")
@RequiredArgsConstructor // 초기화 되지 않게 알아서 실행되는 녀석
public class BasicItemController {
    @Autowired
    ItemServiceImpl itemService;

    @GetMapping
    public String items(Model model) {
        model.addAttribute("items", itemService.getBoardList());
        return "items";
    }

    @GetMapping("/{itemId}")
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
    }
}


*/
