package com.example.vestibular.vestibulapp.presentation.results;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vestibular.vestibulapp.R;
import com.example.vestibular.vestibulapp.domain.entity.Performance;
import com.example.vestibular.vestibulapp.infraestruture.request.PerformanceRequest;
import com.example.vestibular.vestibulapp.presentation.base.BaseActivity;
import com.example.vestibular.vestibulapp.presentation.base.FragmentComunicator;
import com.example.vestibular.vestibulapp.presentation.problem.ResultsFragment;

public class ResultsActivity extends BaseActivity implements PerformanceRequest.OnResponseListener{
    private int problem_type_id;
    private int topic_id;
    private String topic_name;
    private int subject_id;
    private String subject_name;
    private int game_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();
        problem_type_id = intent.getIntExtra("problem_type_id",1);
        topic_id = intent.getIntExtra("topic_id",0);
        topic_name=intent.getStringExtra("topic_name");
        subject_id=intent.getIntExtra("subject_id",0);
        subject_name = intent.getStringExtra("subject_name");
        game_id = intent.getIntExtra("game_id",0);


        PerformanceRequest.getPerformance(this,problem_type_id,topic_id,game_id);


    }

    @Override
    public void onPerformanceRequestResponse(Performance performance) {

        Bundle bundle = new Bundle();
        bundle.putString("topic_name",topic_name);
        bundle.putString("progress",String.valueOf(performance.getProgress()) );
        bundle.putString("performance",String.valueOf(performance.getGrade()));
        bundle.putString("errors", String.valueOf(performance.getErrors()));

        ResultsFragment resultsFragment = new ResultsFragment();
        resultsFragment.setArguments(bundle);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager_results);
        FragmentComunicator comunicator = new FragmentComunicator(getSupportFragmentManager());
        viewPager.setAdapter(comunicator);
        viewPager.setCurrentItem(0);
    }

    @Override
    public void onPerformanceRequestError() {

    }

    @Override
    public void onPerformanceRequestEmpty() {

    }
}
