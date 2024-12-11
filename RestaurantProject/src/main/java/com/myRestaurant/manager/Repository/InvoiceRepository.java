package com.myRestaurant.manager.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myRestaurant.manager.Entities.InvoiceEntities;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntities, Integer> {
	 // Tìm hóa đơn chưa thanh toán theo tableId
    List<InvoiceEntities> findByTable_TableIdContainingIgnoreCaseAndInvoiceStatus(String tableId, boolean invoiceStatus);

    // Tìm tất cả hóa đơn chưa thanh toán
    List<InvoiceEntities> findByInvoiceStatus(boolean invoiceStatus);
}