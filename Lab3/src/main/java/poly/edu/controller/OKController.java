package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class OKController {

    // Link: http://localhost:8080/ok
    @GetMapping("/poly/ok")
    public String ok() {
        System.out.println("GET /ok -> show form");
        return "poly/ok";
    }

    // OK 1: POST /ctrl/ok (không có param x) -> gọi m1()
    @PostMapping(value = "/ctrl/ok", params = "!x")
    public String m1(Model model) {
        System.out.println("m1() called -> POST /ctrl/ok without param x");
        model.addAttribute("method", "m1");
        return "poly/ok";
    }

    // OK 2: GET /ctrl/ok -> gọi m2()
    @GetMapping("/ctrl/ok")
    public String m2(Model model) {
        System.out.println("m2() called -> GET /ctrl/ok");
        model.addAttribute("method", "m2");
        return "poly/ok";
    }

    // OK 3: POST /ctrl/ok?x  (có param 'x') -> gọi m3()
    @PostMapping(value = "/ctrl/ok", params = "x")
    public String m3(Model model) {
        System.out.println("m3() called -> POST /ctrl/ok with param x");
        model.addAttribute("method", "m3");
        return "poly/ok";
    }
}
