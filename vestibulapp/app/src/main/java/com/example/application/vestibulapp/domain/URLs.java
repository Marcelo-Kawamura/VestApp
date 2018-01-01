package com.example.renan.vestibulapp.domain;

/**
 * Created by renan on 29/12/2017.
 */

public class URLs {

    static private final String path = "http://vestapp.000webhostapp.com/api/v1";
    static private final String SESSIONS_URL = "sessions";
    static private final String USERS_URL = "users";

    static public String getForRequest(String value){
        switch (value){
            case Constants.SESSIONS_TAG:
                return path +"/"+ SESSIONS_URL;
            case Constants.USERS_TAG:
                return path +"/"+ USERS_URL;
            default:
                return "";
        }
    }
}
