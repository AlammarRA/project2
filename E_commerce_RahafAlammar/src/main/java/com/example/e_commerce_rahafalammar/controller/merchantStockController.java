package com.example.e_commerce_rahafalammar.controller;

import com.example.e_commerce_rahafalammar.ApiResponse;
import com.example.e_commerce_rahafalammar.model.merchantStock;
import com.example.e_commerce_rahafalammar.service.merchantStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/auth")
public class merchantStockController {

    @Autowired
    private merchantStockService merchantStockServices;


    @RequestMapping( path = "/merchantStock" , method = RequestMethod.GET)
    public ResponseEntity getAllMerchantStock(){
        ArrayList<merchantStock> merchantStock = merchantStockServices.getMerchantStock();
        return ResponseEntity.status(200).body(merchantStock);
    }


    @RequestMapping(path = "/registerMerchantStock" , method = RequestMethod.POST)
    public ResponseEntity addMerchantStock(@RequestBody @Valid merchantStock newMerchantStock , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        merchantStockServices.addMerchantStock(newMerchantStock);
        return ResponseEntity.status(201).body(new ApiResponse("New MerchantStock added!",201));
    }


    @RequestMapping(path = "/merchantStock/{index}" , method = RequestMethod.PUT)
    public ResponseEntity updateMerchantStock(@RequestBody @Valid merchantStock updateMerchantStock , @PathVariable int index , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        merchantStockServices.updateMerchantStock(index,updateMerchantStock);
        return ResponseEntity.status(201).body(new ApiResponse("MerchantStock updated!",201));
    }


    @RequestMapping(path = "/merchantStock/{index}" , method = RequestMethod.DELETE)
    public ResponseEntity deleteMerchantStock(@PathVariable int index){
        merchantStockServices.deleteMerchantStock(index);
        return ResponseEntity.status(200).body(new ApiResponse("MerchantStock deleted!",200));
    }

}
