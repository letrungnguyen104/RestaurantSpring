package com.myRestaurant.manager.Entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "invoice_menu")
public class InvoiceMenuEntities {

    @EmbeddedId
    private InvoiceMenuKey id;

    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id", insertable = false, updatable = false)
    private InvoiceEntities invoiceEntities;

    @ManyToOne
    @JoinColumn(name = "dish_id", referencedColumnName = "dish_id", insertable = false, updatable = false)
    private MenuEntities menuEntities;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    @Column(name = "dish_status", nullable = false)
    private int dishStatus;

    // Getters and Setters
    public InvoiceMenuKey getId() {
        return id;
    }

    public void setId(InvoiceMenuKey id) {
        this.id = id;
    }

    public InvoiceEntities getInvoiceEntities() {
        return invoiceEntities;
    }

    public void setInvoiceEntities(InvoiceEntities invoiceEntities) {
        this.invoiceEntities = invoiceEntities;
    }

    public MenuEntities getMenuEntities() {
        return menuEntities;
    }

    public void setMenuEntities(MenuEntities menuEntities) {
        this.menuEntities = menuEntities;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getDishStatus() {
        return dishStatus;
    }

    public void setDishStatus(int dishStatus) {
        this.dishStatus = dishStatus;
    }
}