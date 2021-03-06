package com.example.vestibular.vestibulapp.presentation.problem;

import android.app.Fragment;
import android.arch.lifecycle.ReportFragment;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.vestibular.vestibulapp.R;
import com.example.vestibular.vestibulapp.domain.entity.Problem;
import com.example.vestibular.vestibulapp.domain.entity.ProblemTrueFalse;
import com.example.vestibular.vestibulapp.domain.entity.User;
import com.example.vestibular.vestibulapp.infraestruture.Constants;
import com.example.vestibular.vestibulapp.infraestruture.request.InitializeStackRequest;
import com.example.vestibular.vestibulapp.infraestruture.request.ProblemRequest;
import com.example.vestibular.vestibulapp.presentation.base.BaseActivity;
import com.example.vestibular.vestibulapp.presentation.results.ResultsActivity;
import com.example.vestibular.vestibulapp.presentation.topic.TopicsActivity;

import java.util.ArrayList;

/**
 * Created by renan on 02/01/2018.
 */

public class ProblemActivity extends BaseActivity implements ProblemRequest.OnResponseListener {
    private TrueFalseFragment trueFalseFragment;

    private Fragment activeFragment;

    private int topic_id;
    private String topic_name;
    private int subject_id;
    private String subject_name;
    private int game_id;

    private int lastProblemId;
    private int lastAnswer;

    // mock variable
    private Problem currentProblem;
    int i=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem);
        Intent intent = getIntent();

        topic_id = intent.getIntExtra("topic_id",0);
        topic_name=intent.getStringExtra("topic_name");
        subject_id=intent.getIntExtra("subject_id",0);
        subject_name = intent.getStringExtra("subject_name");
        game_id = intent.getIntExtra("game_id",0);


        activeFragment = new Fragment();

        lastProblemId = -1;
        lastAnswer = -1;

        //first problem
        ProblemRequest.getProblemFromStack(this,lastProblemId,lastAnswer,topic_id, game_id);

    }
    public void showProblemForUser(){

        setOneProblemFragment(currentProblem, new ProblemListener() {
            @Override
            public void onAnswerCorrect() {
                Toast.makeText(getApplicationContext(), "Parabéns Você acertou", Toast.LENGTH_SHORT).show();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        lastAnswer = 1;
                        requestNextProblem();
                    }
                }, Constants.DELAY_NEXT_QUESTION);
            }

            @Override
            public void onAnswerWrong() {
                Toast.makeText(getApplicationContext(), "Você Errou", Toast.LENGTH_SHORT).show();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        lastAnswer = 0;
                        requestNextProblem();
                    }
                }, Constants.DELAY_NEXT_QUESTION);
            }
        });
    }
    public void requestNextProblem(){
        lastProblemId = currentProblem.getId();
        ProblemRequest.getProblemFromStack(this,lastProblemId,lastAnswer,topic_id,game_id);
    }

    public void setOneProblemFragment(Problem problem,ProblemListener listener){
        switch (problem.getType()){
            case 1:
                trueFalseFragment = new TrueFalseFragment();
                trueFalseFragment.setUpFragment((ProblemTrueFalse)problem, listener);
                this.getFragmentManager().beginTransaction().replace(R.id.problem_true_false_fragment, trueFalseFragment).commit();
                activeFragment = trueFalseFragment;
                break;
            default:
                break;
        }
    }


    @Override
    public void onProblemsRequestResponse(Problem problem) {
        currentProblem = problem;
        showProblemForUser();
    }

    @Override
    public void onProblemsRequestError() {
    }

    @Override
    public void onProblemsRequestEmpty() {
        Intent intent = new Intent(ProblemActivity.this, ResultsActivity.class);
        intent.putExtra("problem_type_id", currentProblem.getType());
        intent.putExtra("topic_id", topic_id);
        intent.putExtra("topic_name",topic_name);
        intent.putExtra("subject_id",subject_id);
        intent.putExtra("subject_name", subject_name);
        intent.putExtra("game_id", game_id);
        startActivity(intent);
    }

}
