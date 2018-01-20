package com.example.vestibular.vestibulapp.domain.entity;

/**
 * Created by renan on 03/01/2018.
 */

public abstract class Problem {


    private int problem_id;
    private int topic_id;
    private int problem_type_id;

    public Problem(int id,int topic, int type){
        this.problem_type_id= type;
        this.problem_id = id;
        this.topic_id = topic;
    }
    public int getType() { return problem_type_id;}
    public int getId() {
        return problem_id;
    }
    public int getTopic() {
        return topic_id;
    }
}
