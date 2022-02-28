package com.gtecnologia.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gtecnologia.dsvendas.entities.Sale;
import com.gtecnologia.dsvendas.entities.dto.SaleDTO;
import com.gtecnologia.dsvendas.entities.dto.SaleSuccessDTO;
import com.gtecnologia.dsvendas.entities.dto.SaleSumDTO;
import com.gtecnologia.dsvendas.repositories.SaleRepository;
import com.gtecnologia.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository selerRepository;

	
	public Page<SaleDTO> findAllPaged(Pageable pageable) {
		
		selerRepository.findAll();
		
		Page<Sale> page = repository.findAll(pageable);
		return page.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller() {
		
		return repository.successGroupedBySeller();
	}
	
}
