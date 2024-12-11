package com.myRestaurant.manager.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myRestaurant.manager.Dto.InvoiceDto;
import com.myRestaurant.manager.Dto.UserDto;
import com.myRestaurant.manager.Payload.ResponseData;
import com.myRestaurant.manager.Service.InvoiceService;

@CrossOrigin("*")
@RestController
@RequestMapping("/homepage-cashier")
public class PayController {
	@Autowired
    private InvoiceService invoiceService;

	@GetMapping("/pay/list-invoice")
    public List<InvoiceDto> getInvoices() {
		return invoiceService.getAllInvoices();
    }
	// Tìm kiếm hóa đơn theo table_id
    @GetMapping("/pay/search-invoice")
    public List<InvoiceDto> searchInvoices(@RequestParam String tableId) {
        return invoiceService.searchInvoicesByTableId(tableId);
    }
    
    @PostMapping("/pay/payment/{invoiceId}")
    public ResponseEntity<ResponseData> processPayment(@PathVariable int invoiceId) {
        boolean isPaid = invoiceService.processPayment(invoiceId);
        ResponseData response = new ResponseData();
        if (isPaid) {
            response.setStatus(200);
            response.setDescription("Thanh toán thành công");
            response.setData(null);  // or any other relevant data you want to return
            response.setRole_Id(1); // Example: Assuming 1 is the cashier role
        } else {
            response.setStatus(400);
            response.setDescription("Có lỗi xảy ra");
            response.setData(null); // No additional data in case of error
            response.setRole_Id(1); // Example role
        }

        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
