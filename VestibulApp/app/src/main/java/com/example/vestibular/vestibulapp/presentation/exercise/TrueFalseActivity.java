package com.example.vestibular.vestibulapp.presentation.exercise;

import android.app.Fragment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.vestibular.vestibulapp.R;
import com.example.vestibular.vestibulapp.infraestruture.Constants;

public class TrueFalseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_false);
    }

    /**
     * Created by marcelo on 31/12/17.
     */

    public static class ProgressBarFragment extends Fragment {

        RelativeLayout progressBarRelativeLayout;
        ProgressBar progressBar;
        TextView loadingTextView;
        View view;
        int delay = 0;
        int iteration = 0;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            view = inflater.inflate(R.layout.fragment_progress_bar, container, false);
            setUpProgressBar();
            return view;
        }

        public void setUpProgressBar(){
            if(view==null){
                if(delay++>100){
                    delay = 0;
                    return;
                }
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setUpProgressBar();
                    }
                }, Constants.TIMEOUT_PROGRESS_BAR_SETUP/100);
            }
            delay = 0;
            progressBarRelativeLayout = (RelativeLayout) view.findViewById(R.id.progress_bar_layout);
            progressBar = (ProgressBar)view.findViewById(R.id.indeterminate_bar);
            loadingTextView = (TextView) view.findViewById(R.id.progress_bar_text_view);
            loadingTextView.bringToFront();
            progressBar.bringToFront();
            progressBarRelativeLayout.bringToFront();
            startProgressBar();
        }
        public void loadingAnimation(){
            if(iteration<0)return;
            iteration++;
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(iteration>10){
                        loadingTextView.setText("Loading");
                        iteration = 0;
                    }
                    loadingTextView.setText(loadingTextView.getText()+"  .");
                    loadingAnimation();
                }
            }, 800);

        }
        public void startProgressBar(){
            progressBarRelativeLayout.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.VISIBLE);
            loadingTextView.setVisibility(View.VISIBLE);
            loadingAnimation();
        }
        public void stopProgressBar(){
            iteration = -10;
            progressBarRelativeLayout.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
            loadingTextView.setVisibility(View.GONE);
        }

    }
}
