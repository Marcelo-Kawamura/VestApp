package com.example.vestibular.vestibulapp.domain.entity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.vestibular.vestibulapp.infraestruture.request.SessionRequest;

/**
 * Created by marcelo on 30/12/17.
 */

public class Session implements SessionRequest.OnResponseListener{
    private User user;
    private static volatile Session session = new Session();
    private SharedPreferences sharedPref;
    private SessionInterface sessionInterface;

    private Session(){
        this.user = null;
    }
    public static Session getInstance(){

        return session;
    }

    public void initSession(String email, String password, Activity activity){
        sessionInterface = (SessionInterface) activity;
        SessionRequest.getSessionByCredentials((SessionRequest.OnResponseListener) this, email, password);
        this.sessionInterface = sessionInterface;
        sharedPref = ((Context) activity).getSharedPreferences("preference_key",Context.MODE_PRIVATE);
    }
    public void finishSession(Activity activity){
        sharedPref = ((Context) activity).getSharedPreferences("preference_key",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = sharedPref.edit();
        editor.clear();
        editor.commit();
    }
    public void startSession(User user){
        SharedPreferences.Editor editor;
        editor = sharedPref.edit();
        editor.putString("user_name",user.getName());
        editor.putString("user_lastName",user.getLastName());
        editor.putString("user_email",user.getEmail());
        editor.putString("user_cpf",user.getCpf());
        editor.putString("user_token", user.getToken());
        editor.commit();
    }
    public void startSessionByActivity(User user,Context context){
        sharedPref = context.getSharedPreferences("preference_key",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = sharedPref.edit();
        editor.putString("user_name",user.getName());
        editor.putString("user_lastName",user.getLastName());
        editor.putString("user_email",user.getEmail());
        editor.putString("user_cpf",user.getCpf());
        editor.putString("user_token", user.getToken());
        editor.commit();
    }
    public User getUser(){
        return user;
    }

    public boolean isLogged(Context context){
        SharedPreferences sharedPref = context.getSharedPreferences("preference_key",Context.MODE_PRIVATE);
        String name = sharedPref.getString("user_name", "notLogged");
        String lastName = sharedPref.getString("user_lastName", "notLogged");
        String email = sharedPref.getString("user_email", "notLogged");
        String cpf = sharedPref.getString("user_cpf", "notLogged");
        String token = sharedPref.getString("user_token", "notLogged");
        if(     token.equals("notLogged")&&
                token.equals("notLogged")&&
                token.equals("notLogged")&&
                token.equals("notLogged")&&
                token.equals("notLogged")){
            return false;
        }
        this.user = new User(name,lastName,email,cpf,token);
        return true;
    }

    @Override
    public void onSessionsRequestResponse(User user) {
        if(user==null){
            sessionInterface.onSessionRefuse();
        }else{
            this.user = user;
            startSession(user);
            sessionInterface.onSessionStart();
        }
    }

    @Override
    public void onSessionsRequestError() {
        sessionInterface.onSessionError();
    }

    public interface SessionInterface{
        void onSessionStart();
        void onSessionRefuse();
        void onSessionError();
    }
}
