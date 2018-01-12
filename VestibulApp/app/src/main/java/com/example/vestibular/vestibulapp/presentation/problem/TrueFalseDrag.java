package com.example.vestibular.vestibulapp.presentation.problem;

import android.graphics.Color;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;

/**
 * Created by renan on 04/01/2018.
 */

class TrueFalseDrag implements View.OnDragListener {
    boolean answer;
    ProblemAnswerListener listener;
    public TrueFalseDrag(boolean answer,ProblemAnswerListener listener){
    this.answer = answer;
    this.listener = listener;
    }
    @Override
    public boolean onDrag(View v, DragEvent event) {
        int action = event.getAction();
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                Log.d("ProblemActivity","drag_start");
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                v.setBackgroundColor(Color.YELLOW);
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                v.setBackgroundColor(Color.parseColor("#00dddddd"));
                break;
            case DragEvent.ACTION_DROP:
                View view = (View) event.getLocalState();
                view.setVisibility(View.GONE);
                if(answer){
                    v.setBackgroundColor(Color.GREEN);
                    listener.onAnswerCorrect();
                } else{
                    v.setBackgroundColor(Color.RED);
                    listener.onAnswerWrong();
                }
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                break;
            default:
                break;
        }
        return true;
    }
    public interface ProblemAnswerListener{
        public void onAnswerCorrect();
        public void onAnswerWrong();
    }
}

