package com.example.vestibular.vestibulapp.infraestruture.parser;

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
            solution = response.getString("solution");
            return new ProblemTrueFalse(id,topic,type,trueFalseProblemId,trueStatement,falseStatement,trueComplementaryStatement,falseComplementaryStatement,solution,sequence);

        }catch(Exception ex){}
        return null;
    }
}
