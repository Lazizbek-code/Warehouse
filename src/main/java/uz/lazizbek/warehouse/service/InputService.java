package uz.lazizbek.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.lazizbek.warehouse.entity.Currency;
import uz.lazizbek.warehouse.entity.Input;
import uz.lazizbek.warehouse.entity.Supplier;
import uz.lazizbek.warehouse.entity.Warehouse;
import uz.lazizbek.warehouse.payload.InputDto;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.repository.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class InputService {
    @Autowired
    InputRepository inputRepository;

    @Autowired
    WarehouseRepository warehouseRepository;

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    SupplierRepository supplierRepository;


    public List<Input> getAll(){
        return inputRepository.findAll();
    }

    public Input oneInput(Integer id){
        Optional<Input> inputOptional = inputRepository.findById(id);
        return inputOptional.orElseGet(Input::new);
    }

    public Result add(InputDto inputDto){
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDto.getWarehouseId());
        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDto.getSupplierId());
        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDto.getCurrencyId());
        if (!optionalWarehouse.isPresent())
            return new Result("Ombor topilmadi", false);
        if (!optionalSupplier.isPresent())
            return new Result("Yetkazib beruvchi topilmadi", false);
        if (!optionalCurrency.isPresent())
            return new Result("Valyuta turi topilmadi", false);
        String maxVal = inputRepository.findMaxCode();
        if (maxVal == null) {
            maxVal = "0";
        }
        String code = String.valueOf((Integer.parseInt(maxVal) + 1));
        long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        Input input = new Input();
        input.setCode(code);
        input.setDate(timestamp);
        input.setCurrency(optionalCurrency.get());
        input.setFactureNumber(inputDto.getFactureNumber());
        input.setWarehouse(optionalWarehouse.get());
        input.setSupplier(optionalSupplier.get());
        inputRepository.save(input);
        return new Result("Ma'lumot saqlandi", true);
    }

    public Result update(Integer id, InputDto inputDto){
        Optional<Input> inputOptional = inputRepository.findById(id);
        if (!inputOptional.isPresent())
            return new Result("Ma'lumot topilmadi", false);
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDto.getWarehouseId());
        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDto.getSupplierId());
        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDto.getCurrencyId());
        if (!optionalWarehouse.isPresent())
            return new Result("Ombor topilmadi", false);
        if (!optionalSupplier.isPresent())
            return new Result("Yetkazib beruvchi topilmadi", false);
        if (!optionalCurrency.isPresent())
            return new Result("Valyuta turi topilmadi", false);
        Input input = inputOptional.get();
        input.setCurrency(optionalCurrency.get());
        input.setFactureNumber(inputDto.getFactureNumber());
        input.setWarehouse(optionalWarehouse.get());
        input.setSupplier(optionalSupplier.get());
        inputRepository.save(input);
        return new Result("O'zgarish saqlandi", true);
    }
}
