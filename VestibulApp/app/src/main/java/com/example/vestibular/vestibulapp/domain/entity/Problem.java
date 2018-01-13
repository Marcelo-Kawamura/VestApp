package com.example.vestibular.vestibulapp.domain.entity;

/**
 * Created by renan on 03/01/2018.
 */

public abstract class Problem {
    public int getId() {
        return id;
    }

    public int getTopic() {
        return topic;
    }

    private int id;
    private int topic;
    private int type;
    public Problem(int id,int topic, int type){
        this.type= type;
        this.id = id;
        this.topic = topic;
    }
    public int getType() {
        return type;
    }
}
