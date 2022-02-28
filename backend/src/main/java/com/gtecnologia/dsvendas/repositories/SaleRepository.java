package com.gtecnologia.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtecnologia.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}
