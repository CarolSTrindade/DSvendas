package com.trindadecarol.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trindadecarol.dsvendas.dto.SalesDTO;
import com.trindadecarol.dsvendas.dto.SalesSucessDTO;
import com.trindadecarol.dsvendas.dto.SalesSumDTO;
import com.trindadecarol.dsvendas.entities.Sales;
import com.trindadecarol.dsvendas.repositories.SalesRepository;
import com.trindadecarol.dsvendas.repositories.SellerRepository;

@Service
public class SalesService {

@Autowired
 private SalesRepository repository;

@Autowired
 private SellerRepository sellerRepository;	

@Transactional(readOnly = true)
 public Page<SalesDTO> findAll(Pageable pegeable){
	 sellerRepository.findAll();
	 Page<Sales> result = repository.findAll(pegeable);
	 return result.map(x -> new SalesDTO(x));
 }
 
@Transactional(readOnly = true)
	public List<SalesSumDTO> amountGroupBySeller(){
	return repository.amountGroupedBySeller();
}
 
@Transactional(readOnly = true)
	public List<SalesSucessDTO> sucessGroupBySeller(){
	return repository.sucessGroupedBySeller();
}

}
