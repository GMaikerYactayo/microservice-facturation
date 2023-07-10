package com.bill.service.service;

import com.bill.service.domain.Bill;
import java.util.List;

public interface BillService {

    List<Bill> findAll();
    Bill save(Bill bill);
    void deleteById(Integer billId);
    void deleteDetailByBill(Integer billId, Integer detailId);

}
