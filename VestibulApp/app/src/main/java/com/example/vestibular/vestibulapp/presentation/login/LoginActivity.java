package com.example.vestibular.vestibulapp.presentation.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.vestibular.vestibulapp.R;
import com.example.vestibular.vestibulapp.domain.entity.Session;
import com.example.vestibular.vestibulapp.presentation.base.BaseActivity;
import com.example.vestibular.vestibulapp.presentation.exercise.TrueFalseActivity;
import com.example.vestibular.vestibulapp.presentation.main.MainActivity;

public class LoginActivity extends BaseActivity implements Session.SessionInterface{

    EditText emailEditText;
    EditText passwordEditText;
    RelativeLayout progressBarRelativeLayout;
    TrueFalseActivity.ProgressBarFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressBarRelativeLayout = (RelativeLayout) findViewById(R.id.progress_bar_fragment);
        emailEditText =  (EditText) findViewById(R.id.login_email);
        passwordEditText = (EditText) findViewById(R.id.login_password);
    }
    public void showProgressBar(){
        fragment = new TrueFalseActivity.ProgressBarFragment();
        this.getFragmentManager().beginTransaction().add(R.id.progress_bar_fragment, fragment).commit();
        progressBarRelativeLayout.setVisibility(View.VISIBLE);
        progressBarRelativeLayout.setClickable(true);
        progressBarRelativeLayout.bringToFront();

    }
    public void hideProgressBar(){
        this.getFragmentManager().beginTransaction().remove(fragment).commit();
        progressBarRelativeLayout.setVisibility(View.GONE);
    }

    public void signInAction(View view){
        Session.getInstance().initSession(emailEditText.getText().toString(),passwordEditText.getText().toString(),LoginActivity.this);
        showProgressBar();
    }

    public void signUpAction(View view){
        Intent intent = new Intent(this,SignUpActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSessionStart() {
        hideProgressBar();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSessionRefuse() {
        hideProgressBar();
        Toast toast = Toast.makeText(this, "Dados inválidos", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onSessionError() {
        hideProgressBar();
        Toast toast = Toast.makeText(this, "Problema de conexão", Toast.LENGTH_SHORT);
        toast.show();
    }
}
