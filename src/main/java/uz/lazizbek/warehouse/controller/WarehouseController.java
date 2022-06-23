package uz.lazizbek.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.lazizbek.warehouse.entity.Currency;
import uz.lazizbek.warehouse.entity.Warehouse;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.service.WarehouseService;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;

    @GetMapping
    public List<Warehouse> getAll(){
        return warehouseService.getAll();
    }

    @GetMapping("/{id}")
    public Warehouse oneCurrency(@PathVariable Integer id){
        return warehouseService.oneWarehouse(id);
    }

    @PostMapping
    public Result add(@RequestBody Warehouse warehouse){
        return warehouseService.add(warehouse);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody Warehouse warehouse){
        return warehouseService.update(id, warehouse);
    }

    @PutMapping("/changeActive/{id}")
    public Result changeActive(@PathVariable Integer id){
        return warehouseService.changeActive(id);
    }
}
