package com.gtecnologia.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtecnologia.dsvendas.entities.Seller;
import com.gtecnologia.dsvendas.entities.dto.SellerDTO;
import com.gtecnologia.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repository;

	public List<SellerDTO> findALL() {

		List<Seller> entity = repository.findAll();
		return entity.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}

	public SellerDTO findById(Long id) {

		Seller entity = repository.findById(id).get();
		return new SellerDTO(entity);
	}

}
