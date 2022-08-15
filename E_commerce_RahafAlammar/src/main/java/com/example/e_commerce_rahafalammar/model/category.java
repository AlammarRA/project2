package com.example.e_commerce_rahafalammar.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Data
public class category {
    @NotNull
    @Size( min = 3 , message = "The category id must be 3 character")
    private String id;
    @NotNull
    @Size(min =3 , message = "The category name must be more or equal 3 character")
    private String name;
}
