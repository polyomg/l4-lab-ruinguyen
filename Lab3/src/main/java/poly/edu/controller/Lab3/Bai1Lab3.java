package poly.edu.controller.Lab3;

import poly.edu.model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class Bai1Lab3 {
    @RequestMapping("/staff/detail")
    public String detail(Model model) {
        Staff staff = Staff.builder()
                .id("user@gmail.com")
                .fullname("nguyễn văn user")
                .level(1)
                .build();

        model.addAttribute("staff", staff);
        return "poly/staff-detail";
    }
}
