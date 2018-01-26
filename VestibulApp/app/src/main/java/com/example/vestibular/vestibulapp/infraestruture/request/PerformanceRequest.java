package com.example.vestibular.vestibulapp.infraestruture.request;

import android.util.Log;

import com.android.volley.VolleyError;
import com.example.vestibular.vestibulapp.domain.entity.Performance;
import com.example.vestibular.vestibulapp.domain.entity.Problem;
import com.example.vestibular.vestibulapp.domain.entity.Session;
import com.example.vestibular.vestibulapp.infraestruture.Constants;
import com.example.vestibular.vestibulapp.infraestruture.URLs;
import com.example.vestibular.vestibulapp.infraestruture.parser.PerformanceParser;
import com.example.vestibular.vestibulapp.infraestruture.parser.ProblemParser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by marcelo on 23/01/18.
 */

public class PerformanceRequest {
    static public void getPerformance(final PerformanceRequest.OnResponseListener listener, int problem_type_id, int topic_id, int game_id) {
        final Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("problem_type_id", problem_type_id);
        params.put("student_id", Session.getInstance().getUser().getId());
        params.put("topic_id", topic_id);
        params.put("game_id", game_id);
        VolleyRequest volleyRequest = new VolleyRequest(
                new PerformanceParser(),
                URLs.getForRequest(Constants.PERFORMANCE_REQUEST_TAG),
                Constants.PERFORMANCE_REQUEST_TAG,
                new VolleyRequest.OnResponseListener(){
            @Override
            public void onResponse(Object entity) {
                listener.onPerformanceRequestResponse((Performance)entity);
            }
            @Override
            public void onResponseError(VolleyError error) {
                Log.e("PerformanceRequest", "onResponse", error);
                listener.onPerformanceRequestError();
            }

            @Override
            public void onResponseEmpty(Object entity) {
                listener.onPerformanceRequestEmpty();
            }
        });
        volleyRequest.setPostRequest(params);
    }


    public interface OnResponseListener {
        public void onPerformanceRequestResponse(Performance performance);
        public void onPerformanceRequestError();
        public void onPerformanceRequestEmpty();
    }
}
