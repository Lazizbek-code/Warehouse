package uz.lazizbek.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.lazizbek.warehouse.entity.Measurement;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
    boolean existsByName(String name);
}
