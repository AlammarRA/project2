package com.example.e_commerce_rahafalammar.service;

import com.example.e_commerce_rahafalammar.model.category;
import com.example.e_commerce_rahafalammar.model.merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class categoryService {


    private ArrayList<category> categoriesList = new ArrayList<>();


    public ArrayList<category> getCategory(){
        return categoriesList;
    }

    public void addCategory(category newCategory){
        categoriesList.add(newCategory);
    }

    public void deleteCategory(int index){
        categoriesList.remove(index);
    }

    public void updateCategory(int index, category updateCategory){
        categoriesList.set(index,updateCategory);
    }

}
