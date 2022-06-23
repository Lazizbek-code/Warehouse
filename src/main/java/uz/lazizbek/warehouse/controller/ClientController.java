package uz.lazizbek.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.lazizbek.warehouse.entity.Client;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping
    public List<Client> getAll(){
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Client oneCurrency(@PathVariable Integer id){
        return clientService.oneClient(id);
    }

    @PostMapping
    public Result add(@RequestBody Client client){
        return clientService.add(client);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody Client client){
        return clientService.update(id, client);
    }

    @PutMapping("/changeActive/{id}")
    public Result changeActive(@PathVariable Integer id){
        return clientService.changeActive(id);
    }
}
