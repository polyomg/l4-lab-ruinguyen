package poly.edu.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import poly.edu.service.*;

@Controller
public class AuthController {
    @Autowired
    CookieService cookieService;
    @Autowired
    ParamService paramService;
    @Autowired
    SessionService sessionService;
    // Hiển thị form đăng nhập
    @GetMapping("/account/login")
    public String login1(Model model) {
        // Đọc cookie "user" nếu có để hiển thị sẵn tên tài khoản
        String savedUser = cookieService.getValue("user");
        model.addAttribute("savedUser", savedUser);
        return "/account/login";
    }

    // Xử lý đăng nhập
    @PostMapping("/account/login")
    public String login2(Model model) {
        // 1️⃣ Đọc tham số từ form
        String username = paramService.getString("username", "");
        String password = paramService.getString("password", "");
        boolean remember = paramService.getBoolean("remember", false);

        // 2️⃣ Kiểm tra đăng nhập
        if ("poly".equals(username) && "123".equals(password)) {
            // ✅ Đăng nhập thành công

            // Lưu username vào session
            sessionService.set("username", username);

            // Xử lý "Remember me"
            if (remember) {
                // Ghi nhớ tài khoản trong 10 ngày
                cookieService.add("user", username, 10 * 24);
            } else {
                // Xóa cookie nếu người dùng không chọn ghi nhớ
                cookieService.remove("user");
            }

            // Thông báo
            model.addAttribute("message", "Đăng nhập thành công!");
            return "redirect:/item/index"; // có thể đổi sang trang chính của bạn
        } else {
            // ❌ Đăng nhập thất bại
            model.addAttribute("message", "Sai tên đăng nhập hoặc mật khẩu!");
            return "/account/login";
        }
    }
}
