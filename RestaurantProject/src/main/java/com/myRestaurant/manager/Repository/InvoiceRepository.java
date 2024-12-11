package com.myRestaurant.manager.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myRestaurant.manager.Entities.InvoiceEntities;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntities, Integer> {
	List<InvoiceEntities> findByTable_TableIdContainingIgnoreCase(String tableId);
}