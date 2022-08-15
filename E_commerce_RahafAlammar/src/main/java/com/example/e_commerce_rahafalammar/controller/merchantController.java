package com.example.e_commerce_rahafalammar.controller;

import com.example.e_commerce_rahafalammar.ApiResponse;
import com.example.e_commerce_rahafalammar.model.merchant;
import com.example.e_commerce_rahafalammar.service.merchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;


@RestController
@RequestMapping("/api/v1/auth")
public class merchantController {

    @Autowired
    private merchantService merchantService;




    @RequestMapping( path = "/merchants" , method = RequestMethod.GET)
    public ResponseEntity getAllMerchant(){
        ArrayList<merchant> merchantStock = merchantService.getMerchants();
        return ResponseEntity.status(200).body(merchantStock);
    }


    @RequestMapping(path = "/registerMerchants" , method = RequestMethod.POST)
    public ResponseEntity addMerchant(@RequestBody @Valid merchant newMerchant , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        merchantService.addMerchants(newMerchant);
        return ResponseEntity.status(201).body(new ApiResponse("New merchants added!",201));
    }


    @RequestMapping(path = "/merchants/{index}" , method = RequestMethod.PUT)
    public ResponseEntity updateMerchant(@RequestBody @Valid merchant updateMerchants , @PathVariable int index , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        merchantService.updateMerchants(index,updateMerchants);
        return ResponseEntity.status(201).body(new ApiResponse("Merchants updated!",201));
    }


    @RequestMapping(path = "/merchants/{index}" , method = RequestMethod.DELETE)
    public ResponseEntity deleteMerchant(@PathVariable int index){
        merchantService.deleteMerchants(index);
        return ResponseEntity.status(200).body(new ApiResponse("Merchants deleted!",200));
    }



}
