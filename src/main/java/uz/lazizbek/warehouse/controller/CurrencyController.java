package uz.lazizbek.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.lazizbek.warehouse.entity.Currency;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.service.CurrencyService;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;

    @GetMapping
    public List<Currency> getAll(){
        return currencyService.getAll();
    }

    @GetMapping("/{id}")
    public Currency oneCurrency(@PathVariable Integer id){
        return currencyService.oneCurrency(id);
    }

    @PostMapping
    public Result add(@RequestBody Currency currency){
        return currencyService.add(currency);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody Currency currency){
        return currencyService.update(id, currency);
    }

    @PutMapping("/changeActive/{id}")
    public Result changeActive(@PathVariable Integer id){
        return currencyService.changeActive(id);
    }
}
