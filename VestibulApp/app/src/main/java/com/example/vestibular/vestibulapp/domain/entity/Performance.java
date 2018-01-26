package com.example.vestibular.vestibulapp.domain.entity;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by marcelo on 23/01/18.
 */

public class Performance {
    private float progress;
    private float performance;
    private int errors;

    public Performance(float progress, float performance, int errors){
        this.progress = progress;
        this.performance=performance;
        this.errors=errors;
    }

    public float getGrade() {
        return performance*100;
    }

    public float getProgress(){
        return progress*100;
    }


    public int getErrors(){
        return errors;
    }


}
