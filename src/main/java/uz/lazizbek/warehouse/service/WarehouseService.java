package uz.lazizbek.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.lazizbek.warehouse.entity.Warehouse;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    public Result add(Warehouse warehouse){
        boolean existsByName = warehouseRepository.existsByName(warehouse.getName());
        if (existsByName){
            return new Result("Bunday ombor mavjud", false);
        }else {
            Warehouse save = warehouseRepository.save(warehouse);
            return new Result("Ma'lumot saqlandi", true, save);
        }
    }

    public Result update(Integer id, Warehouse warehouse){
        Optional<Warehouse> warehouseOptional = warehouseRepository.findById(id);
        if (!warehouseOptional.isPresent())
            return new Result("Bunday ombor topilmadi", false);
        Warehouse saveWarehouse = warehouseOptional.get();
        saveWarehouse.setName(warehouse.getName());
        warehouseRepository.save(saveWarehouse);
        return new Result("Ma'lumot o'zgartirildi", true);
    }

    public List<Warehouse> getAll(){
        return warehouseRepository.findAll();
    }

    public Warehouse oneWarehouse(Integer id){
        Optional<Warehouse> warehouseOptional = warehouseRepository.findById(id);
        return warehouseOptional.orElseGet(Warehouse::new);
    }

    public Result changeActive(Integer id){
        Optional<Warehouse> warehouseOptional = warehouseRepository.findById(id);
        if (!warehouseOptional.isPresent())
            return new Result("Bunday valyuta topilmadi", false);
        Warehouse warehouse = warehouseOptional.get();
        warehouse.setActive(!warehouse.getActive());
        Warehouse save = warehouseRepository.save(warehouse);
        return new Result("O'zgartirish bajarildi", true, save);

    }
}
