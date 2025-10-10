package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.edu.database.DB;

@Controller
public class ItemController {

    @RequestMapping("/item/index")
    public String list(Model model) {
        // Gửi danh sách sản phẩm sang view
        model.addAttribute("items", DB.items.values());
        return "item/index"; // trỏ tới templates/item/index.html
    }
}
