package com.example.e_commerce_rahafalammar.service;

import com.example.e_commerce_rahafalammar.model.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class productService {

        private ArrayList<product> productsList = new ArrayList<>();


        public ArrayList<product> getProduct(){
            return productsList;
        }

        public void addProduct(product newProduct){
            productsList.add(newProduct);
        }

        public void deleteProduct(int index){
            productsList.remove(index);
        }

        public void updateProduct(int index, product updateProduct){
            productsList.set(index,updateProduct);
        }

}
