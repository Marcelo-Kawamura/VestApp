package com.example.vestibular.vestibulapp.presentation.base;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.vestibular.vestibulapp.presentation.problem.ResultsFragment;

/**
 * Created by marcelo on 23/01/18.
 */

public class FragmentComunicator extends FragmentPagerAdapter{
    public FragmentComunicator(FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ResultsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 1;
    }
}
