package uz.lazizbek.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.lazizbek.warehouse.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    boolean existsByNameAndCategoryId(String name, Integer category_id);
}
