package com.gtecnologia.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gtecnologia.dsvendas.entities.dto.SaleDTO;
import com.gtecnologia.dsvendas.entities.dto.SaleSuccessDTO;
import com.gtecnologia.dsvendas.entities.dto.SaleSumDTO;
import com.gtecnologia.dsvendas.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;

	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAllPaged(Pageable pageable) {

		Page<SaleDTO> page = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(page);
	}

	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {

		List<SaleSumDTO> list = service.amountGroupedBySeller();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller() {

		List<SaleSuccessDTO> list = service.successGroupedBySeller();
		return ResponseEntity.ok().body(list);
	}

	
}
