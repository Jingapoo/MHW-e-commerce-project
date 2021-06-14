package com.example.mhwequipment.shoppingHub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * This part that actually exposes RESTful APIs for CRUD operations – a Spring controller following REST style
 * RestController enables the handler methods in this controller to be exposed as RESTful APIs,
 * e.g. reading JSON data from the request and including JSON data to the response. And this REST controller still
 * takes advantages of Spring’s dependency injection
 * The difference using RESTful APIs vs.SpringMVC
 * 1. RESTful APIs is specifically designed for network communications
 * 2. SpringMVC is focused on running the full stack with Thymeleaf templates
 */
@RestController //indicates that the data returned by each method will be written straight into the response body instead of rendering a template.
public class HubController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Product> list(){
        return service.listAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> get(@PathVariable Integer id){
        /**
         * implement the second method for a RESTful API that allows
         * the clients to get information about a specific product based on ID
         * if a product is found for the given ID, the server sends a response that includes JSON representation of
         * the Product object with HTTP status OK (200).
         * Else if no product is found, it returns HTTP status Not Found (404).
         */
        try{
            Product product = service.get(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products")
    public void add(@RequestBody Product product){
        /**
         * expose a RESTful API that allows the clients to create a product
         */
        service.save(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id){
        /**
         * exposes RESTful API for update operation
         * this method accepts only HTTP PUT request. If a product found with the given ID,
         * it is updated and the server returns HTTP status OK.
         * If no product found, the HTTP status Not Found (404) is returned.
         */
        try{
            Product existProduct = service.get(id);
            service.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

}
