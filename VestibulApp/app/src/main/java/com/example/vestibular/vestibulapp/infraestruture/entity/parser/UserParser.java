package com.example.vestibular.vestibulapp.infraestruture.entity.parser;

import com.example.vestibular.vestibulapp.domain.entity.User;

import org.json.JSONObject;

/**
 * Created by marcelo on 30/12/17.
 */

public class UserParser {
    public static User getUserFromJson(JSONObject userJson){
        String name;
        String lastName;
        String email;
        String cpf;
        String token;
        User user = null;
        try {
            name = userJson.getString("student_name");
            lastName = userJson.getString("student_last_name");
            email = userJson.getString("student_email");
            cpf = userJson.getString("student_cpf");
            token = userJson.getString("student_token");
            user = new User(name,lastName,email,cpf,token);
        }catch(Exception ex){
            return null;
        }
        return user;
    }
}
