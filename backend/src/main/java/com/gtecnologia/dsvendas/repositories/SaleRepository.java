package com.gtecnologia.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gtecnologia.dsvendas.entities.Sale;
import com.gtecnologia.dsvendas.entities.dto.SaleSuccessDTO;
import com.gtecnologia.dsvendas.entities.dto.SaleSumDTO;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	
	@Query("SELECT new com.gtecnologia.dsvendas.entities.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.gtecnologia.dsvendas.entities.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();

}
