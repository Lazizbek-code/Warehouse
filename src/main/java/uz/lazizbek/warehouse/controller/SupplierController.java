package uz.lazizbek.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.lazizbek.warehouse.entity.Supplier;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @GetMapping
    public List<Supplier> getAll(){
        return supplierService.getAll();
    }

    @GetMapping("/{id}")
    public Supplier oneCurrency(@PathVariable Integer id){
        return supplierService.oneSupplier(id);
    }

    @PostMapping
    public Result add(@RequestBody Supplier supplier){
        return supplierService.add(supplier);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody Supplier supplier){
        return supplierService.update(id, supplier);
    }

    @PutMapping("/changeActive/{id}")
    public Result changeActive(@PathVariable Integer id){
        return supplierService.changeActive(id);
    }
}
