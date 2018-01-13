package com.example.vestibular.vestibulapp.infraestruture.request;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.vestibular.vestibulapp.domain.entity.Topic;
import com.example.vestibular.vestibulapp.infraestruture.Constants;
import com.example.vestibular.vestibulapp.infraestruture.URLs;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by marcelo on 31/12/17.
 */

public class TopicsRequest {
    private TopicsRequest.TopicsInterface topicsInterface;
    private ArrayList<Topic> topicsArrayList;

    public TopicsRequest(TopicsRequest.TopicsInterface topicsInterface){
        this.topicsInterface = topicsInterface;
    }

    public void sendRequest(String subject_name){
        String url = URLs.getForRequest(Constants.TOPICS_TAG);
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        int topid_id;
                        String topic_name;
                        int subject_id;
                        topicsArrayList = new ArrayList<>();
                        try {
                            JSONArray arrayTopics = response.getJSONArray("data");
                            for(int i=0; i<arrayTopics.length();i++){
                                JSONObject topicsObject = arrayTopics.getJSONObject(i);
                                topid_id =   topicsObject.getInt("topic_id");
                                topic_name = topicsObject.getString("topic_name");
                                subject_id=  topicsObject.getInt("subject_id");
                                Topic topics = new Topic(topid_id, topic_name,subject_id);
                                topicsArrayList.add(topics);
                            }
                        }
                        catch (Exception ex){
                            Log.d( "Exceção", ex.toString());
                        }
                        topicsInterface.onTopicsResponse(topicsArrayList);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d( "Erro", error.toString());

                    }
                }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(jsObjRequest);
    }
    public interface TopicsInterface{
        void onTopicsResponse(ArrayList<Topic> topicsArrayList);
    }

}
