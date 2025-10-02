package poly.edu.controller.Lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import poly.edu.model.Product;
import java.util.Arrays;
import java.util.List;

@Controller

public class Bai4Lab2 {
    @GetMapping("/param4/form")
    public String form(Model model) {
        Product p1 = new Product();
        p1.setName("iPhone 30");
        p1.setPrice(5000.0);
        model.addAttribute("p1", p1);
        model.addAttribute("p2", new Product());
        model.addAttribute("items", getItems());

        return "poly/Bai4Lab2";
    }

    @PostMapping("/param4/save")
    public String save(@ModelAttribute("p2") Product p, Model model) {
        Product p1 = new Product("iPhone 30", 5000.0);

        model.addAttribute("p1", p1);
        model.addAttribute("p2", p);
        model.addAttribute("items", getItems());

        return "poly/Bai4Lab2";
    }

    public List<Product> getItems() {
        return Arrays.asList(
                new Product("A", 1.0),
                new Product("B", 12.0),
                new Product("C", 20.0)
        );
    }
}
