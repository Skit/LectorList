package com.example.lectorlist.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.List;

public class SpinnerAdapter extends BaseAdapter {
    private final List<String> lectors;

    public SpinnerAdapter(@NonNull List<String> l) {
        lectors = l;
    }

    @Override
    public int getCount() {
        return lectors.size();
    }

    @Override
    public String getItem(int position) {
        return lectors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        ViewHolder viewHolder = new ViewHolder(convertView);
        viewHolder.lectorName.setText(getItem(position));

        return convertView;
    }


    private class ViewHolder {
        private final TextView lectorName;

        private ViewHolder(View view) {
            lectorName = view.findViewById(android.R.id.text1);
        }
    }
}
