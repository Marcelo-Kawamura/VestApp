package com.example.vestibular.vestibulapp.infraestruture.entity.request;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.vestibular.vestibulapp.domain.entity.User;
import com.example.vestibular.vestibulapp.infraestruture.Constants;
import com.example.vestibular.vestibulapp.infraestruture.URLs;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by marcelo on 31/12/17.
 */

public class UserRequest {
    static public void createNewUser(final UsersRequestInterface usersRequestInterface, final String name,final String lastName,final String cpf,final String email,final String password) {
        Log.d("",name);

        final Map<String, String> params = new HashMap<String, String>();
        params.put("student_name", name);
        params.put("student_last_name", lastName);
        params.put("student_cpf", cpf);
        params.put("student_email", email);
        params.put("student_password", password);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, URLs.getForRequest(Constants.USERS_TAG),new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{Log.d("string","string");
                            if(response.getInt("status")==0){

                                usersRequestInterface.onUsersRequestError();
                            }else{
                                String token = response.getJSONObject("data").getString("student_token");
                                Log.d("string",token);
                                User user = new User(name,lastName,email,cpf,token);
                                usersRequestInterface.onUsersRequestResponse(user);
                            }
                        }catch(Exception ex){
                            usersRequestInterface.onUsersRequestError();
                        }

                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        usersRequestInterface.onUsersRequestError();
                    }
                });
        AppController.getInstance().addToRequestQueue(jsonObjReq, Constants.SESSIONS_TAG);
    }
    public interface UsersRequestInterface{
        public void onUsersRequestResponse(User user);
        public void onUsersRequestError();
    }
}
