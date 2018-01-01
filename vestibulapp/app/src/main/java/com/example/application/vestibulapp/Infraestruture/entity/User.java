package com.example.application.vestibulapp.Infraestruture.entity;

import java.util.ArrayList;

/**
 * Created by renan on 29/12/2017.
 */

public class User {
    private String name;
    private String lastName;
    private String email;
    private String cpf;
    private String token;
    public User(String name,String lastName,String email,String cpf,String token){
        this.name = name;
        this.lastName = lastName;
        this.cpf = cpf;
        this.email = email;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getToken() {
        return token;
    }
}
