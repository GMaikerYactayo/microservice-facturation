package com.pay.mode.service.rest;

import com.pay.mode.service.domain.PayMode;
import com.pay.mode.service.service.PayModeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PayModeController {

    private final PayModeService payModeService;
    private final Logger log = LoggerFactory.getLogger(PayModeController.class);

    @GetMapping("/payMode")
    public List<PayMode> getAllPayMode() {
        log.info("REST request to find all category");
        return payModeService.findAll();
    }

    @GetMapping("/payMode/{payModeId}")
    public ResponseEntity<Optional<PayMode>> getPayModeId(@PathVariable int payModeId) {
        log.info("REST request to find all category");
        return ResponseEntity.ok(payModeService.findById(payModeId));
    }

    @PostMapping("/payMode")
    public ResponseEntity<PayMode> create(@RequestBody PayMode payMode) {
        log.info("REST request to create a new category");
        return ResponseEntity.ok(payModeService.save(payMode));
    }

}
