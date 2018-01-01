package com.example.vestibular.vestibulapp.infraestruture.entity.request;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.vestibular.vestibulapp.domain.Subjects;
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
    private ArrayList<Subjects> subjectsArrayList;
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
                        int subject_id;
                        String subject_name;
                        String subject_icon;

                        subjectsArrayList = new ArrayList<Subjects>();
                        try {
                            JSONArray SubjectsArray = response.getJSONArray("data");
                            Log.d("url:", "chegou aqui");
                            for(int i=0; i<SubjectsArray.length();i++){
                                JSONObject SubjectsObjRequest = SubjectsArray.getJSONObject(i);

                                subject_id =SubjectsObjRequest.getInt("subject_id");
                                subject_name = SubjectsObjRequest.getString("subject_name");
                                subject_icon = SubjectsObjRequest.getString("subject_photo");
                                Subjects subjects = new Subjects(subject_id,subject_name,subject_icon);
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
                        // TODO Auto-generated method stub

                    }
                });
        AppController.getInstance().addToRequestQueue(SubjectsObjRequest);
    }
    public interface SubjectsInterface{
        void onSubjectsResponse(ArrayList<Subjects> subjectsList);
    }

}
