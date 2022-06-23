package uz.lazizbek.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.lazizbek.warehouse.entity.Supplier;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public Result add(Supplier supplier){
        boolean existsByPhoneNumber = supplierRepository.existsByPhoneNumber(supplier.getPhoneNumber());
        if (existsByPhoneNumber){
            return new Result("Telefon nomer boshqaga biriktirilgan", false);
        }else {
            Supplier save = supplierRepository.save(supplier);
            return new Result("Ma'lumot saqlandi", true, save);
        }
    }

    public List<Supplier> getAll(){
        return supplierRepository.findAll();
    }

    public Supplier oneSupplier(Integer id){
        Optional<Supplier> supplierOptional = supplierRepository.findById(id);
        return supplierOptional.orElseGet(Supplier::new);
    }

    public Result update(Integer id, Supplier supplier){
        Optional<Supplier> supplierOptional = supplierRepository.findById(id);
        if (!supplierOptional.isPresent())
            return new Result("Ma'lumot topilmadi", false);
        Supplier saveSupplier = supplierOptional.get();
        saveSupplier.setName(supplier.getName());
        saveSupplier.setPhoneNumber(supplier.getPhoneNumber());
        Supplier save = supplierRepository.save(saveSupplier);
        return new Result("Ma'lumot o'zgartirildi", true, save);
    }

    public Result changeActive(Integer id){
        Optional<Supplier> supplierOptional = supplierRepository.findById(id);
        if (!supplierOptional.isPresent())
            return new Result("Ma'lumot topilmadi", false);
        Supplier supplier = supplierOptional.get();
        supplier.setActive(!supplier.getActive());
        Supplier save = supplierRepository.save(supplier);
        return new Result("O'zgartirish bajarildi", true, save);
    }
}
