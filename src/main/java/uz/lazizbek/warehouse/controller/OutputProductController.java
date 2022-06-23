package uz.lazizbek.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.lazizbek.warehouse.entity.OutputProduct;
import uz.lazizbek.warehouse.payload.OutputProductDto;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.service.OutputProductService;

import java.util.List;

@RestController
@RequestMapping(value = "/outputProduct")
public class OutputProductController {
    @Autowired
    OutputProductService outputProductService;

    @PostMapping
    public Result add(@RequestBody OutputProductDto outputProductDto){
        return outputProductService.add(outputProductDto);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody OutputProductDto outputProductDto){
        return outputProductService.update(id, outputProductDto);
    }

    @GetMapping("/byOutputId/{id}")
    public List<OutputProduct> getOutputProductByOutputId(@PathVariable Integer id){
        return outputProductService.getByOutputId(id);
    }
}
