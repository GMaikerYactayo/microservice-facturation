package com.client.service.rest;

import com.client.service.domain.Client;
import com.client.service.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/clients/{clientId}")
    public ResponseEntity<Optional<Client>> findAll(@PathVariable int clientId) {
        return ResponseEntity.ok(clientService.findById(clientId));
    }

    @PostMapping("/clients")
    public ResponseEntity<Client> create(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.save(client));
    }

}
