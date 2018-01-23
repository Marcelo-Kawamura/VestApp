package com.example.vestibular.vestibulapp.infraestruture.request;

import android.util.Log;

import com.android.volley.VolleyError;
import com.example.vestibular.vestibulapp.domain.entity.Problem;
import com.example.vestibular.vestibulapp.domain.entity.Session;
import com.example.vestibular.vestibulapp.infraestruture.Constants;
import com.example.vestibular.vestibulapp.infraestruture.URLs;
import com.example.vestibular.vestibulapp.infraestruture.parser.ProblemParser;
import com.example.vestibular.vestibulapp.infraestruture.parser.UserParser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by renan on 12/01/2018.
 */

public class ProblemRequest {
    static public void getProblemFromStack(final OnResponseListener listener,final int problemId,final int answer,int topicId, int game_id) {
        final Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("student_id", Session.getInstance().getUser().getId());
        params.put("problem_id", problemId);
        params.put("correct", answer);
        params.put("game_id", game_id);
        VolleyRequest volleyRequest = new VolleyRequest(new ProblemParser(), URLs.getUrlWithValue(Constants.STACK_PROBLEM_REQUEST_TAG,Integer.toString(topicId)), Constants.STACK_PROBLEM_REQUEST_TAG,new VolleyRequest.OnResponseListener(){
            @Override
            public void onResponse(Object entity) {
                listener.onProblemsRequestResponse((Problem)entity);
            }
            @Override
            public void onResponseError(VolleyError error) {
                Log.e("ProblemRequest", "onResponse", error);
                listener.onProblemsRequestError();
            }

            @Override
            public void onResponseEmpty(Object entity) {
                listener.onProblemsRequestEmpty();
            }


        });
        volleyRequest.setPostRequest(params);
    }

    public interface OnResponseListener{
        public void onProblemsRequestResponse(Problem problem);
        public void onProblemsRequestError();
        public void onProblemsRequestEmpty();

    }

}
