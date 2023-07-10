package com.client.service.service;

import com.client.service.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<Client> findAll();
    Client save(Client client);
    Optional<Client> findById(int clientId);

}
