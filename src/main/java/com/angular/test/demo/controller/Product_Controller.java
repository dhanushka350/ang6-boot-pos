package com.angular.test.demo.controller;

import com.angular.test.demo.dto.Customer;
import com.angular.test.demo.dto.Product;
import com.angular.test.demo.model.Product_Model;
import com.angular.test.demo.repository.Product_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class Product_Controller {

    @Autowired
    private Product_Repository productRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public boolean saveProduct(@RequestBody Product productDto) {
        System.out.println("ok");
        Product_Model model = new Product_Model();
        model.setId(productDto.getId());
        model.setName(productDto.getName());
        model.setQty(productDto.getQty());
        model.setUnitPrice(productDto.getUnitPrice());
        productRepository.save(model);
        return true;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteProduct(@PathVariable(value = "id") String product) {
        productRepository.deleteById(Integer.parseInt(product));
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

    @RequestMapping(value = "/by/code/{code}", method = RequestMethod.GET)
    @ResponseBody
    public Product itemByCode(@PathVariable(value = "code") String code) {
        Product_Model one = productRepository.getOne(Integer.parseInt(code));
        Product product = new Product();
        product.setUnitPrice(one.getUnitPrice());
        product.setQty(one.getQty());
        product.setName(one.getName());
        product.setId(one.getId());
        return product;
    }

    //customer
    @RequestMapping(value = "/get/customer/{code}", method = RequestMethod.GET)
    @ResponseBody
    public Customer customerByCode(@PathVariable(value = "code") String code) {
        System.out.println("called");
        Customer customer = new Customer();
        customer.setCode(Integer.parseInt(code));
        customer.setName("Customer From Backend = cust " + code);
        return customer;
    }
}
