package uz.lazizbek.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.lazizbek.warehouse.entity.InputProduct;

import java.util.List;

@Repository
public interface InputProductRepository extends JpaRepository<InputProduct, Integer> {
    List<InputProduct>findAllByInputId(Integer input_id);
}
