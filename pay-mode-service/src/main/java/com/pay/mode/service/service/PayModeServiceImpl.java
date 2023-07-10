package com.pay.mode.service.service;

import com.pay.mode.service.domain.PayMode;
import com.pay.mode.service.repository.PayModeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PayModeServiceImpl implements PayModeService {

    private final PayModeRepository payModeRepository;

    @Override
    public PayMode save(PayMode payMode) {
        return payModeRepository.save(payMode);
    }

    @Override
    public List<PayMode> findAll() {
        return payModeRepository.findAll();
    }

    @Override
    public Optional<PayMode> findById(int payModeId) {
        return payModeRepository.findById(payModeId);
    }
}
