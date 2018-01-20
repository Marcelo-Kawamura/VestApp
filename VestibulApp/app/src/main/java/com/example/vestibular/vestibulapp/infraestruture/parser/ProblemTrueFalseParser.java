package com.example.vestibular.vestibulapp.infraestruture.parser;

import android.util.Log;

import com.example.vestibular.vestibulapp.domain.entity.ProblemTrueFalse;

import org.json.JSONObject;

/**
 * Created by renan on 12/01/2018.
 */

public class ProblemTrueFalseParser implements BaseParser{

    @Override
    public Object jsonToEntity(JSONObject response) {
        int id;
        int topic;
        int type;
        int trueFalseProblemId;
        String trueStatement;
        String falseStatement;
        String trueComplementaryStatement;
        String falseComplementaryStatement;
        String solution;
        int sequence;
        int game_id;
        try {
            id = Integer.parseInt(response.getString("problem_id"));
            topic = Integer.parseInt(response.getString("topic_id"));
            type = Integer.parseInt(response.getString("problem_type_id"));
            trueFalseProblemId = Integer.parseInt(response.getString("true_false_problem_id"));
            sequence = Integer.parseInt(response.getString("sequency"));
            trueStatement = response.getString("true_statement");
            falseStatement = response.getString("false_statement");
            trueComplementaryStatement = response.getString("true_complementary_statement");
            falseComplementaryStatement = response.getString("false_complementary_statement");
            game_id = Integer.parseInt(response.getString("game_id"));
            solution = response.getString("solution");

            return new ProblemTrueFalse(id,topic,type,trueFalseProblemId,trueStatement,falseStatement,trueComplementaryStatement,falseComplementaryStatement,solution,sequence,game_id);

        }catch(Exception ex){
            Log.e("trueFalseParser", "JsontoEntity", ex);
            return null;
        }

    }
}
