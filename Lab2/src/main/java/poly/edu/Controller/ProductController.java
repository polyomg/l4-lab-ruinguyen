package poly.edu.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.entity.product;

import java.util.*;

@Controller
public class ProductController {
    @GetMapping("/product/form")
    public String form(Model model) {
        product p = new product();
        p.setName("iPhone 30");
        p.setPrice(5000.0);
        model.addAttribute("p1", p);
        model.addAttribute("p2", new product());
        return "product/form";
    }

    @PostMapping("/product/save")
    public String save( @ModelAttribute("p2") product p, Model model) {
        model.addAttribute("p1", new product("iPhone 30", 5000.0));
        model.addAttribute("p2", p);
        return "product/form";
    }
    @ModelAttribute("items")
    public List<product> getItems() {
        return Arrays.asList(
                new product("product1", 200000.0),
                new product("product2", 300000.0),
                new product("product3", 30000.0),
                new product("product4", 400000.0),
                new product("product5", 500000.0),
                new product("product6", 600000.0),
                new product("product7", 700000.0),
                new product("product8", 800000.0),
                new product("product9", 900000.0),
                new product("product10", 1000000.0),
                new product("product11", 1100000.0),
                new product("product12", 1200000.0),
                new product("product13", 1300000.0),
                new product("product14", 1400000.0),
                new product("product15", 1500000.0),
                new product("product16", 1600000.0),
                new product("product17", 1700000.0),
                new product("product18", 1800000.0),
                new product("product19", 19000000.0),
                new product("product20", 20000000.0)
        );
    }
}
