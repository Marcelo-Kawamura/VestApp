package com.example.vestibular.vestibulapp.presentation.topic;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vestibular.vestibulapp.R;
import com.example.vestibular.vestibulapp.domain.entity.Topic;

import java.util.ArrayList;

/**
 * Created by marcelo on 01/01/18.
 */

public class TopicAdapter extends BaseAdapter{
    Context context;
    private ArrayList<Topic> topicsArrayList;
    String subject_icon;

    public TopicAdapter(Context context, ArrayList<Topic> topicsArrayList, String subject_icon) {
        this.context=context;
        this.topicsArrayList=topicsArrayList;
        this.subject_icon = subject_icon;
    }

    @Override
    public int getCount() {
        return topicsArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return topicsArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public Topic getItemAtPosition(int position){
        return topicsArrayList.get(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
// inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.cell_topic_list_view, parent, false);
        }

        // get current item to be displayed
        Topic currentTopic = (Topic) getItem(position);

        // get the TextView for item name and item description
        TextView txtView_Topic_TopicList = (TextView) convertView.findViewById(R.id.txtView_Topic_TopicList);
        TextView txtView_performance_TopicList = (TextView) convertView.findViewById(R.id.txtView_performance_TopicList);

        //sets the text for item name and item description from the current item object
        txtView_Topic_TopicList.setText(currentTopic.getTopic_name());
        txtView_performance_TopicList.setText("100%");

        ImageView imageView = (ImageView) convertView.findViewById(R.id.subject_icon);
        int id = context.getResources().getIdentifier(subject_icon,"drawable",context.getPackageName());
        imageView.setImageResource(id);

        // returns the view for the current row
        return convertView;
    }
}
