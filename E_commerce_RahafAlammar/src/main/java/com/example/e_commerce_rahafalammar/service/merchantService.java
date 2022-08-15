package com.example.e_commerce_rahafalammar.service;
import com.example.e_commerce_rahafalammar.model.merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class merchantService {


    private ArrayList<merchant> merchantsList = new ArrayList<>();


    public ArrayList<merchant> getMerchants(){
        return merchantsList;
    }

    public void addMerchants(merchant newMerchant){
        merchantsList.add(newMerchant);
    }

    public void deleteMerchants(int index){
        merchantsList.remove(index);
    }

    public void updateMerchants(int index, merchant updateMerchantStock){
        merchantsList.set(index,updateMerchantStock);
    }
}
