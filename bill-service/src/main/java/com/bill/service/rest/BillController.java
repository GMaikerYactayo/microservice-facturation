package com.bill.service.rest;

import com.bill.service.domain.Bill;
import com.bill.service.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("/bills")
    public ResponseEntity<List<Bill>> findAllBill() {
        return ResponseEntity.ok(billService.findAll());
    }

    @PostMapping("/bills")
    public ResponseEntity<Bill> create(@RequestBody Bill bill) {
        return ResponseEntity.ok(billService.save(bill));
    }

    @DeleteMapping("/bills/{billId}")
    public ResponseEntity<String> deleteByBill (@PathVariable Integer billId){
        billService.deleteById(billId);
        return ResponseEntity.ok("Bill liminada con éxito");
    }

    @DeleteMapping("/bills/{billId}/details/{detailId}")
    public ResponseEntity<String> deleteByDetail (@PathVariable Integer billId, @PathVariable Integer detailId){
        billService.deleteDetailByBill(billId, detailId);
        return ResponseEntity.ok("Detalle eliminada con éxito");
    }

}
