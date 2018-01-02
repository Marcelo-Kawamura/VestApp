package com.example.vestibular.vestibulapp.presentation.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vestibular.vestibulapp.R;
import com.example.vestibular.vestibulapp.domain.entity.Session;
import com.example.vestibular.vestibulapp.domain.entity.User;
import com.example.vestibular.vestibulapp.infraestruture.entity.request.UserRequest;
import com.example.vestibular.vestibulapp.presentation.base.BaseActivity;
import com.example.vestibular.vestibulapp.presentation.main.MainActivity;

public class SignUpActivity extends BaseActivity implements UserRequest.UsersRequestInterface {
    private EditText signInName;
    private EditText signInLastName;
    private EditText signInCpf;
    private EditText signInEmail;
    private EditText signInPassword;
    private EditText signInRepeatPassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signInName = findViewById(R.id.sign_in_name);
        signInLastName = findViewById(R.id.sign_in_last_name);
        signInCpf = findViewById(R.id.sign_in_cpf);
        signInEmail = findViewById(R.id.sign_in_email);
        signInPassword = findViewById(R.id.sign_in_password);
        signInRepeatPassword= findViewById(R.id.sign_in_repeat_password);

    }
    public void newUserAction(View view){
        UserRequest.createNewUser((UserRequest.UsersRequestInterface) SignUpActivity.this,signInName.getText().toString(),signInLastName.getText().toString(),signInCpf.getText().toString(),signInEmail.getText().toString(),signInPassword.getText().toString());
    }

    @Override
    public void onUsersRequestResponse(User user) {
        Session.getInstance().startSessionByActivity(user,this);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onUsersRequestError() {
        Toast toast = Toast.makeText(this, "Erro ao criar conta", Toast.LENGTH_SHORT);
        toast.show();
    }
}
