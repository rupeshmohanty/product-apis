package com.example.demo.ProductManagementSystem.service;

import com.example.demo.ProductManagementSystem.dto.ResponseDto;
import com.example.demo.ProductManagementSystem.entity.Product;
import com.example.demo.ProductManagementSystem.repository.ProductDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    // add a product!
    public ResponseDto addProduct(Product product) {
        Product newdata = new Product();
        newdata.setProductName(product.getProductName());
        newdata.setManufacturerDetails(product.getManufacturerDetails());
        newdata.setPrice(product.getPrice());
        newdata = productDao.save(newdata);

        ResponseDto res = new ResponseDto();
        if(!ObjectUtils.isEmpty(newdata) && newdata.getProductId() > 0) {
            res.setStatus("Success");
            res.setMessage("Product added!");
        } else {
            res.setStatus("Failed");
            res.setMessage("Unable to add product!");
        }

        return res;
    }

    // update a product!
    public ResponseDto updateProduct(Product product) {
        Product data = productDao.findById(product.getProductId()).get();
        data.setProductName(product.getProductName());
        data.setManufacturerDetails(product.getManufacturerDetails());
        data.setPrice(product.getPrice());
        data = productDao.save(data);

        ResponseDto res = new ResponseDto();
        if(!ObjectUtils.isEmpty(data) && data.getProductId() > 0) {
            res.setStatus("Success");
            res.setMessage("Product updated!");
            res.setProduct(data);
        } else {
            res.setStatus("Failed");
            res.setMessage("Unable to update product!");
        }

        return res;
    } 

    // view all products!
    public ResponseDto viewAllProducts() {
        Iterable<Product> data = productDao.findAll();

        ResponseDto res = new ResponseDto();
        res.setStatus("Success");
        res.setMessage("All products fetched!");
        res.setProducts(data);

        return res;
    }

    // view a particular product!
    public ResponseDto viewProduct(Integer pId) {
        ResponseDto res = new ResponseDto();

        Product data = productDao.findById(pId).get();

        if(!ObjectUtils.isEmpty(data)) {
            res.setStatus("Success");
            res.setMessage("Product details fetched!");
            res.setProduct(data);
        } else {
            res.setStatus("Failed");
            res.setMessage("Unable to fetch products!");
        }

        return res;
    }

    // delete a product!
    public ResponseDto deleteProduct(Integer pId) {
        ResponseDto res = new ResponseDto();

        productDao.deleteById(pId);

        // find the product deleted!
        Product data = productDao.findById(pId).orElse(null);

        if(ObjectUtils.isEmpty(data)) {
            res.setStatus("Success");
            res.setMessage("Product deleted!");
            res.setProduct(data);
        } else {
            res.setStatus("Failed");
            res.setMessage("Unable to delete products!");
        }

        return res;
    }
 
}
