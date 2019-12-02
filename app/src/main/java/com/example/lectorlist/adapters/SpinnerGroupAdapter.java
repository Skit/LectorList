package com.example.lectorlist.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lectorlist.models.Group;

public class SpinnerGroupAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return Group.values().length;
    }

    @Override
    public Group getItem(int position) {
        return Group.values()[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(android.R.layout.simple_list_item_1, parent, false);
        GroupHolder holder = new GroupHolder(convertView);
        int titleResourceId = getItem(position).getStringResourceId();
        holder.label.setText(titleResourceId);
        return convertView;
    }


    private static class GroupHolder {
        private final TextView label;

        private GroupHolder(View view) {
            label = view.findViewById(android.R.id.text1);
        }
    }
}
