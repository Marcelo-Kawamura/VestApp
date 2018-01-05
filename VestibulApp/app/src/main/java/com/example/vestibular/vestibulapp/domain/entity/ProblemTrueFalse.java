package com.example.vestibular.vestibulapp.domain.entity;

/**
 * Created by renan on 03/01/2018.
 */

public class ProblemTrueFalse extends Problem {
    private String description;
    private boolean answerKey;
    public ProblemTrueFalse(int id,String topic,String description,int type ,boolean answerKey){
        super(id,topic,type);
        this.description = description;
        this.answerKey = answerKey;
    }

    public boolean isAnswerKey() {
        return answerKey;
    }

    public String getDescription() {
        return description;
    }
}
