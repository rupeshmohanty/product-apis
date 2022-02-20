package com.example.demo.ProductManagementSystem.dto;

import com.example.demo.ProductManagementSystem.entity.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ResponseDto {
    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("product")
    private Product product;

    @JsonProperty("productsList")
    private Iterable<Product> products;
}
