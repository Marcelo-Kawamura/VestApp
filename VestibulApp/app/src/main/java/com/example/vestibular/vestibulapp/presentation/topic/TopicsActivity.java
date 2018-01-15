package com.example.vestibular.vestibulapp.presentation.topic;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.vestibular.vestibulapp.R;
import com.example.vestibular.vestibulapp.domain.entity.Problem;
import com.example.vestibular.vestibulapp.domain.entity.Session;
import com.example.vestibular.vestibulapp.domain.entity.Topic;
import com.example.vestibular.vestibulapp.infraestruture.request.InitializeStackRequest;
import com.example.vestibular.vestibulapp.infraestruture.request.TopicsRequest;
import com.example.vestibular.vestibulapp.presentation.base.BaseActivity;
import com.example.vestibular.vestibulapp.presentation.problem.ProblemActivity;

import java.util.ArrayList;
import java.util.List;

public class TopicsActivity extends BaseActivity implements TopicsRequest.TopicsInterface,
        InitializeStackRequest.OnResponseListener{

    List<Topic> topicsArrayList;
    TopicAdapter customAdapter;
    String subject_icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);

        Intent intent = getIntent();
        int subject_id = intent.getIntExtra("subject_id",0);
        String subject_name = intent.getStringExtra("subject_name");
        subject_icon = intent.getStringExtra("subject_icon");

        Log.d("subject_name", subject_name);
        TextView txtViewSubject = (TextView) findViewById(R.id.txtViewTopics);
        TopicsRequest topicsRequest = new TopicsRequest(this);
        topicsRequest.sendRequest(subject_id);

    }

    @Override
    public void onTopicsResponse(ArrayList<Topic> topicsArrayList)  {
        this.topicsArrayList = topicsArrayList;
        customAdapter =  new TopicAdapter(this,topicsArrayList, subject_icon);
        ListView listViewTopics = (ListView) findViewById(R.id.listViewTopics);
        listViewTopics.setAdapter(customAdapter);
        listViewTopics.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Topic topic = customAdapter.getItemAtPosition(i);
                Intent intent = new Intent(TopicsActivity.this, ProblemActivity.class);
                intent.putExtra("topic_id", topic.getTopic_id());
                intent.putExtra("subject_id", topic.getSubject_id());
                int student_id = Session.getInstance().getUser().getId();
                InitializeStackRequest.initializeStack(TopicsActivity.this,student_id,1,topic.getTopic_id());
                startActivity(intent);

            }
        });
    }


    @Override
    public void onInitializeStackResponse(Problem problem) {
    }

    @Override
    public void onInitializeStackRequestError() {
    }
}
