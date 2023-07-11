package com.bill.service.feingClient;

import com.bill.service.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "product-service")
@RequestMapping("/api/v1")
public interface ProductFeingClient {

    @GetMapping("/products/{productId}")
    Product getProductById(@PathVariable int productId);

}
