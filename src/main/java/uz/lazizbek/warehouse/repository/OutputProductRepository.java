package uz.lazizbek.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.lazizbek.warehouse.entity.OutputProduct;

import java.util.List;

@Repository
public interface OutputProductRepository extends JpaRepository<OutputProduct, Integer> {
    List<OutputProduct> findAllByOutputId(Integer output_id);
}
