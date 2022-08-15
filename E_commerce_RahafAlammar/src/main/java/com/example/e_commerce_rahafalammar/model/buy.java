package com.example.e_commerce_rahafalammar.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Data
public class buy {
    @NotNull
    @Size(min =3 , max = 3 , message = "The merchant id must be 3 character")
    private String productId;
    @NotNull
    @Size(min =3 , max = 3 , message = "The merchant id must be 3 character")
    private String merchantId;
    @NotNull
    @Size( min = 3 , message = "The user id must be 3 character")
    private String userId;
}
