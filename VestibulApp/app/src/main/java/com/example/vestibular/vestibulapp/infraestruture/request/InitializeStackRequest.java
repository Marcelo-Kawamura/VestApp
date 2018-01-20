package com.example.vestibular.vestibulapp.infraestruture.request;

import com.android.volley.VolleyError;
import com.example.vestibular.vestibulapp.infraestruture.Constants;
import com.example.vestibular.vestibulapp.infraestruture.URLs;
import com.example.vestibular.vestibulapp.infraestruture.parser.InitializeStackParser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by marcelo on 15/01/18.
 */

public class InitializeStackRequest {
    static public void initializeStack(final OnResponseListener listener,int student_id,
                                       int problem_type_id, int topic_id) {
        final Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("student_id", student_id);
        params.put("problem_type_id", problem_type_id);
        params.put("topic_id", topic_id);
        VolleyRequest volleyRequest = new VolleyRequest(new InitializeStackParser(),
                URLs.getForRequest(Constants.INITIALIZE_STACK_TAG),
                Constants.INITIALIZE_STACK_TAG,new VolleyRequest.OnResponseListener(){
            @Override
            public void onResponse(Object entity) {
                listener.onInitializeStackResponse(entity);
            }
            @Override
            public void onResponseError(VolleyError error) {
                listener.onInitializeStackRequestError();
            }
            @Override
            public void onResponseEmpty() {
            }
        });

        volleyRequest.setPostRequest(params);
    }

    public interface OnResponseListener{
        public void onInitializeStackResponse(Object game_id);
        public void onInitializeStackRequestError();
    }
}


