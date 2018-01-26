package com.example.vestibular.vestibulapp.infraestruture.parser;

import android.util.Log;

import com.example.vestibular.vestibulapp.domain.entity.Performance;

import org.json.JSONObject;

/**
 * Created by marcelo on 23/01/18.
 */

public class PerformanceParser implements BaseParser{
    @Override
    public Object jsonToEntity(JSONObject response){
        float progress;
        float performance;
        int errors;

        try{
            int checkStatus = response.getInt("status");
            if(checkStatus==0 || checkStatus ==-1){
                return null;
            } else{
                response=response.getJSONObject("data");
                progress = Float.parseFloat(response.getString("progress"));
                performance = Float.parseFloat(response.getString("performance"));
                errors = Integer.parseInt(response.getString("errors"));
                return new Performance(progress,performance,errors);
            }
        }
        catch (Exception ex){
            Log.e("Performance Parser", "parser", ex);
            return null;
        }

    }
}
