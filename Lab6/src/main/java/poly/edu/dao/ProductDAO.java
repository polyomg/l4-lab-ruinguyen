package poly.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.edu.entity.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {
}
