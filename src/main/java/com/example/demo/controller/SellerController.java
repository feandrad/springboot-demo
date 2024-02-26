package com.example.demo.controller;

import com.example.demo.entity.Seller;
import com.example.demo.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping("/")
    public ResponseEntity<Seller> addSeller(@RequestBody Seller seller) {
        return ResponseEntity.ok(sellerService.saveSeller(seller));
    }

    @GetMapping("/")
    public List<Seller> findAllSellers() {
        return sellerService.getAllSellers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seller> findSellerById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(sellerService.getSellerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seller> updateSeller(@RequestBody Seller seller, @PathVariable("id") Long id) {
        return ResponseEntity.ok(sellerService.updateSeller(seller, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSeller(@PathVariable("id") Long id) {
        sellerService.deleteSeller(id);
        return ResponseEntity.ok("Seller deleted successfully!");
    }
}

