package com.example.sum.yef;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class customAdapter extends ArrayAdapter<String> {

    customAdapter(@NonNull Context context, String[] names) {
        super(context, R.layout.activity_main2,names);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inFlater = LayoutInflater.from(getContext());
        View customView = inFlater.inflate(R.layout.activity_main2,parent,false);

        String singleNameItem = getItem(position);
        TextView personName = (TextView) customView.findViewById(R.id.pName);
        TextView callNumber = (TextView) customView.findViewById(R.id.c);

        personName.setText(singleNameItem);
        callNumber.setText("8690415441");

        return customView;
    }
}
