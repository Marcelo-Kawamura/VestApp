package com.example.vestibular.vestibulapp.domain.entity;

/**
 * Created by marcelo on 15/01/18.
 */

public  class Stack {
    private int student_id;
    private int problem_id;
    private int done;
    private int correct;
    public Stack(int student_id, int problem_id, int done, int correct){
        this.student_id=student_id;
        this.problem_id=problem_id;
        this.done=done;
        this.correct=correct;
    }
    public int getStudent_id(){
        return student_id;
    }

}
