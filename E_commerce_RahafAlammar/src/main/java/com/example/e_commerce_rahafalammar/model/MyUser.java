package com.example.e_commerce_rahafalammar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@AllArgsConstructor
@Data
public class MyUser {
    @NotNull
    @Size( min = 3 , message = "The user id must be 3 character")
    private String id;
    @NotNull
    @Size(min =5 ,message = "The username must be more than 5 character")
    private String username;
    @NotNull
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,}$" , message = "Please enter strong password")
    private String password;
    @NotNull
    @Email
    private String email;
    @NotEmpty(message = "role can't be empty")
    @Pattern(regexp = "(Admin|Customer)",message = "Role must be in Admin or Customer only")
    private String role;
    @NotNull
    @Positive
    @Min(value = 0 , message = "The user balance must be a positive number")
    private Double balance;
}
