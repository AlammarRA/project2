package com.example.e_commerce_rahafalammar.service;

import com.example.e_commerce_rahafalammar.model.merchantStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class merchantStockService {

    private ArrayList<merchantStock> merchantStockList = new ArrayList<>();


    public ArrayList<merchantStock> getMerchantStock(){
        return merchantStockList;
    }

    public void addMerchantStock(merchantStock newMerchantStock){
        merchantStockList.add(newMerchantStock);
    }

    public void deleteMerchantStock(int index){
        merchantStockList.remove(index);
    }

    public void updateMerchantStock(int index, merchantStock updateMerchantStock){
        merchantStockList.set(index,updateMerchantStock);
    }

}
