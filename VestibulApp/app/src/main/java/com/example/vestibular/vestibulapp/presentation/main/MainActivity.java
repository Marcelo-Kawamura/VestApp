package com.example.vestibular.vestibulapp.presentation.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.vestibular.vestibulapp.R;
import com.example.vestibular.vestibulapp.domain.entity.ProblemTrueFalse;
import com.example.vestibular.vestibulapp.domain.entity.Session;
import com.example.vestibular.vestibulapp.presentation.base.BaseActivity;
import com.example.vestibular.vestibulapp.presentation.login.LoginActivity;
import com.example.vestibular.vestibulapp.presentation.problem.ProblemActivity;
import com.example.vestibular.vestibulapp.presentation.subject.SubjectsActivity;

public class MainActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View decorView = getWindow().getDecorView();

        if (!Session.getInstance().isLogged(this)){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

    }

    public void subjectOpenAction(View view) {
        Intent intent = new Intent(MainActivity.this, SubjectsActivity.class);
        startActivity(intent);
    }
}
