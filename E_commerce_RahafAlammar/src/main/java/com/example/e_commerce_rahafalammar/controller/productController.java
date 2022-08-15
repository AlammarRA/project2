package com.example.e_commerce_rahafalammar.controller;

import com.example.e_commerce_rahafalammar.ApiResponse;
import com.example.e_commerce_rahafalammar.model.product;
import com.example.e_commerce_rahafalammar.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/auth")
public class productController {
        @Autowired
        private productService productService;


        @RequestMapping( path = "/products" , method = RequestMethod.GET)
        public ResponseEntity getAllProducts(){
            ArrayList<product> products = productService.getProduct();
            return ResponseEntity.status(200).body(products);
        }


        @RequestMapping(path = "/registerProducts" , method = RequestMethod.POST)
        public ResponseEntity addProduct(@RequestBody @Valid product newProduct , Errors errors){
            if(errors.hasErrors()){
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(new ApiResponse(message,400));
            }
            productService.addProduct(newProduct);
            return ResponseEntity.status(201).body(new ApiResponse("New product added!",201));
        }


        @RequestMapping(path = "/products/{index}" , method = RequestMethod.PUT)
        public ResponseEntity updateProduct(@RequestBody @Valid product updateProduct , @PathVariable int index , Errors errors){
            if(errors.hasErrors()){
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(new ApiResponse(message,400));
            }
            productService.updateProduct(index,updateProduct);
            return ResponseEntity.status(201).body(new ApiResponse("Product updated!",201));
        }


        @RequestMapping(path = "/products/{index}" , method = RequestMethod.DELETE)
        public ResponseEntity deleteProduct(@PathVariable int index){
            productService.deleteProduct(index);
            return ResponseEntity.status(200).body(new ApiResponse("Product deleted!",200));
        }

}
