package com.pay.mode.service.service;

import com.pay.mode.service.domain.PayMode;

import java.util.List;
import java.util.Optional;

public interface PayModeService {

    PayMode save(PayMode payMode);
    List<PayMode> findAll();
    Optional<PayMode> findById(int payModeId);

}
