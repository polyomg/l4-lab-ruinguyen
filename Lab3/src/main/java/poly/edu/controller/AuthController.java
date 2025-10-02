package poly.edu.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    HttpServletRequest request;

    @GetMapping("/login/form")
    public String form() {
        return "poly/login";
    }

    @PostMapping("/login/check")
    public String login(Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (!"poly".equals(username) && !"123".equals(password)) {
            model.addAttribute("message", "Sai username!  Sai password!");
        }
        else if (!"poly".equals(username)) {
            model.addAttribute("message", "Sai username!");
        }
        else if (!"123".equals(password)) {
            model.addAttribute("message", "Sai password!");
        }
        else {
            model.addAttribute("message", "Đăng nhập thành công!");
        }

        return "poly/login";
    }
}
