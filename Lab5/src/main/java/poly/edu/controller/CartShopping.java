package poly.edu.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import poly.edu.service.ShoppingCartService;
@Controller
@RequestMapping("/cart")
public class CartShopping {
    @Autowired
    ShoppingCartService cart; // Tiêm Spring Bean đã viết ở bài trước

    // Hiển thị giỏ hàng
    @RequestMapping("/view")
    public String view(Model model) {
        model.addAttribute("cart", cart);
        return "cart/index"; // Giao diện giỏ hàng
    }

    // Thêm sản phẩm vào giỏ
    @RequestMapping("/add/{id}")
    public String add(@PathVariable("id") Integer id) {
        cart.add(id);
        return "redirect:/cart/view";
    }

    // Xóa sản phẩm khỏi giỏ
    @RequestMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id) {
        cart.remove(id);
        return "redirect:/cart/view";
    }

    // Cập nhật số lượng sản phẩm
    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id,
                         @RequestParam("qty") Integer qty) {
        cart.update(id, qty);
        return "redirect:/cart/view";
    }

    // Xóa toàn bộ giỏ hàng
    @RequestMapping("/clear")
    public String clear() {
        cart.clear();
        return "redirect:/cart/view";
    }
}
