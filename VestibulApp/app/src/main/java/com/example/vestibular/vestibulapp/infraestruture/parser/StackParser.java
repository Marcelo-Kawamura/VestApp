package com.example.vestibular.vestibulapp.infraestruture.parser;

import com.example.vestibular.vestibulapp.domain.entity.Stack;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by marcelo on 15/01/18.
 */

public class StackParser implements BaseParser{
    @Override
    public Object jsonToEntity(JSONObject response) {
        int student_id;
        int problem_id;
        int done;
        int correct;

        try{
            student_id = Integer.parseInt(response.getString("student_id"));
            problem_id = Integer.parseInt(response.getString("problem_id"));
            done = Integer.parseInt(response.getString("done"));
            correct = Integer.parseInt(response.getString("correct"));
            return new Stack(student_id, problem_id, done, correct) ;
            } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
