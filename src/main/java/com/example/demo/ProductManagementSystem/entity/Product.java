package com.example.demo.ProductManagementSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Data
@Entity
@Table(name="TBL_Product")
@DynamicUpdate
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productId")
    private Integer productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "manufacturerDetails")
    private String manufacturerDetails;

    @Column(name = "price")
    private Integer price;
}
