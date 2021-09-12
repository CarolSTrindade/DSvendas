package com.trindadecarol.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trindadecarol.dsvendas.dto.SalesSucessDTO;
import com.trindadecarol.dsvendas.dto.SalesSumDTO;
import com.trindadecarol.dsvendas.entities.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long>{

	@Query("SELECT new com.trindadecarol.dsvendas.dto.SalesSumDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sales AS obj GROUP BY obj.seller")
	List<SalesSumDTO> amountGroupedBySeller();


	@Query("SELECT new com.trindadecarol.dsvendas.dto.SalesSucessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ " FROM Sales AS obj GROUP BY obj.seller")
	List<SalesSucessDTO> sucessGroupedBySeller();



}
