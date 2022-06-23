package uz.lazizbek.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.lazizbek.warehouse.entity.Category;
import uz.lazizbek.warehouse.payload.CategoryDto;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.service.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping
    public Result addCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.addCategory(categoryDto);
    }
}
