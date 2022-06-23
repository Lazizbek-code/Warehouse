package uz.lazizbek.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.lazizbek.warehouse.entity.Category;
import uz.lazizbek.warehouse.payload.CategoryDto;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.repository.CategoryRepository;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Result addCategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        if (categoryDto.getParentCategoryId() != null){
            Optional<Category> categoryOptional  = categoryRepository.findById(categoryDto.getParentCategoryId());
            if (!categoryOptional.isPresent()){
                return new Result("Category topilmadi",false);
            }else {
                category.setParentCategory(categoryOptional.get());
            }
        }
        categoryRepository.save(category);
        return new Result("Ma'lumot saqlandi", true);
    }
}
