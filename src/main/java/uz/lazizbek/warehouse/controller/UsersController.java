package uz.lazizbek.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.lazizbek.warehouse.entity.Users;
import uz.lazizbek.warehouse.entity.Warehouse;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.payload.UsersDto;
import uz.lazizbek.warehouse.service.UsersService;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping
    public List<Users> getAll(){
        return usersService.getAll();
    }

    @GetMapping("/{id}")
    public Users oneUsers(@PathVariable Integer id){
        return usersService.oneUsers(id);
    }

    @PostMapping
    public Result add(@RequestBody UsersDto usersDto){
        return usersService.add(usersDto);
    }


}
