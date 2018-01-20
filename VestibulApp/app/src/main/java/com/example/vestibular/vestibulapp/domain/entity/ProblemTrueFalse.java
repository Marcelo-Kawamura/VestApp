package com.example.vestibular.vestibulapp.domain.entity;

/**
 * Created by renan on 03/01/2018.
 */

public class ProblemTrueFalse extends Problem {
    private int problemTrueFalseId;
    private String description;
    private String solution;
    private int sequence;
    private int game_id;
    private boolean answerKey;
    public ProblemTrueFalse(int id,
                            int topic,
                            int type,
                            int trueFalseProblemId,
                            String trueStatement,
                            String falseStatement,
                            String trueComplementaryStatement,
                            String falseComplementaryStatement,
                            String solution,
                            int sequence,
                            int game_id){
        super(id,topic,type);
        this.problemTrueFalseId = trueFalseProblemId;
        this.solution = solution;
        this.sequence = sequence;
        this.game_id = game_id;
        int descriptionChose = (int)(Math.random()*4);

        switch (descriptionChose){
            case 0:
                description = trueStatement;
                answerKey = true;
                break;
            case 1:
                description = falseStatement;
                answerKey = false;
                break;
            case 2:
                description = trueComplementaryStatement;
                answerKey = true;
                break;
            case 3:
                description = falseComplementaryStatement;
                answerKey = false;
                break;
        }

    }

    public boolean isAnswerKey() {
        return answerKey;
    }
    public String getDescription() {
        return description;
    }

    public int getProblemTrueFalseId() {
        return problemTrueFalseId;
    }

    public String getSolution() {
        return solution;
    }

    public int getSequence() {
        return sequence;
    }

    public int getGameID(){return game_id;}
}
