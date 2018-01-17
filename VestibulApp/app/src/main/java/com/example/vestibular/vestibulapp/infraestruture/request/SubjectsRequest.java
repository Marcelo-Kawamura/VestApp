package com.example.vestibular.vestibulapp.infraestruture.request;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.vestibular.vestibulapp.domain.entity.Subject;
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

public class SubjectsRequest {
    private SubjectsInterface subjectsInterface;
    private ArrayList<Subject> subjectsArrayList;
    String url = URLs.getForRequest(Constants.SUBJECTS_TAG);
    public SubjectsRequest(SubjectsRequest.SubjectsInterface subjectsInterface){
        this.subjectsInterface = subjectsInterface;
    }
    public void sendRequest(){
        String url = URLs.getForRequest(Constants.SUBJECTS_TAG);
        Log.d("url:", url);

        JsonObjectRequest SubjectsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("msg:", "chegou aqui");
                        int subject_id=0;
                        String subject_name="";
                        String subject_icon="";

                        subjectsArrayList = new ArrayList<Subject>();
                        try {
                            JSONArray SubjectsArray = response.getJSONArray("data");
                            Log.d("url:", "chegou aqui");
                            for(int i=0; i<SubjectsArray.length();i++){
                                JSONObject SubjectsObjRequest = SubjectsArray.getJSONObject(i);
                                if(SubjectsObjRequest.has("subject_id")){
                                    subject_id =SubjectsObjRequest.getInt("subject_id");
                                }
                                if(SubjectsObjRequest.has("subject_name")){
                                    subject_name = SubjectsObjRequest.getString("subject_name");
                                }
                                if(SubjectsObjRequest.has("subject_photo")){
                                    subject_icon = SubjectsObjRequest.getString("subject_photo");
                                }
                                Subject subjects = new Subject(subject_id,subject_name,subject_icon);
                                subjectsArrayList.add(subjects);
                                Log.d("url:", String.valueOf(subjectsArrayList.size()));
                            }
                        }
                        catch (Exception ex){
                            Log.d( "Excecao", ex.toString());
                        }
                        subjectsInterface.onSubjectsResponse(subjectsArrayList);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("error volley", "eero", error);

                        // TODO Auto-generated method stub

                    }
                }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(SubjectsObjRequest);
    }
    public interface SubjectsInterface{
        void onSubjectsResponse(ArrayList<Subject> subjectsList);
    }

}
