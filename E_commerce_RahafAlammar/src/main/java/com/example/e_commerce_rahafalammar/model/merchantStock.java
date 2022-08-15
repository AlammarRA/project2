package com.example.e_commerce_rahafalammar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Data
public class merchantStock {
    @NotNull
    @Size( min = 3 , message = "The merchant id must be 3 character")
    private String id;
    @NotNull
    @Size(min =3 , max = 3 , message = "The merchant id must be 3 character")
    private String productId;
    @NotNull
    @Size(min =3 , max = 3 , message = "The merchant id must be 3 character")
    private String merchantId;
    @NotNull
    @Range(min =10 , message = "The stock have to be more than 10 at start")
    private int stock;
}
