package uz.lazizbek.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.lazizbek.warehouse.entity.Input;
import uz.lazizbek.warehouse.entity.Output;
import uz.lazizbek.warehouse.payload.InputDto;
import uz.lazizbek.warehouse.payload.OutputDto;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.service.OutputService;

import java.util.List;

@RestController
@RequestMapping("/output")
public class OutputController {
    @Autowired
    OutputService outputService;

    @GetMapping
    public List<Output> getAll(){
        return outputService.getAll();
    }

    @GetMapping("/{id}")
    public Output oneOutput(@PathVariable Integer id){
        return outputService.oneOutput(id);
    }

    @PostMapping
    public Result add(@RequestBody OutputDto outputDto){
        return outputService.add(outputDto);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody OutputDto outputDto){
        return outputService.update(id, outputDto);
    }
}
