package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.edu.dao.ProductDAO;
import poly.edu.entity.Category;
import poly.edu.entity.Product;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product") // ✅ Gom tất cả URL con dưới /product
public class ProductController {

    @Autowired
    ProductDAO dao;

    @RequestMapping("/sort")
    public String sort(Model model, @RequestParam("field") Optional<String> field) {
        // Nếu chưa chọn cột thì mặc định sắp xếp theo "price"
        String sortField = field.orElse("price");
        Sort sort = Sort.by(Direction.DESC, sortField);

        // Hiển thị tiêu đề
        model.addAttribute("field", sortField.toUpperCase());

        // Lấy danh sách sản phẩm đã sắp xếp
        List<Product> items = dao.findAll(sort);
        model.addAttribute("items", items);

        return "product/sort";
    }
    @RequestMapping("/page")
    public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Product> page = dao.findAll(pageable);
        model.addAttribute("page", page);
        return "product/page";
    }
    @RequestMapping("/index")
    public String index(Model model) {
        Product item = new Product();
        model.addAttribute("item", item);
        List<Product> items = dao.findAll();
        model.addAttribute("items", items);
        return "product/index";
    }
    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        Product item = dao.findById(id).orElse(new Product());
        model.addAttribute("item", item);
        List<Product> items = dao.findAll();
        model.addAttribute("items", items);
        return "product/index";
    }

    @RequestMapping("/create")
    public String create(Product item) {
        dao.save(item);
        return "redirect:/product/index";
    }

    @RequestMapping("/update")
    public String update(Product item) {
        dao.save(item);
        return "redirect:/product/edit/" + item.getId();
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        dao.deleteById(id);
        return "redirect:/product/index";
    }
}
