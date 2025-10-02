package poly.edu.controller.Lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import poly.edu.model.Product;

@Controller

public class ProductController {
    @GetMapping("/product/form")
    public String form(Model model) {
        model.addAttribute("product", new Product());
        return "poly/ThongTInsp";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute("product") Product product, Model model) {
        model.addAttribute("name", product.getName());
        model.addAttribute("price", product.getPrice());
        return "poly/ThongTInsp";
    }
}
