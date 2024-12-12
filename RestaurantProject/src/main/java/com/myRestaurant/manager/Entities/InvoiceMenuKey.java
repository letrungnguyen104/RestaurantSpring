package com.myRestaurant.manager.Entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class InvoiceMenuKey implements Serializable {
    @Column(name = "invoice_id")
    private int invoice_id;
    
    @Column(name = "dish_id")
    private int dish_id;
    
    public InvoiceMenuKey() {};
    
    public InvoiceMenuKey(int invoice_id, int dish_id) {
    	this.invoice_id = invoice_id;
    	this.dish_id = dish_id;
    }
}
