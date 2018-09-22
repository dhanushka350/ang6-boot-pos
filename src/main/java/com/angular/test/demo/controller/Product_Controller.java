package com.angular.test.demo.controller;

import com.angular.test.demo.dto.Product;
import com.angular.test.demo.model.Product_Model;
import com.angular.test.demo.repository.Product_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class Product_Controller {

    @Autowired
    private Product_Repository productRepository;

    @RequestMapping(name = "/save", method = RequestMethod.POST)
    @ResponseBody
    public boolean saveProduct(@RequestBody Product productDto) {
        Product_Model model = new Product_Model();
        model.setId(productDto.getId());
        model.setName(productDto.getName());
        model.setQty(productDto.getQty());
        model.setUnitPrice(productDto.getUnitPrice());
        productRepository.save(model);
        return true;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> allProduct() {
        List<Product> list = new ArrayList<>();
        Product product = null;
        for (Product_Model model : productRepository.findAll()) {
            product = new Product();
            product.setId(model.getId());
            product.setName(model.getName());
            product.setQty(model.getQty());
            product.setUnitPrice(model.getUnitPrice());
            list.add(product);
        }
        ;
        return list;
    }
}
