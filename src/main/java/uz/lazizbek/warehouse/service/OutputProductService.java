package uz.lazizbek.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.lazizbek.warehouse.entity.Output;
import uz.lazizbek.warehouse.entity.OutputProduct;
import uz.lazizbek.warehouse.entity.Product;
import uz.lazizbek.warehouse.payload.OutputProductDto;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.repository.OutputProductRepository;
import uz.lazizbek.warehouse.repository.OutputRepository;
import uz.lazizbek.warehouse.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OutputProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    OutputRepository outputRepository;

    @Autowired
    OutputProductRepository outputProductRepository;

    public Result add(OutputProductDto outputProductDto){
        Optional<Product> productOptional = productRepository.findById(outputProductDto.getProductId());
        if (!productOptional.isPresent())
            return new  Result("Product topilmadi", false);
        Optional<Output> outputOptional = outputRepository.findById(outputProductDto.getOutputId());
        if (!outputOptional.isPresent())
            return new  Result("Chiqim faktura topilmadi", false);
        OutputProduct outputProduct = new OutputProduct();
        outputProduct.setAmount(outputProductDto.getAmount());
        outputProduct.setPrice(outputProductDto.getPrice());
        outputProduct.setProduct(productOptional.get());
        outputProduct.setOutput(outputOptional.get());
        outputProductRepository.save(outputProduct);
        return new Result("Ma'lumot saqlandi", true);
    }

    public Result update(Integer id, OutputProductDto outputProductDto){
        Optional<OutputProduct> outputProductOptional = outputProductRepository.findById(id);
        if (!outputProductOptional.isPresent())
            return new  Result("Chiqim faktura topilmadi", false);
        Optional<Product> productOptional = productRepository.findById(outputProductDto.getProductId());
        if (!productOptional.isPresent())
            return new  Result("Product topilmadi", false);
        Optional<Output> outputOptional = outputRepository.findById(outputProductDto.getOutputId());
        if (!outputOptional.isPresent())
            return new  Result("Chiqim faktura topilmadi", false);
        OutputProduct outputProduct = outputProductOptional.get();
        outputProduct.setAmount(outputProductDto.getAmount());
        outputProduct.setPrice(outputProductDto.getPrice());
        outputProduct.setProduct(productOptional.get());
        outputProduct.setOutput(outputOptional.get());
        outputProductRepository.save(outputProduct);
        return new Result("Ma'lumot o'zgartirildi", true);
    }

    public List<OutputProduct> getByOutputId(Integer id){
        return outputProductRepository.findAllByOutputId(id);
    }
}
