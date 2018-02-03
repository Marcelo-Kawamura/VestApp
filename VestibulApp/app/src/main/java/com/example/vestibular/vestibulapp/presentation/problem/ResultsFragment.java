package com.example.vestibular.vestibulapp.presentation.problem;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vestibular.vestibulapp.R;
import com.example.vestibular.vestibulapp.infraestruture.Constants;

public class ResultsFragment extends Fragment {


    public String topic_name;
    public String progress;
    public String grade;
    public String errors;
    public View view;




    int delay = 0;
    public ResultsFragment() {
        // Required empty public constructor
    }

    public static ResultsFragment newInstance(Bundle bundle){
        ResultsFragment resultsFragment=new ResultsFragment();
        resultsFragment.setArguments(bundle);
        return resultsFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            topic_name = getArguments().getString("topic_name");
            progress = getArguments().getString("progress");
            grade = getArguments().getString("grade");
            errors = getArguments().getString("errors");
        }
        catch (Exception ex){
            Log.e("ResultsFragment","onCreate",ex);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_results, container, false);
        setUpFragment();
        return view;
    }

    public void setUpFragment(){
        if(view==null){
            if(delay++>100){
                delay = 0;
                return;
            }
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    setUpFragment();
                }
            }, Constants.TIMEOUT_RESULTS_FRAGMENT_SETUP);
        }else{
            delay = 0;

            TextView txtView_topic_name = (TextView) view.findViewById(R.id.txtView_topic_name);
            TextView txtView_progress_value = (TextView) view.findViewById(R.id.txtView_progress_value);
            TextView txtView_grade = (TextView) view.findViewById(R.id.txtView_grade);
            TextView txtView_n_errors = (TextView) view.findViewById(R.id.txtView_n_errors);


            txtView_topic_name.setText(topic_name);
            txtView_progress_value.setText(progress);
            txtView_grade.setText(grade);
            txtView_n_errors.setText(errors);
        }

    }





}
