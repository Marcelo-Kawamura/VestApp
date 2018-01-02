package com.example.vestibular.vestibulapp.presentation.subject;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vestibular.vestibulapp.R;
import com.example.vestibular.vestibulapp.domain.entity.Subject;

import java.util.ArrayList;

/**
 * Created by marcelo on 31/12/17.
 */

public class SubjectAdapter extends BaseAdapter{
    Context context;
    private ArrayList<Subject> subjectsArrayList;

    public SubjectAdapter(Context context, ArrayList<Subject> subjectsArrayList){
        this.context = context;
        this.subjectsArrayList = subjectsArrayList;
    }

    @Override
    public int getCount() {return subjectsArrayList.size();}

    @Override
    public Object getItem(int i) {return subjectsArrayList.get(i);}

    @Override
    public long getItemId(int i) {return i;}

    public Subject getItemAtPosition(int i){
        return subjectsArrayList.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.fragment_subjects_item_list ,viewGroup, false);
        }
        Subject currentSubject = (Subject) getItem(i);

        TextView txtView_Topic_TopicList = (TextView) view.findViewById(R.id.txtView_subject);
        txtView_Topic_TopicList.setText(currentSubject.getSubject_name());

        AppCompatImageView imageView = (AppCompatImageView) view.findViewById(R.id.subject_icon);
        Log.d("icon: ", currentSubject.getSubject_icon());
        int id = context.getResources().getIdentifier(currentSubject.getSubject_icon(),"drawable",context.getPackageName());
        Log.d("id: ", String.valueOf(id));
        imageView.setImageResource(id);

        return view;
    }

}
