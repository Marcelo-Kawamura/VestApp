package com.example.vestibular.vestibulapp.presentation.problem;

import android.app.Fragment;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.vestibular.vestibulapp.R;
import com.example.vestibular.vestibulapp.domain.entity.Problem;
import com.example.vestibular.vestibulapp.domain.entity.ProblemTrueFalse;
import com.example.vestibular.vestibulapp.presentation.base.BaseActivity;

import java.util.ArrayList;

/**
 * Created by renan on 02/01/2018.
 */

public class ProblemActivity extends BaseActivity {
    private TrueFalseFragment trueFalseFragment;
    private Fragment activeFragment;

    // mock variable
    private ArrayList<Problem> problems;
    int i=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem);
        activeFragment = new Fragment();

        //Mock problem
        problems = new ArrayList();
        problems.add(new ProblemTrueFalse(1,"conhecimentos gerais","O céu é azul",0,true));
        problems.add(new ProblemTrueFalse(1,"conhecimentos gerais","O céu é preto",0,false));
        problems.add(new ProblemTrueFalse(1,"conhecimentos gerais","O porco tem rabo",0,true));
        problems.add(new ProblemTrueFalse(1,"conhecimentos gerais","O macaco é feito de maça",0,false));
        problems.add(new ProblemTrueFalse(1,"conhecimentos gerais","2 + 2 = 4 ",0,true));
        problems.add(new ProblemTrueFalse(1,"conhecimentos gerais","Capital do Brasil é Rio de Janeiro",0,false));
        nextProblem();
    }
    public void nextProblem(){
        if(problems.size()>i+1){
            i++;
        }else{
            i=0;
        }
        Problem problem = problems.get(i);
        setOneProblemFragment(problem, new ProblemListener() {
            @Override
            public void onAnswerCorrect() {
                Toast.makeText(getApplicationContext(), "Parabens Você acertou", Toast.LENGTH_SHORT).show();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        nextProblem();
                    }
                }, 2000);
            }

            @Override
            public void onAnswerWrong() {
                Toast.makeText(getApplicationContext(), "Você Errou", Toast.LENGTH_SHORT).show();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        nextProblem();
                    }
                }, 2000);
            }
        });
    }

    public void setOneProblemFragment(Problem problem,ProblemListener listener){
        switch (problem.getType()){
            case 0:
                trueFalseFragment = new TrueFalseFragment();
                trueFalseFragment.setUpFragment((ProblemTrueFalse)problem, listener);
                this.getFragmentManager().beginTransaction().remove(activeFragment).commit();
                this.getFragmentManager().beginTransaction().add(R.id.problem_true_false_fragment, trueFalseFragment).commit();
                activeFragment = trueFalseFragment;
                break;
            default:
                break;
        }
    }

}
