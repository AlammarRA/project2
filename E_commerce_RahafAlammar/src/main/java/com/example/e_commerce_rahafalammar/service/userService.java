package com.example.e_commerce_rahafalammar.service;

import com.example.e_commerce_rahafalammar.model.MyUser;
import com.example.e_commerce_rahafalammar.model.buy;
import com.example.e_commerce_rahafalammar.model.merchantStock;
import com.example.e_commerce_rahafalammar.model.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class userService {

    private ArrayList<MyUser> userList = new ArrayList<>();
    private ArrayList<merchantStock> merchantStockList = new ArrayList<>();
    private ArrayList<product> productsList = new ArrayList<>();
    @Autowired
    private merchantStockService merchantStockServices;


    public ArrayList<MyUser> getUsers() {
        return userList;
    }

    public void addUser(MyUser user) {
        userList.add(user);
    }

    public void deleteUser(int index) {
        userList.remove(index);
    }

    public void updateUser(int index, MyUser user) {
        userList.set(index, user);
    }


    public void addProductToAMerchantStock(merchantStock merchantStock) {
        if (merchantStock.getStock() > 10) {
            for (int i = 0; i < productsList.size(); i++) {
                if (productsList.get(i).getId().equals(merchantStock.getProductId())) {
                    merchantStockList.get(i).setStock(merchantStockList.get(i).getStock() + merchantStock.getStock());
                } else {
                    merchantStockServices.addMerchantStock(merchantStock);
                }
            }
        }
    }

    public int buyAProductDirectly(buy buyUser) {
        int indexToSaveProducts = 0, indexToSaveUser = 0;


        //find product
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getId().equals(buyUser.getProductId())) {
                indexToSaveProducts = i;
                break;
            }
        }


        //find user
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId().equals(buyUser.getUserId())) {
                indexToSaveUser = i;
                break;
            }
        }


        for (int i = 0; i < merchantStockList.size(); i++) {
            if (merchantStockList.get(i).getMerchantId().equals(buyUser.getMerchantId()) && merchantStockList.
                    get(i).getStock() != 0 && userList.get(indexToSaveUser).getBalance() > productsList.get(indexToSaveProducts).getPrice()) {

                merchantStockList.get(i).setStock(merchantStockList.get(i).getStock() - 1);
                double balance1 = userList.get(indexToSaveUser).getBalance(), price1 = productsList.get(indexToSaveProducts).getPrice();
                double balance = balance1 - price1;
                userList.get(indexToSaveUser).setBalance(balance);
                return 1;
            } else return -1;
        }
        return 0;
    }


}