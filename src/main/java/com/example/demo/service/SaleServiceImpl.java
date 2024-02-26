package com.example.demo.service;

import com.example.demo.entity.Sale;
import com.example.demo.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public Sale saveSale(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    @Override
    public Sale getSaleById(Long id) {
        return saleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Sale not found!"));
    }

    @Override
    public Sale updateSale(Sale sale, Long id) {
        Sale existingSale = getSaleById(id);
        existingSale.setDate(sale.getDate());
        existingSale.setProduct(sale.getProduct());
        existingSale.setCustomer(sale.getCustomer());
        return saleRepository.save(existingSale);
    }

    @Override
    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }
}
