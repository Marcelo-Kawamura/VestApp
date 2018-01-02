package com.example.vestibular.vestibulapp.domain.entity;

/**
 * Created by marcelo on 31/12/17.
 */

public class Topic {
    private int topic_id;
    private String topic_name;
    private int subject_id;

    public Topic(int topic_id, String topic_name, int subject_id){
        this.topic_id = topic_id;
        this.topic_name = topic_name;
        this.subject_id = subject_id;
    }
    public int getTopic_id(){return this.topic_id;}
    public String getTopic_name(){return this.topic_name;}
    public int getSubject_id(){return this.subject_id;}

}


