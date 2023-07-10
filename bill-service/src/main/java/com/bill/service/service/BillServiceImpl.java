package com.bill.service.service;

import com.bill.service.domain.*;
import com.bill.service.feingClient.ClientFeingClient;
import com.bill.service.feingClient.PayModeFeingClient;
import com.bill.service.feingClient.ProductFeingClient;
import com.bill.service.repository.BillRepository;
import com.bill.service.repository.DetailRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;
    @Autowired
    private DetailRepository detailRepository;
    @Autowired
    private ProductFeingClient productFeingClient;
    @Autowired
    private PayModeFeingClient payModeFeingClient;
    @Autowired
    private ClientFeingClient clientFeingClient;

    @Override
    public List<Bill> findAll() {
        return billRepository.findAll();
    }

    @Override
    public Bill save(Bill bill) {
        Client client = getClientById(bill.getClient_id());
        PayMode paymentMode = getPaymentModeById(bill.getPay_mode_id());

        bill.setClient_id(client.getClient_id());
        bill.setPay_mode_id(paymentMode.getPay_mode_id());
        bill.setDate_creation(LocalDate.now());
        float total = calculateTotal(bill.getDetail());
        bill.setTotal(total);

        Bill savedBill = saveBill(bill);
        saveDetails(savedBill, bill.getDetail());

        return savedBill;
    }

    @Override
    public void deleteById(Integer billId) {
        Bill bill = billRepository.findById(billId)
                .orElseThrow(() -> new RuntimeException("bill no encontrado"));
        billRepository.delete(bill);
    }

    @Override
    public void deleteDetailByBill(Integer billId, Integer detailId) {
        Bill bill = billRepository.findById(billId)
                .orElseThrow(() -> new RuntimeException("Bill no encontrado"));
        Detail detail = detailRepository.findById(detailId)
                .orElseThrow(() -> new RuntimeException("detail no encontrado"));
        if (!detail.getBill().equals(bill)) {
            throw new RuntimeException("Detalle no encontrado en la factura especificada");
        }
        detailRepository.delete(detail);
        updateTotalBill(bill);
    }

    private void updateTotalBill(Bill bill) {
        float total = calculateTotal(bill.getDetail());
        bill.setTotal(total);
        billRepository.save(bill);
    }

    private float calculateTotal(List<Detail> details) {
        float total = 0.0f;
        for (Detail detail : details) {
            Product product = productFeingClient.getProductById(detail.getProduct_id());
            float price = product.getPrice() * detail.getAmount();
            total += price;
        }
        return total;
    }

    private Client getClientById(int clientId) {
        Client client = clientFeingClient.getClientById(clientId);
        if (client != null) {
            return client;
        } else {
            throw new RuntimeException("Cliente no encontrado");
        }
    }

    private PayMode getPaymentModeById(int payModeId) {
        PayMode payMode = payModeFeingClient.getPayModeById(payModeId);
        if (payMode != null) {
            return payMode;
        } else {
            throw new RuntimeException("Pay mode no encontrado");
        }
    }

    private Bill saveBill(Bill bill) {
        return billRepository.save(bill);
    }

    private void saveDetails(Bill bill, List<Detail> details) {
        for (Detail detail : details) {
            Product product = getProductById(detail.getProduct_id());
            float price = product.getPrice() * detail.getAmount();
            detail.setPrice(price);
            detail.setBill(bill);
            detail.setProduct_id(product.getProduct_id());
            detailRepository.save(detail);
        }
    }

    private Product getProductById(int productId) {
        Product product = productFeingClient.getProductById(productId);
        if (product != null) {
            return product;
        } else {
            throw new RuntimeException("Product no encontrado");
        }
    }

}
