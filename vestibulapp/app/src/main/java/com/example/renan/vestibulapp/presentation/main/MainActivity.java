package com.example.renan.vestibulapp.presentation.main;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.renan.vestibulapp.Infraestruture.entity.Session;
import com.example.renan.vestibulapp.R;
import com.example.renan.vestibulapp.presentation.base.BaseActivity;
import com.example.renan.vestibulapp.presentation.login.LoginActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!Session.getInstance().isLogged(this)){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        Session.getInstance().finishSession(this);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }

}
