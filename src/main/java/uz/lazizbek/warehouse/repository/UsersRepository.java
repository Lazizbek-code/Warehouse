package uz.lazizbek.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.lazizbek.warehouse.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    boolean existsByUsername(String username);
    boolean existsByPhoneNumber(String phoneNumber);
}
