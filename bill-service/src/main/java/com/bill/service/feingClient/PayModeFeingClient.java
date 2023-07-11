package com.bill.service.feingClient;

import com.bill.service.domain.PayMode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "pay-mode-service")
@RequestMapping("/api/v1")
public interface PayModeFeingClient {

    @GetMapping("/payMode/{payModeId}")
    PayMode getPayModeById(@PathVariable("payModeId") int payModeId);

}
