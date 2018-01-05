package com.example.vestibular.vestibulapp.infraestruture.parser;

import com.example.vestibular.vestibulapp.domain.entity.User;

import org.json.JSONObject;

/**
 * Created by marcelo on 30/12/17.
 */

public class UserParser implements BaseParser {
    @Override
    public Object jsonToEntity(JSONObject response) {
        String name;
        String lastName;
        String email;
        String cpf;
        String token;
        User user = null;
        try {
            if(response.getInt("status")==0){
                return null;
            }else{
                response = response.getJSONObject("data");
            }
            name = response.getString("student_name");
            lastName = response.getString("student_last_name");
            email = response.getString("student_email");
            cpf = response.getString("student_cpf");
            token = response.getString("student_token");
            user = new User(name,lastName,email,cpf,token);
        }catch(Exception ex){
            return null;
        }
        return user;
    }
}
