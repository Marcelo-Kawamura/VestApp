package com.example.vestibular.vestibulapp.presentation.problem;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vestibular.vestibulapp.R;
import com.example.vestibular.vestibulapp.domain.entity.Problem;

import java.util.zip.Inflater;

/**
 * Created by renan on 05/01/2018.
 */

public class CheckFragment extends BaseProblemFragment{
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.check_fragment, container, false);
        return view;
    }

    @Override
    public void setUpFragment(Problem problem, ProblemListener listener) {




    }
}
