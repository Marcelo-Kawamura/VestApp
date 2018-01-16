package com.example.vestibular.vestibulapp.presentation.subject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.vestibular.vestibulapp.R;
import com.example.vestibular.vestibulapp.domain.entity.Subject;
import com.example.vestibular.vestibulapp.infraestruture.request.SubjectsRequest;
import com.example.vestibular.vestibulapp.presentation.base.BaseActivity;
import com.example.vestibular.vestibulapp.presentation.topic.TopicsActivity;

import java.util.ArrayList;
import java.util.List;

public class SubjectsActivity extends  BaseActivity implements SubjectsRequest.SubjectsInterface{
    List<Subject> subjectsList;
    SubjectAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);
        SubjectsRequest subjectsRequest = new SubjectsRequest(this);
        subjectsRequest.sendRequest();
    }
    @Override
    public void onSubjectsResponse(ArrayList<Subject> subjectsList) {
        this.subjectsList = subjectsList;
        customAdapter = new SubjectAdapter(this, subjectsList);
        ListView listViewSubjects = (ListView) findViewById(R.id.listView_Subject);
        listViewSubjects.setAdapter(customAdapter);


        listViewSubjects.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Subject subject = customAdapter.getItemAtPosition(i);
                Intent intent = new Intent(SubjectsActivity.this, TopicsActivity.class);
                intent.putExtra("subject_id", subject.getSubject_id());
                intent.putExtra("subject_name", subject.getSubject_name());
                intent.putExtra("subject_icon", subject.getSubject_icon());
                startActivity(intent);
            }
        });
        Log.d("Subject name:", subjectsList.get(1).getSubject_name());

    }

}
