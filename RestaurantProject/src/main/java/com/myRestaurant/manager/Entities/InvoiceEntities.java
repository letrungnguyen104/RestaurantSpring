package com.myRestaurant.manager.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Set;

@Entity(name = "invoice")
public class InvoiceEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private int invoiceId;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)  // User id
    private UserEntities user;

    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false)  // Table id
    private TableEntities table;
    
    @OneToMany(mappedBy = "invoiceEntities")
    private List<InvoiceMenuEntities> invoiceMenuEntities;

    @Column(name = "create_date")
    private java.sql.Timestamp createDate;

    @Column(name = "sum", nullable = false)
    private float sum;

    @Column(name = "point", nullable = false)
    private long point;

    @OneToMany(mappedBy = "invoiceEntities")
    private Set<InvoiceMenuEntities> invoiceMenus;

    // Getters and Setters
    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public UserEntities getUser() {
        return user;
    }

    public void setUser(UserEntities user) {
        this.user = user;
    }

    public TableEntities getTable() {
        return table;
    }

    public void setTable(TableEntities table) {
        this.table = table;
    }

    public java.sql.Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.sql.Timestamp createDate) {
        this.createDate = createDate;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float d) {
        this.sum = d;
    }

    public long getPoint() {
        return point;
    }

    public void setPoint(long point) {
        this.point = point;
    }

    public Set<InvoiceMenuEntities> getInvoiceMenus() {
        return invoiceMenus;
    }

    public void setInvoiceMenus(Set<InvoiceMenuEntities> invoiceMenus) {
        this.invoiceMenus = invoiceMenus;
    }
}