/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MSEP_PROCESSOR_CODEX
 */
@Entity
@Table(name = "order_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderDetails.findAll", query = "SELECT o FROM OrderDetails o")
    , @NamedQuery(name = "OrderDetails.findById", query = "SELECT o FROM OrderDetails o WHERE o.id = :id")
    , @NamedQuery(name = "OrderDetails.findByAmount", query = "SELECT o FROM OrderDetails o WHERE o.amount = :amount")
    , @NamedQuery(name = "OrderDetails.findByPrice", query = "SELECT o FROM OrderDetails o WHERE o.price = :price")
    , @NamedQuery(name = "OrderDetails.findByQuanity", query = "SELECT o FROM OrderDetails o WHERE o.quanity = :quanity")})
public class OrderDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Amount")
    private double amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private double price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quanity")
    private int quanity;
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Orders orderId;
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "Code")
    @ManyToOne(optional = false)
    private Products productId;

    public OrderDetails() {
    }

    public OrderDetails(String id) {
        this.id = id;
    }

    public OrderDetails(String id, double amount, double price, int quanity) {
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.quanity = quanity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public Orders getOrderId() {
        return orderId;
    }

    public void setOrderId(Orders orderId) {
        this.orderId = orderId;
    }

    public Products getProductId() {
        return productId;
    }

    public void setProductId(Products productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetails)) {
            return false;
        }
        OrderDetails other = (OrderDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OrderDetails[ id=" + id + " ]";
    }
    
}
