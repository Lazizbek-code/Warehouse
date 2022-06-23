package uz.lazizbek.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.lazizbek.warehouse.entity.Input;
import uz.lazizbek.warehouse.entity.InputProduct;
import uz.lazizbek.warehouse.entity.Product;
import uz.lazizbek.warehouse.payload.InputProductDto;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.repository.InputProductRepository;
import uz.lazizbek.warehouse.repository.InputRepository;
import uz.lazizbek.warehouse.repository.ProductRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class InputProductService {
    @Autowired
    InputProductRepository inputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    InputRepository inputRepository;

    public Result add(InputProductDto inputProductDto){
        Optional<Product> productOptional = productRepository.findById(inputProductDto.getProductId());
        if (!productOptional.isPresent())
            return new  Result("Product topilmadi", false);
        Optional<Input> inputOptional = inputRepository.findById(inputProductDto.getProductId());
        if (!inputOptional.isPresent())
            return new  Result("Kirim faktura topilmadi", false);
        InputProduct inputProduct = new InputProduct();
        inputProduct.setProduct(productOptional.get());
        inputProduct.setAmount(inputProductDto.getAmount());
        inputProduct.setPrice(inputProductDto.getPrice());
        inputProduct.setInput(inputOptional.get());
        long datetime = System.currentTimeMillis();
        Date expireDate = new Date(datetime);
        inputProduct.setExpireDate(expireDate);
        inputProductRepository.save(inputProduct);
        return new Result("Ma'lumot saqlandi", true);
    }

    public Result update(Integer id, InputProductDto inputProductDto){
        Optional<InputProduct> inputProductOptional = inputProductRepository.findById(id);
        if (!inputProductOptional.isPresent())
            return new Result("Kirim tovar topilmadi", false);
        Optional<Product> productOptional = productRepository.findById(inputProductDto.getProductId());
        if (!productOptional.isPresent())
            return new  Result("Product topilmadi", false);
        Optional<Input> inputOptional = inputRepository.findById(inputProductDto.getProductId());
        if (!inputOptional.isPresent())
            return new  Result("Kirim faktura topilmadi", false);
        InputProduct inputProduct = inputProductOptional.get();
        inputProduct.setProduct(productOptional.get());
        inputProduct.setAmount(inputProductDto.getAmount());
        inputProduct.setPrice(inputProductDto.getPrice());
        inputProduct.setInput(inputOptional.get());
        inputProductRepository.save(inputProduct);
        return new Result("Ma'lumot o'zgartirildi", true);
    }

    public List<InputProduct> getByInputId(Integer inputId){
        return inputProductRepository.findAllByInputId(inputId);
    }
}
