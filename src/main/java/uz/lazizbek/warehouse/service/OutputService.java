package uz.lazizbek.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.lazizbek.warehouse.entity.*;
import uz.lazizbek.warehouse.payload.InputDto;
import uz.lazizbek.warehouse.payload.OutputDto;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.repository.ClientRepository;
import uz.lazizbek.warehouse.repository.CurrencyRepository;
import uz.lazizbek.warehouse.repository.OutputRepository;
import uz.lazizbek.warehouse.repository.WarehouseRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class OutputService {
    @Autowired
    OutputRepository outputRepository;

    @Autowired
    WarehouseRepository warehouseRepository;

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    ClientRepository clientRepository;

    public List<Output> getAll(){
        return outputRepository.findAll();
    }

    public Output oneOutput(Integer id){
        Optional<Output> outputOptional = outputRepository.findById(id);
        return outputOptional.orElseGet(Output::new);
    }

    public Result add(OutputDto outputDto){
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDto.getWarehouseId());
        Optional<Client> optionalClient = clientRepository.findById(outputDto.getClientId());
        Optional<Currency> optionalCurrency = currencyRepository.findById(outputDto.getCurrencyId());
        if (!optionalWarehouse.isPresent())
            return new Result("Ombor topilmadi", false);
        if (!optionalClient.isPresent())
            return new Result("Client topilmadi", false);
        if (!optionalCurrency.isPresent())
            return new Result("Valyuta turi topilmadi", false);
        String maxVal = outputRepository.findMaxCode();
        if (maxVal == null) {
            maxVal = "0";
        }
        String code = String.valueOf((Integer.parseInt(maxVal) + 1));
        long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        Output output = new Output();
        output.setCode(code);
        output.setDate(timestamp);
        output.setCurrency(optionalCurrency.get());
        output.setFactureNumber(outputDto.getFactureNumber());
        output.setWarehouse(optionalWarehouse.get());
        output.setClient(optionalClient.get());
        outputRepository.save(output);
        return new Result("Ma'lumot saqlandi", true);
    }

    public Result update(Integer id, OutputDto outputDto){
        Optional<Output> outputOptional = outputRepository.findById(id);
        if (!outputOptional.isPresent())
            return new Result("Chiqim faktura topilmadi", false);
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDto.getWarehouseId());
        Optional<Client> optionalClient = clientRepository.findById(outputDto.getClientId());
        Optional<Currency> optionalCurrency = currencyRepository.findById(outputDto.getCurrencyId());
        if (!optionalWarehouse.isPresent())
            return new Result("Ombor topilmadi", false);
        if (!optionalClient.isPresent())
            return new Result("Client topilmadi", false);
        if (!optionalCurrency.isPresent())
            return new Result("Valyuta turi topilmadi", false);
        Output output = outputOptional.get();
        output.setCurrency(optionalCurrency.get());
        output.setFactureNumber(outputDto.getFactureNumber());
        output.setWarehouse(optionalWarehouse.get());
        output.setClient(optionalClient.get());
        outputRepository.save(output);
        return new Result("O'zgarish saqlandi", true);
    }


}
