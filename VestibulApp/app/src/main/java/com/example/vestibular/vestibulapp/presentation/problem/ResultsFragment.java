package com.example.vestibular.vestibulapp.presentation.problem;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vestibular.vestibulapp.R;

public class ResultsFragment extends Fragment {


    public String topic_name;
    public String progress;
    public String grade;
    public int errors;



    public ResultsFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = this.getArguments();
        topic_name=bundle.getString("topic_name");




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        TextView topic_name_txtView = (TextView) container.findViewById(R.id.txtView_topic_name);
        topic_name_txtView.setText(topic_name);
        return inflater.inflate(R.layout.fragment_results, container, false);
    }


}
