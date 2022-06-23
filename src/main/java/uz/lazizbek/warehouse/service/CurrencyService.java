package uz.lazizbek.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.lazizbek.warehouse.entity.Currency;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.repository.CurrencyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    public Result add(Currency currency){
        boolean existsByName = currencyRepository.existsByName(currency.getName());
        if (existsByName){
            return new Result("Bunday valyuta turi mavjud!", false);
        }else {
            Currency save = currencyRepository.save(currency);
            return new Result("Ma'lumot saqlandi", true, save);
        }
    }

    public Result update(Integer id, Currency currency){
        Optional<Currency> currencyOptional = currencyRepository.findById(id);
        if (!currencyOptional.isPresent())
            return new Result("Bunday valyuta topilmadi", false);
        Currency saveCurrency = currencyOptional.get();
        saveCurrency.setName(currency.getName());
        currencyRepository.save(saveCurrency);
        return new Result("Ma'lumot o'zgartirildi", true);
    }

    public List<Currency> getAll(){
        return currencyRepository.findAll();
    }

    public Currency oneCurrency(Integer id){
        Optional<Currency> currencyOptional = currencyRepository.findById(id);
        return currencyOptional.orElseGet(Currency::new);
    }

    public Result changeActive(Integer id){
        Optional<Currency> currencyOptional = currencyRepository.findById(id);
        if (!currencyOptional.isPresent())
            return new Result("Bunday valyuta topilmadi", false);
        Currency currency = currencyOptional.get();
        currency.setActive(!currency.getActive());
        Currency save = currencyRepository.save(currency);
        return new Result("O'zgartirish bajarildi", true, save);

    }

}
