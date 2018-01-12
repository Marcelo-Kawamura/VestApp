package com.example.vestibular.vestibulapp.presentation.problem;

import android.app.Fragment;
import android.content.ClipData;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vestibular.vestibulapp.R;
import com.example.vestibular.vestibulapp.domain.entity.Problem;
import com.example.vestibular.vestibulapp.domain.entity.ProblemTrueFalse;

/**
 * Created by renan on 02/01/2018.
 */

public class TrueFalseFragment extends BaseProblemFragment{
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.problem_true_false_fragment, container, false);
        return view;
    }
    @Override
    public void setUpFragment(Problem problem,final ProblemListener listener) {
        final ProblemTrueFalse problemTrueFalse = (ProblemTrueFalse) problem;

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(view==null) {
                    setUpFragment(problemTrueFalse,listener);
                }else{
                    ((TextView) view.findViewById(R.id.true_false_description)).setText(problemTrueFalse.getDescription());
                    view.findViewById(R.id.drag_true_false).setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ClipData data = ClipData.newPlainText("simple_text","text");
                            View.DragShadowBuilder sb = new View.DragShadowBuilder(view);
                            view.startDrag(data,sb,view,0);
                            return true;
                        }
                    });
                    TrueFalseDrag.ProblemAnswerListener trueFalseListener = new TrueFalseDrag.ProblemAnswerListener(){

                        @Override
                        public void onAnswerCorrect() {
                            listener.onAnswerCorrect();
                        }

                        @Override
                        public void onAnswerWrong() {
                            listener.onAnswerWrong();
                        }
                    };
                    view.findViewById(R.id.container_true).setOnDragListener(new TrueFalseDrag(problemTrueFalse.isAnswerKey(),trueFalseListener));
                    view.findViewById(R.id.container_false).setOnDragListener(new TrueFalseDrag(!problemTrueFalse.isAnswerKey(),trueFalseListener));
                }
            }
        }, 100);
    }
}
