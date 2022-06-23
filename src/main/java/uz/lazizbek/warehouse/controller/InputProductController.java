package uz.lazizbek.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.lazizbek.warehouse.entity.InputProduct;
import uz.lazizbek.warehouse.payload.InputProductDto;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.service.InputProductService;

import java.util.List;

@RestController
@RequestMapping(value = "/inputProduct")
public class InputProductController {
    @Autowired
    InputProductService inputProductService;

    @PostMapping
    public Result add(@RequestBody InputProductDto inputProductDto){
        return inputProductService.add(inputProductDto);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody InputProductDto inputProductDto){
        return inputProductService.update(id, inputProductDto);
    }

    @GetMapping("/byInputId/{id}")
    public List<InputProduct> getInputProductByInputId(@PathVariable Integer id){
        return inputProductService.getByInputId(id);
    }
}
