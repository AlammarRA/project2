package com.example.e_commerce_rahafalammar.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Data
public class product {
    @NotNull
    @Size( min = 3 , message = "The product id must be  3 character")
    private String id;
    @NotNull
    @Size(min =3 , message = "The product name more or equal 3 character")
    private String name;
    @NotNull
    @Min(value = 0 , message = "The product price must be a positive number")
    private Double price;
    @NotNull
    @Size(min =3 , max = 3 , message = "The product category must be 3 character")
    private String categoryId;
}
