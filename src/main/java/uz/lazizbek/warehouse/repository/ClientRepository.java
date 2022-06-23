package uz.lazizbek.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.lazizbek.warehouse.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
}
