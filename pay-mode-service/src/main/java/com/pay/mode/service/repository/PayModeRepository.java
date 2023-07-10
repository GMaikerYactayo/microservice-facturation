package com.pay.mode.service.repository;

import com.pay.mode.service.domain.PayMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayModeRepository extends JpaRepository<PayMode, Integer> {
}
