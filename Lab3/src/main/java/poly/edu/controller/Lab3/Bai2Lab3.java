package poly.edu.controller.Lab3;

import poly.edu.model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

public class Bai2Lab3 {
    @RequestMapping("/staff/list")
    public String list(Model model) {
        List<Staff> list = List.of(
                Staff.builder().id("user1@gmail.com").fullname("nguyễn văn user1").photo("user.png").salary(12345.6789).level(0).build(),
                Staff.builder().id("user2@gmail.com").fullname("nguyễn văn user2").photo("user.png").salary(12345.6789).level(1).build(),
                Staff.builder().id("user3@gmail.com").fullname("nguyễn văn user3").photo("user.png").salary(12345.6789).level(2).build(),
                Staff.builder().id("user4@gmail.com").fullname("nguyễn văn user4").photo("user.png").salary(12345.6789).level(2).build(),
                Staff.builder().id("user5@gmail.com").fullname("nguyễn văn user5").photo("user.png").salary(12345.6789).level(1).build(),
                Staff.builder().id("user6@gmail.com").fullname("nguyễn văn user6").photo("user.png").salary(12345.6789).level(0).build()
        );
        model.addAttribute("list", list);
        return "poly/staff-list";
    }
}
