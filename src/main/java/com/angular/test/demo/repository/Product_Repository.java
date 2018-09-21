package com.angular.test.demo.repository;

import com.angular.test.demo.model.Product_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Product_Repository extends JpaRepository<Product_Model, Integer> {


}
