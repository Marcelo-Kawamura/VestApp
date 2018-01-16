package com.example.vestibular.vestibulapp.infraestruture.request;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.vestibular.vestibulapp.domain.entity.User;
import com.example.vestibular.vestibulapp.infraestruture.Constants;
import com.example.vestibular.vestibulapp.infraestruture.URLs;
import com.example.vestibular.vestibulapp.infraestruture.parser.UserParser;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by marcelo on 30/12/17.
 */

public class SessionRequest {
    static public void getSessionByCredentials(final OnResponseListener listener,final String email,final String password) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("student_email", email);
        params.put("student_password", password);
        VolleyRequest volleyRequest = new VolleyRequest(new UserParser(),URLs.getForRequest(Constants.SESSIONS_TAG),Constants.SESSIONS_TAG,new VolleyRequest.OnResponseListener(){
            @Override
            public void onResponse(Object entity) {
                listener.onSessionsRequestResponse((User)entity);
            }
            @Override
            public void onResponseError(VolleyError error) {
                listener.onSessionsRequestError();
            }

            @Override
            public void onResponseEmpty() {

            }
        });
        volleyRequest.setPostRequest(params);
    }

    public interface OnResponseListener{
        public void onSessionsRequestResponse(User user);
        public void onSessionsRequestError();
    }
}
