package com.example.demo.ProductManagementSystem.controller;

import com.example.demo.ProductManagementSystem.dto.ResponseDto;
import com.example.demo.ProductManagementSystem.entity.Product;
import com.example.demo.ProductManagementSystem.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product",produces="application/json")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/test")
    String test() {
        return "this is just for test";
    }

    @PostMapping("/add")
    ResponseDto addProduct(@RequestBody Product product) {
        ResponseDto res = productService.addProduct(product);
        return res;
    }

    @PostMapping("/edit")
    ResponseDto editProduct(@RequestBody Product product) {
        ResponseDto res = productService.updateProduct(product);
        return res;
    }

    @GetMapping("/viewAll")
    ResponseDto viewAll() {
        ResponseDto res = productService.viewAllProducts();
        return res;
    }

    @PostMapping("/view")
    ResponseDto viewProduct(@RequestBody Product product) {
        ResponseDto res = productService.viewProduct(product.getProductId());
        return res;
    }

    @PostMapping("/delete")
    ResponseDto deleteProduct(@RequestBody Product product) {
        ResponseDto res = productService.deleteProduct(product.getProductId());
        return res;
    }
}
