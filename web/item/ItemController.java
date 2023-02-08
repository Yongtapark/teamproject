package first.teamproject.web.item;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/itsponge")
public class ItemController {

    @GetMapping("/{itemid}/detail")
    String getDetail(){
        return "itsponge/item/itemDetail";
    }

}
