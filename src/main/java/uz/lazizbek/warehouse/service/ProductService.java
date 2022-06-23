package uz.lazizbek.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.lazizbek.warehouse.entity.Attachment;
import uz.lazizbek.warehouse.entity.Category;
import uz.lazizbek.warehouse.entity.Measurement;
import uz.lazizbek.warehouse.entity.Product;
import uz.lazizbek.warehouse.payload.ProductDto;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.repository.AttachmentRepository;
import uz.lazizbek.warehouse.repository.CategoryRepository;
import uz.lazizbek.warehouse.repository.MeasurementRepository;
import uz.lazizbek.warehouse.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    MeasurementRepository measurementRepository;

    public Result addProduct(ProductDto productDto){
        boolean existsByNameAndCategoryId = productRepository.existsByNameAndCategoryId(productDto.getName(), productDto.getCategoryId());
        if (existsByNameAndCategoryId)
            return new Result("Bunday mahsulot ushbu kategoriyada bor", false);
        Optional<Category> categoryOptional = categoryRepository.findById(productDto.getCategoryId());
        if (!categoryOptional.isPresent())
            return new Result("Categoriya topilmadi", false);
        Optional<Attachment> attachmentOptional = attachmentRepository.findById(productDto.getImageId());
        if (!attachmentOptional.isPresent())
            return new Result("Bunday rasm mavjud emas", false);
        Optional<Measurement> measurementOptional = measurementRepository.findById(productDto.getMeasurementId());
        if (!measurementOptional.isPresent())
            return new Result("Bunday o'lchov birligi mavjud emas", false);
        Product product = new Product();
        product.setName(productDto.getName());
        product.setCode("1");//
        product.setCategory(categoryOptional.get());
        product.setImage(attachmentOptional.get());
        product.setMeasurement(measurementOptional.get());
        productRepository.save(product);
        return new Result("Ma'lumot saqlandi", true);
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product oneProduct(Integer id){
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElseGet(Product::new);
    }

    public Result update(Integer id, ProductDto productDto){
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent())
            return new Result("Ma'lumot topilmadi", false);
        Optional<Category> categoryOptional = categoryRepository.findById(productDto.getCategoryId());
        if (!categoryOptional.isPresent())
            return new Result("Categoriya topilmadi", false);
        Optional<Attachment> attachmentOptional = attachmentRepository.findById(productDto.getImageId());
        if (!attachmentOptional.isPresent())
            return new Result("Bunday rasm mavjud emas", false);
        Optional<Measurement> measurementOptional = measurementRepository.findById(productDto.getMeasurementId());
        if (!measurementOptional.isPresent())
            return new Result("Bunday o'lchov birligi mavjud emas", false);
        Product product = productOptional.get();
        product.setName(productDto.getName());
        product.setCode("1");
        product.setCategory(categoryOptional.get());
        product.setImage(attachmentOptional.get());
        product.setImage(attachmentOptional.get());
        productRepository.save(product);
        return new Result("Ma'lumot o'zgartirildi", true);
    }


}
