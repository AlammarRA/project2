package com.example.e_commerce_rahafalammar.controller;

import com.example.e_commerce_rahafalammar.ApiResponse;
import com.example.e_commerce_rahafalammar.model.MyUser;
import com.example.e_commerce_rahafalammar.model.buy;
import com.example.e_commerce_rahafalammar.model.merchantStock;
import com.example.e_commerce_rahafalammar.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/auth")
public class userController {

    @Autowired
    private userService userService;


    @RequestMapping( path = "/users" , method = RequestMethod.GET)
    public ResponseEntity getAllUser(){
        ArrayList<MyUser> users = userService.getUsers();
        return ResponseEntity.status(200).body(users);
    }


    @RequestMapping(path = "/registerUser" , method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody @Valid MyUser myUser , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        userService.addUser(myUser);
        return ResponseEntity.status(201).body(new ApiResponse("New user added!",201));
    }


    @RequestMapping(path = "/users/{index}" , method = RequestMethod.PUT)
    public ResponseEntity updateUser(@RequestBody @Valid MyUser myUser ,@PathVariable int index , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        userService.updateUser(index,myUser);
        return ResponseEntity.status(201).body(new ApiResponse("User updated!",201));
    }


    @RequestMapping(path = "/users/{index}" , method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable int index){
        userService.deleteUser(index);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted!",200));
    }


    @RequestMapping(path = "/addProductToAMerchantStock" , method = RequestMethod.POST)
    public ResponseEntity addProductToAMerchantStock(@RequestBody @Valid merchantStock merchantStock , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        userService.addProductToAMerchantStock(merchantStock);
        return ResponseEntity.status(201).body(new ApiResponse("New a merchant stock added!",201));
    }


    @RequestMapping(path = "/buyAProductDirectly" , method = RequestMethod.POST)
    public ResponseEntity buyAProductDirectly(@RequestBody @Valid buy buyUser , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        if(userService.buyAProductDirectly(buyUser) == 1 || userService.buyAProductDirectly(buyUser) == 0);
        {
        return ResponseEntity.status(201).body(new ApiResponse("DONE!",201));}
    }
}
