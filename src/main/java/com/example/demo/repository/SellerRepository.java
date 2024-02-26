
package com.example.demo.repository;

import com.example.demo.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    // Métodos CRUD já são fornecidos pela herança de JpaRepository
}
