package com.example.vestibular.vestibulapp.presentation.topic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

    public TopicAdapter(Context context, ArrayList<Topic> topicsArrayList) {
        this.context=context;
        this.topicsArrayList=topicsArrayList;
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
                    inflate(R.layout.fragment_topics_item_list, parent, false);
        }

        // get current item to be displayed
        Topic currentTopic = (Topic) getItem(position);

        // get the TextView for item name and item description
        TextView txtView_Topic_TopicList = (TextView) convertView.findViewById(R.id.txtView_Topic_TopicList);
        TextView txtView_performance_TopicList = (TextView) convertView.findViewById(R.id.txtView_performance_TopicList);

        //sets the text for item name and item description from the current item object
        txtView_Topic_TopicList.setText(currentTopic.getTopic_name());
        txtView_performance_TopicList.setText("100%");

        // returns the view for the current row
        return convertView;
    }
}
