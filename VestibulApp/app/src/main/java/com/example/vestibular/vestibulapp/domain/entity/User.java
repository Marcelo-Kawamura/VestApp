package com.example.vestibular.vestibulapp.domain.entity;

/**
 * Created by marcelo on 30/12/17.
 */

public class User {
    public int getId() {
        return id;
    }

    private int id;
    private String name;
    private String lastName;
    private String email;
    private String cpf;
    private String token;
    public User(int id,String name,String lastName,String email,String cpf,String token){
        this.id = id;
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

