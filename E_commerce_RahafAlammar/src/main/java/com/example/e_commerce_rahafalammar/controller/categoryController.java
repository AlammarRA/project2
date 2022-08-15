package com.example.e_commerce_rahafalammar.controller;

import com.example.e_commerce_rahafalammar.ApiResponse;
import com.example.e_commerce_rahafalammar.model.category;
import com.example.e_commerce_rahafalammar.service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/auth")
public class categoryController {
        @Autowired
        private categoryService categoryService;

        @RequestMapping( path = "/category" , method = RequestMethod.GET)
        public ResponseEntity getAllMerchantStock(){
            ArrayList<category> categories = categoryService.getCategory();
            return ResponseEntity.status(200).body(categories);
        }


        @RequestMapping(path = "/registerCategory" , method = RequestMethod.POST)
        public ResponseEntity addMerchantStock(@RequestBody @Valid category newCategory , Errors errors){
            if(errors.hasErrors()){
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(new ApiResponse(message,400));
            }
            categoryService.addCategory(newCategory);
            return ResponseEntity.status(201).body(new ApiResponse("New merchants added!",201));
        }


        @RequestMapping(path = "/category/{index}" , method = RequestMethod.PUT)
        public ResponseEntity updateMerchantStock(@RequestBody @Valid category updateCategory , @PathVariable int index , Errors errors){
            if(errors.hasErrors()){
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(new ApiResponse(message,400));
            }
            categoryService.updateCategory(index,updateCategory);
            return ResponseEntity.status(201).body(new ApiResponse("Category updated!",201));
        }


        @RequestMapping(path = "/category/{index}" , method = RequestMethod.DELETE)
        public ResponseEntity deleteCategory(@PathVariable int index){
            categoryService.deleteCategory(index);
            return ResponseEntity.status(200).body(new ApiResponse("Category deleted!",200));
        }

}
