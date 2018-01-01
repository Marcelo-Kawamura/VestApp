package com.example.vestibular.vestibulapp.presentation.menu;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.vestibular.vestibulapp.R;
import com.example.vestibular.vestibulapp.domain.Subjects;
import com.example.vestibular.vestibulapp.infraestruture.entity.adapter.SubjectAdapter;
import com.example.vestibular.vestibulapp.infraestruture.entity.request.SubjectsRequest;
import com.example.vestibular.vestibulapp.presentation.base.BaseActivity;
import com.example.vestibular.vestibulapp.presentation.base.ProgressBarFragment;

import java.util.ArrayList;
import java.util.List;

public class SubjectsActivity extends  BaseActivity implements SubjectsRequest.SubjectsInterface{
    List<Subjects> subjectsList;
    SubjectAdapter customAdapter;


    RelativeLayout progressBarRelativeLayout;
    ProgressBarFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);
        SubjectsRequest subjectsRequest = new SubjectsRequest(this);
        subjectsRequest.sendRequest();

        final View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        decorView.setOnSystemUiVisibilityChangeListener
                (new View.OnSystemUiVisibilityChangeListener() {
                    @Override
                    public void onSystemUiVisibilityChange(int visibility) {
                        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
                        decorView.setSystemUiVisibility(uiOptions);
                    }
                });


    }
    @Override
    public void onSubjectsResponse(ArrayList<Subjects> subjectsList) {
        this.subjectsList = subjectsList;
        customAdapter = new SubjectAdapter(this, subjectsList);
        ListView listViewSubjects = (ListView) findViewById(R.id.listView_Subject);
        listViewSubjects.setAdapter(customAdapter);

        listViewSubjects.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Subjects subjects = customAdapter.getItemAtPosition(i);
                Intent intent = new Intent(SubjectsActivity.this, TopicsActivity.class);
                intent.putExtra("subject_id", subjects.getSubject_id());
                intent.putExtra("subject_name", subjects.getSubject_name());
                startActivity(intent);
            }
        });
        Log.d("Subject name:", subjectsList.get(1).getSubject_name());

    }

}
