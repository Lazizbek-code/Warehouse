package uz.lazizbek.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.lazizbek.warehouse.entity.Users;
import uz.lazizbek.warehouse.entity.Warehouse;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.payload.UsersDto;
import uz.lazizbek.warehouse.repository.UsersRepository;
import uz.lazizbek.warehouse.repository.WarehouseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UsersService {
    @Autowired
    UsersRepository userRepository;
    @Autowired
    WarehouseRepository warehouseRepository;

    public Result add(UsersDto usersDto){
        boolean existsByUsername = userRepository.existsByUsername(usersDto.getUsername());
        if (existsByUsername)
            return new Result("Bunday username mavjud", false);
        boolean existsByPhoneNumber = userRepository.existsByPhoneNumber(usersDto.getPhoneNumber());
        if (existsByPhoneNumber)
            return new Result("Bunday telefon nomer mavjud", false);
        Users users = new Users();
        users.setFirstName(usersDto.getFirstName());
        users.setLastName(usersDto.getLastName());
        users.setPhoneNumber(usersDto.getPhoneNumber());
        users.setPassword(usersDto.getPassword());
        users.setUsername(usersDto.getUsername());
        List<Integer> warehouseId = usersDto.getWarehouses();
        List<Warehouse> warehouses = new ArrayList<>();
        for (int id:warehouseId) {
            Optional<Warehouse> warehouseOptional = warehouseRepository.findById(id);
            warehouseOptional.ifPresent(warehouses::add);
        }
        users.setWarehouses(warehouses);
        Users save = userRepository.save(users);
        return new Result("Ma'lumot saqlandi", true, save);
    }

    public List<Users> getAll(){
        return userRepository.findAll();
    }

    public Users oneUsers(Integer id){
        Optional<Users> userOptional = userRepository.findById(id);
        return userOptional.orElseGet(Users::new);
    }
}
