package com.example.demo.controller;

import com.example.demo.entity.Sale;
import com.example.demo.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping("/")
    public ResponseEntity<Sale> addSale(@RequestBody Sale sale) {
        return ResponseEntity.ok(saleService.saveSale(sale));
    }

    @GetMapping("/")
    public List<Sale> findAllSales() {
        return saleService.getAllSales();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> findSaleById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(saleService.getSaleById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sale> updateSale(@RequestBody Sale sale, @PathVariable("id") Long id) {
        return ResponseEntity.ok(saleService.updateSale(sale, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSale(@PathVariable("id") Long id) {
        saleService.deleteSale(id);
        return ResponseEntity.ok("Sale deleted successfully!");
    }
}
