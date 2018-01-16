package com.example.vestibular.vestibulapp.infraestruture.request;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.vestibular.vestibulapp.infraestruture.parser.BaseParser;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by renan on 03/01/2018.
 */

 public class VolleyRequest {
    private OnResponseListener listener;
    private String TAG;
    private String url;
    private BaseParser baseParser;
    public VolleyRequest(BaseParser baseParser,String url,String TAG,OnResponseListener listener ){
        this.listener = listener;
        this.baseParser = baseParser;
        this.url=url;
        this.TAG = TAG;
    }
    private void setUpRequest(final Map params, final int METHOD){
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (METHOD, url, new JSONObject(params), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            response = response.getJSONObject("data");
                            if (response.has("null")) {
                                listener.onResponseEmpty();
                            } else {
                                listener.onResponse(baseParser.jsonToEntity(response));
                            }
                        }
                        catch (Exception ex){
                            //TODO Criar tratamento de exception quando há falhas ao pegar dados
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onResponseError(error);
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                return params;
            }
        };
        AppController.getInstance().cancelPendingRequests(TAG);
        AppController.getInstance().addToRequestQueue(jsObjRequest);
    }
    public void  setGetRequest(){
        setUpRequest(null,Request.Method.GET);
    }
    public void  setPostRequest(final Map params){
        setUpRequest(params,Request.Method.POST);
    }
    public interface OnResponseListener{
        void onResponse(Object entity);
        void onResponseError(VolleyError error);
        void onResponseEmpty();

    }
}
