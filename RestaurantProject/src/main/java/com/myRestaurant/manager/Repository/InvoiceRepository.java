package com.myRestaurant.manager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myRestaurant.manager.Entities.InvoiceEntities;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntities, Integer> {
	
}