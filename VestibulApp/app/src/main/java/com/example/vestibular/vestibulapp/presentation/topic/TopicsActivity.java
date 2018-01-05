package com.example.vestibular.vestibulapp.presentation.topic;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.vestibular.vestibulapp.R;
import com.example.vestibular.vestibulapp.domain.entity.Topic;
import com.example.vestibular.vestibulapp.infraestruture.request.TopicsRequest;
import com.example.vestibular.vestibulapp.presentation.base.BaseActivity;
import com.example.vestibular.vestibulapp.presentation.problem.ProblemActivity;

import java.util.ArrayList;
import java.util.List;

public class TopicsActivity extends BaseActivity implements TopicsRequest.TopicsInterface {

    List<Topic> topicsArrayList;
    TopicAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);

        Intent intent = getIntent();
        int subjectID = intent.getIntExtra("subject_id",0);
        String subject_name = intent.getStringExtra("subject_name");
        Log.d("subject_name", subject_name);
        TextView txtViewSubject = (TextView) findViewById(R.id.txtViewSubject);
        TopicsRequest topicsRequest = new TopicsRequest(this);
        topicsRequest.sendRequest(subject_name);

    }

    @Override
    public void onTopicsResponse(ArrayList<Topic> topicsArrayList)  {
        this.topicsArrayList = topicsArrayList;
        customAdapter =  new TopicAdapter(this,topicsArrayList);
        ListView listViewTopics = (ListView) findViewById(R.id.listViewTopics);
        listViewTopics.setAdapter(customAdapter);
        listViewTopics.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Topic topic = customAdapter.getItemAtPosition(i);
                Intent intent = new Intent(TopicsActivity.this, ProblemActivity.class);
                intent.putExtra("topic_id", topic.getTopic_id());
                intent.putExtra("subject_id", topic.getSubject_id());
                startActivity(intent);

            }
        });
    }



}
