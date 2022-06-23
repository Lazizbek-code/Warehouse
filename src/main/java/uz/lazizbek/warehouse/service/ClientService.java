package uz.lazizbek.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.lazizbek.warehouse.entity.Client;
import uz.lazizbek.warehouse.entity.Supplier;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public Result add(Client client){
        boolean existsByPhoneNumber = clientRepository.existsByPhoneNumber(client.getPhoneNumber());
        if (existsByPhoneNumber){
            return new Result("Telefon nomer boshqaga biriktirilgan", false);
        }else {
            Client save = clientRepository.save(client);
            return new Result("Ma'lumot saqlandi", true, save);
        }
    }

    public List<Client> getAll(){
        return clientRepository.findAll();
    }

    public Client oneClient(Integer id){
        Optional<Client> clientOptional = clientRepository.findById(id);
        return clientOptional.orElseGet(Client::new);
    }

    public Result update(Integer id, Client client){
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (!clientOptional.isPresent())
            return new Result("Ma'lumot topilmadi", false);
        Client saveClient = clientOptional.get();
        saveClient.setName(client.getName());
        saveClient.setPhoneNumber(client.getPhoneNumber());
        Client save = clientRepository.save(saveClient);
        return new Result("Ma'lumot o'zgartirildi", true, save);
    }

    public Result changeActive(Integer id){
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (!clientOptional.isPresent())
            return new Result("Ma'lumot topilmadi", false);
        Client client = clientOptional.get();
        client.setActive(!client.getActive());
        Client save = clientRepository.save(client);
        return new Result("O'zgartirish bajarildi", true, save);
    }
}
