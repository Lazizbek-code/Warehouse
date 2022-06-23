package uz.lazizbek.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.lazizbek.warehouse.entity.Input;
import uz.lazizbek.warehouse.payload.InputDto;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.service.InputService;

import java.util.List;

@RestController
@RequestMapping(value = "/input")
public class InputController {
    @Autowired
    InputService inputService;

    @GetMapping
    public List<Input> getAll(){
        return inputService.getAll();
    }

    @GetMapping("/{id}")
    public Input oneInput(@PathVariable Integer id){
        return inputService.oneInput(id);
    }

    @PostMapping
    public Result add(@RequestBody InputDto inputDto){
        return inputService.add(inputDto);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody InputDto inputDto){
        return inputService.update(id, inputDto);
    }

}
