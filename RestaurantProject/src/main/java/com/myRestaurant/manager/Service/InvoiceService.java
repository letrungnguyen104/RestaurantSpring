package com.myRestaurant.manager.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myRestaurant.manager.Dto.InvoiceDto;
import com.myRestaurant.manager.Entities.InvoiceEntities;
import com.myRestaurant.manager.Repository.InvoiceRepository;
import com.myRestaurant.manager.Service.Impl.InvoiceServiceImpl;

@Service
public class InvoiceService implements InvoiceServiceImpl{

	@Autowired
    private InvoiceRepository invoiceRepository;
	
	@Override
	public List<InvoiceDto> getAllInvoices() {
		List<InvoiceEntities> invoiceEntitiesList = invoiceRepository.findAll();
	    return invoiceEntitiesList.stream().map(invoice -> {
	        InvoiceDto invoiceDto = new InvoiceDto();
	        invoiceDto.setInvoiceId(invoice.getInvoiceId());
	        invoiceDto.setUserId(invoice.getUser().getId());  // Chỉ lấy userId
	        invoiceDto.setTableId(invoice.getTable().getTableId());  // Chỉ lấy tableId
	        invoiceDto.setSum(invoice.getSum());
	        invoiceDto.setPoint(invoice.getPoint());
	        return invoiceDto;
	    }).collect(Collectors.toList());
	}

	@Override
	public List<InvoiceDto> searchInvoicesByTableId(String tableId) {
	    List<InvoiceEntities> invoiceEntitiesList = invoiceRepository.findByTable_TableIdContainingIgnoreCase(tableId);
	    return invoiceEntitiesList.stream().map(invoice -> {
	        InvoiceDto invoiceDto = new InvoiceDto();
	        invoiceDto.setInvoiceId(invoice.getInvoiceId());
	        invoiceDto.setUserId(invoice.getUser().getId());
	        invoiceDto.setTableId(invoice.getTable().getTableId());
	        invoiceDto.setSum(invoice.getSum());
	        invoiceDto.setPoint(invoice.getPoint());
	        return invoiceDto;
	    }).collect(Collectors.toList());
	}

	@Override
	public boolean processPayment(int invoiceId) {
        InvoiceEntities invoice = invoiceRepository.findById(invoiceId).orElse(null);
        if (invoice == null) {
            return false;
        }
        // Xử lý thêm
        invoiceRepository.delete(invoice);
        
        return true;
	}
}
