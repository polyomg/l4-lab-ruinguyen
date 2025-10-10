package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hellocontroller {
    @GetMapping("/poly/hello")
    public String hello(){
        return"poly/hello";
    }

}
