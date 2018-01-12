package com.example.vestibular.vestibulapp.presentation.problem;

import android.app.Fragment;

import com.example.vestibular.vestibulapp.domain.entity.Problem;

/**
 * Created by renan on 06/01/2018.
 */

public abstract class BaseProblemFragment extends Fragment {
    public abstract void setUpFragment(final Problem problem, final ProblemListener listener);
}
