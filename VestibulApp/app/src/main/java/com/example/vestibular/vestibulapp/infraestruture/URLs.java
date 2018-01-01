package com.example.vestibular.vestibulapp.infraestruture;

import com.example.vestibular.vestibulapp.infraestruture.Constants;

/**
 * Created by marcelo on 31/12/17.
 */

public class URLs {
    static private final String path = "http://vestapp.000webhostapp.com/api/v1";
    static private final String SESSIONS_URL = "sessions";
    static private final String USERS_URL = "users";
    static private final String SUBJECTS_URL = "subjects";
    static private final String TOPICS_URL = "topics";

    static public String getForRequest(String value){
        switch (value){
            case Constants.SESSIONS_TAG:
                return path +"/"+ SESSIONS_URL;
            case Constants.USERS_TAG:
                return path +"/"+ USERS_URL;
            case Constants.SUBJECTS_TAG:
                return path +"/"+ SUBJECTS_URL;
            case Constants.TOPICS_TAG:
                return path +"/"+ TOPICS_URL;
            default:
                return "";
        }
    }
}

