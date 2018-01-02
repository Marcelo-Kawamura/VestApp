package com.example.vestibular.vestibulapp.infraestruture.entity.request;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.vestibular.vestibulapp.domain.entity.User;
import com.example.vestibular.vestibulapp.infraestruture.Constants;
import com.example.vestibular.vestibulapp.infraestruture.URLs;
import com.example.vestibular.vestibulapp.infraestruture.entity.parser.UserParser;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by marcelo on 30/12/17.
 */

public class SessionRequest {
    static public void getSessionByCredentials(final SessionsRequestInterface sessionsRequestInterface,final String email,final String password) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("student_email", email);
        params.put("student_password", password);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, URLs.getForRequest(Constants.SESSIONS_TAG), new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            if(response.getInt("status")==0){
                                sessionsRequestInterface.onSessionsRequestResponse(null);
                            }else{
                                sessionsRequestInterface.onSessionsRequestResponse(UserParser.getUserFromJson(response.getJSONObject("data")));
                            }
                        }catch(Exception ex){
                            sessionsRequestInterface.onSessionsRequestError();
                        }

                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        sessionsRequestInterface.onSessionsRequestError();
                    }
                });
        AppController.getInstance().addToRequestQueue(jsonObjReq, Constants.SESSIONS_TAG);
    }

    public interface SessionsRequestInterface{
        public void onSessionsRequestResponse(User user);
        public void onSessionsRequestError();
    }
}
