package webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.model.Client;
import webshop.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    public ClientRepository clientRepository;

    public List<Client> getAllClients() {

        List<Client> result = new ArrayList<>();
        clientRepository.findAll().forEach(result::add);

        return result;
    }

    public Long saveClient(Client client) {

        return clientRepository.save(client).getId();
    }
}
