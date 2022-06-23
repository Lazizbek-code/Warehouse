package uz.lazizbek.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.lazizbek.warehouse.entity.Measurement;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.repository.MeasurementRepository;
import uz.lazizbek.warehouse.service.MeasurementService;

import java.util.List;

@RestController
@RequestMapping(value = "/measurement")
public class MeasurementController {
    @Autowired
    MeasurementService measurementService;

    @PostMapping
    public Result add(@RequestBody Measurement measurement){
        return measurementService.add(measurement);
    }

    @GetMapping
    public List<Measurement> getAll(){
        return measurementService.getAll();
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody Measurement measurement){
        return measurementService.update(id,measurement);
    }

    @GetMapping("/{id}")
    public Measurement oneMeasurement(@PathVariable Integer id){
        return measurementService.oneMeasurement(id);
    }

    @PutMapping("/changeActive/{id}")
    public Result changeActive(@PathVariable Integer id){
        return measurementService.changeActive(id);
    }
}
