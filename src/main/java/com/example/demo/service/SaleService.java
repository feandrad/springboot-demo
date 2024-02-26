package com.example.demo.service;

import com.example.demo.entity.Sale;
import java.util.List;

public interface SaleService {
    Sale saveSale(Sale sale);
    List<Sale> getAllSales();
    Sale getSaleById(Long id);
    Sale updateSale(Sale sale, Long id);
    void deleteSale(Long id);
}

