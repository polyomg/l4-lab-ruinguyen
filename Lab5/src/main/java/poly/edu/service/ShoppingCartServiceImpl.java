package poly.edu.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import poly.edu.Enity.Item;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    // Map chứa các mặt hàng trong giỏ, key = id sản phẩm
    Map<Integer, Item> map = new HashMap<>();

    /**
     * Thêm mặt hàng vào giỏ hoặc tăng số lượng lên 1 nếu đã tồn tại
     */
    @Override
    public Item add(Integer id) {
        Item item = map.get(id);
        if (item == null) {
            // Ví dụ tạo sản phẩm giả lập, bạn có thể thay bằng dữ liệu từ DB
            item = new Item(id, "Product " + id, id * 100.0, 1);
            map.put(id, item);
        } else {
            item.setQty(item.getQty() + 1);
        }
        return item;
    }

    /**
     * Xóa mặt hàng khỏi giỏ
     */
    @Override
    public void remove(Integer id) {
        map.remove(id);
    }

    /**
     * Thay đổi số lượng mặt hàng trong giỏ
     */
    @Override
    public Item update(Integer id, int qty) {
        Item item = map.get(id);
        if (item != null) {
            item.setQty(qty);
            if (qty <= 0) {
                map.remove(id);
            }
        }
        return item;
    }

    /**
     * Xóa sạch giỏ hàng
     */
    @Override
    public void clear() {
        map.clear();
    }

    /**
     * Lấy tất cả các mặt hàng trong giỏ
     */
    @Override
    public Collection<Item> getItems() {
        return map.values();
    }

    /**
     * Lấy tổng số lượng các mặt hàng trong giỏ
     */
    @Override
    public int getCount() {
        return map.values().stream()
                .mapToInt(Item::getQty)
                .sum();
    }

    /**
     * Lấy tổng số tiền của giỏ hàng
     */
    @Override
    public double getAmount() {
        return map.values().stream()
                .mapToDouble(item -> item.getPrice() * item.getQty())
                .sum();
    }
}