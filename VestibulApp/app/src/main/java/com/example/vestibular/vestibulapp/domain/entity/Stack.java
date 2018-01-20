package com.example.vestibular.vestibulapp.domain.entity;

/**
 * Created by marcelo on 15/01/18.
 */

public class Stack {
    private int student_id;
    private int problem_id;
    private int game_id;
    private int done;
    public Stack(int student_id, int problem_id, int game_id, int done){
        this.student_id=student_id;
        this.problem_id=problem_id;
        this.game_id=game_id;
        this.done=done;
    }
    public int getStudent_id(){
        return student_id;
    }
    public int getGame_id() {return game_id;}

}
