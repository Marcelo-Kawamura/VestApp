package com.example.vestibular.vestibulapp.infraestruture;

/**
 * Created by marcelo on 31/12/17.
 */

public class URLs {
    static private final String path = "http://vestapp.000webhostapp.com/api/v1";
    static private final String SESSIONS_URL = "/sessions";
    static private final String USERS_URL = "/users";
    static private final String SUBJECTS_URL = "/subjects";
    static private final String TOPICS_URL = "/topics";
    static private final String TOPICS_BY_SUBJECT_URL = "/topics/subject/";
    static private final String STACK_PROBLEMS_URL = "/stackproblems/getnextfromstack/topic/";
    static private final String STACK_PROBLEMS_INITIALIZE_URL = "/stackproblems/initialize";
    static private final String PERFORMANCE_URL = "/performance";


    static public String getForRequest(String value){
        switch (value) {
            case Constants.SESSIONS_TAG:
                return path + SESSIONS_URL;
            case Constants.USERS_TAG:
                return path +  USERS_URL;
            case Constants.SUBJECTS_TAG:
                return path + SUBJECTS_URL;
            case Constants.TOPICS_TAG:
                return path + TOPICS_URL;
            case Constants.INITIALIZE_STACK_TAG:
                return path + STACK_PROBLEMS_INITIALIZE_URL;
            case Constants.PERFORMANCE_REQUEST_TAG:
                return path + PERFORMANCE_URL;
            default:
                return "";
        }
    }
    static public String getUrlWithValue(String value,String param){
        switch(value){
            case Constants.STACK_PROBLEM_REQUEST_TAG:
                return path + STACK_PROBLEMS_URL + param;
            case Constants.TOPICS_BY_SUBJECT_TAG:
                return path + TOPICS_BY_SUBJECT_URL + param;


            default:
                return "";
        }
    }
}

