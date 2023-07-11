package com.bill.service.feingClient;

import com.bill.service.domain.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "client-service")
@RequestMapping("/api/v1")
public interface ClientFeingClient {

    @GetMapping("/clients/{clientId}")
    Client getClientById(@PathVariable("clientId") int clientId);

}
