package webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import webshop.model.Client;
import webshop.service.ClientService;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    public ClientService clientService;

    @GetMapping("/clients")
    @ResponseBody
    public List<Client> allClients() {

        return clientService.getAllClients();
    }
}
