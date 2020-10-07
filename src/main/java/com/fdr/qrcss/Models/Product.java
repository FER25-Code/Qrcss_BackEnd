package com.fdr.qrcss.Models;

import javax.persistence.*;

/**
 * Created by FERGANI DIA EL EDDINE on 05/10/2020 at 13.
 * FdR for development
 * Dia.fergani@univ-constantine2.dz
 */
@Entity
@Table(name = "product")
public class Product {
    @Id
    private int id;

    @Column( nullable = false)
    private int num ;
    @Column( nullable = false)
    private int quantity ;

    @Column( nullable = false)
    private double Price;

    public Product(int id, int num, int quantity, double price, String name, String mark) {
        this.id = id;
        this.num = num;
        this.quantity = quantity;
        Price = price;
        Name = name;
        Mark = mark;
    }

    @Column( nullable = false)
    private String Name;

    @Column(nullable = false)
    private String Mark;

    public Product(int quantity) {
        this.quantity = quantity;
    }

    public Product() {

    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public Product(int num, String name, String mark) {
        this.num = num;
        Name = name;
        Mark = mark;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMark() {
        return Mark;
    }

    public void setMark(String mark) {
        Mark = mark;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
