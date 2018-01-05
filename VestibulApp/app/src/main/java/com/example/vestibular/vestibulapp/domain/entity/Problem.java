package com.example.vestibular.vestibulapp.domain.entity;

/**
 * Created by renan on 03/01/2018.
 */

public abstract class Problem {
    private int id;
    private String topic;
    private int type;
    public Problem(int id,String topic, int type){
        this.type= type;
        this.id = id;
        this.topic = topic;
    }
    public int getType() {
        return type;
    }
}
