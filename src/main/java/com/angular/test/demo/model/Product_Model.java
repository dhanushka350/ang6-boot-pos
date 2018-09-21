package com.angular.test.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_item")
public class Product_Model implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_code")
    private int id;

    @Column(name = "item_name")
    private String name;

    @Column(name = "item_qty")
    private int qty;

    @Column(name = "item_unit_price")
    private double unitPrice;

    public Product_Model() {
    }

    public Product_Model(String name, int qty, double unitPrice) {
        this.name = name;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Product_Model{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", qty=").append(qty);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append('}');
        return sb.toString();
    }
}
