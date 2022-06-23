package uz.lazizbek.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import uz.lazizbek.warehouse.entity.Measurement;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {
    @Autowired
    MeasurementRepository measurementRepository;

    public Result add(Measurement measurement){
        boolean existsByName = measurementRepository.existsByName(measurement.getName());
        if (existsByName){
            return  new Result("Bunday o'lchov birligi mavjud", false);
        }else {
            measurementRepository.save(measurement);
            return new Result("Ma'lumot saqlandi", true);
        }
    }

    public List<Measurement> getAll(){
        return measurementRepository.findAll();
    }

    public Result update(Integer id, Measurement measurement){
        Optional<Measurement> measurementOptional = measurementRepository.findById(id);
        if (!measurementOptional.isPresent())
            return new Result("Bunday o'lchov birligi topilmadi", false);
        Measurement saveMeasurement = measurementOptional.get();
        saveMeasurement.setName(measurement.getName());
        measurementRepository.save(saveMeasurement);
        return new Result("Ma'lumot o'zgartirildi", true);
    }

    public Measurement oneMeasurement(Integer id){
        Optional<Measurement> measurementOptional = measurementRepository.findById(id);
        return measurementOptional.orElseGet(Measurement::new);
    }

    public Result changeActive(Integer id){
        Optional<Measurement> measurementOptional = measurementRepository.findById(id);
        if (!measurementOptional.isPresent())
            return new Result("Bunday o'lchov birligi topilmadi", false);
        Measurement measurement = measurementOptional.get();
        measurement.setActive(!measurement.getActive());
        Measurement save = measurementRepository.save(measurement);
        return new Result("O'zgartirish bajarildi", true, save);
    }
}
