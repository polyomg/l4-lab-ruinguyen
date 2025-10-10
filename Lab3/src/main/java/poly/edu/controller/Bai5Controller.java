package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Bai5Controller {

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/Bai5/form")
    public String form() {
        return "poly/bai5";
    }

    @PostMapping("/Bai5Controller/calc")
    public String calculate(Model model) {
        String wStr = request.getParameter("width");
        String lStr = request.getParameter("length");

        model.addAttribute("width", wStr);
        model.addAttribute("length", lStr);

        try {
            double w = Double.parseDouble(wStr);
            double l = Double.parseDouble(lStr);

            if (w <= 0 || l <= 0) {
                model.addAttribute("error", "Chiều dài và chiều rộng phải lớn hơn 0.");
                return "poly/bai5";
            }

            double area = w * l;
            double perimeter = 2 * (w + l);

            model.addAttribute("area", area);
            model.addAttribute("perimeter", perimeter);
        } catch (NumberFormatException e) {
            model.addAttribute("error", "Vui lòng nhập số hợp lệ cho chiều rộng và chiều dài.");
        }

        return "poly/bai5";
    }
}