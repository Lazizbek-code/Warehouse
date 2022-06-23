package uz.lazizbek.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.lazizbek.warehouse.entity.Product;
import uz.lazizbek.warehouse.payload.ProductDto;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public Result addProduct(@RequestBody ProductDto productDto){
        return productService.addProduct(productDto);
    }

    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product oneProduct(@PathVariable Integer id){
        return productService.oneProduct(id);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody ProductDto productDto){
        return productService.update(id, productDto);
    }
}
