package com.example.vestibular.vestibulapp.domain.entity;

import java.util.ArrayList;

/**
 * Created by renan on 05/01/2018.
 */

public class ProblemCheck extends Problem{
    private int idCheck;
    private String description;
    private ArrayList<Item> items;
    public ProblemCheck(int id, String topic, int type,int idCheck,String description,ArrayList items) {
        super(id, topic, type);
        this.idCheck = idCheck;
        this.description = description;
        this.items = items;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public String getDescription() {
        return description;
    }

    public class Item{
        private int id;
        private String description;
        private boolean answerKey;
        public Item(int id,String description, boolean answerKey){
            this.id = id;
            this.description = description;
            this.answerKey = answerKey;
        }

        public String getDescription() {
            return description;
        }

        public boolean isAnswerKey() {
            return answerKey;
        }
    }
}
