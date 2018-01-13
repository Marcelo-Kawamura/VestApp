package com.example.vestibular.vestibulapp.infraestruture.parser;

import com.example.vestibular.vestibulapp.domain.entity.Problem;

import org.json.JSONObject;

/**
 * Created by renan on 12/01/2018.
 */

public class ProblemParser implements BaseParser {
    @Override
    public Object jsonToEntity(JSONObject response) {
        try{
        if(response.getInt("status")==0){
            return null;
        }else{
            response = response.getJSONObject("data");
            if(response.has("problem_type_id")){

                    switch(response.getInt("problem_type_id")){
                        case 1:
                            ProblemTrueFalseParser problemTrueFalseParser = new ProblemTrueFalseParser();
                            return problemTrueFalseParser.jsonToEntity(response);
                        default:
                            return null;
                    }
            }
            return null;
        }
        }catch(Exception ex){
            return null;
        }
    }
}
