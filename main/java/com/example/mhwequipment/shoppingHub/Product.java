package com.example.mhwequipment.shoppingHub;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * RESTful web services APIs for CRUD operations on a MySQL database.
 * The CRUD operations include Create, Retrieve, Update and Delete.
 * Spring Boot-based web application that exposes RESTful CRUD APIs to clients.
 *
 */

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String product_name;

    @NotNull
    private double price;

    @NotEmpty
    private String description;

    public Product(){

    }

    public Product(Integer id, String product_name, double price, String description){
        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
