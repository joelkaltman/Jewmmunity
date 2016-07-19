package com.bigbambu.jewmmunity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Joel on 17-Jul-16.
 */
public class MyAdapter extends BaseAdapter implements ListAdapter {

    private Context context;
    private ArrayList<CPublication> publications;

    public MyAdapter(Context context, ArrayList<CPublication> mobiles) {
        this.context = context;
        this.publications = mobiles;
    }

    @Override
    public int getCount() {
        return publications.size();
    }

    @Override
    public Object getItem(int position) {
        return publications.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = (View) inflater.inflate(R.layout.list_entry_layout, null);
        }

        TextView name = (TextView)convertView.findViewById(R.id.list_entry_title);
        TextView summary=(TextView)convertView.findViewById(R.id.list_entry_summary);
        TextView user=(TextView)convertView.findViewById(R.id.list_entry_user);


        name.setText(publications.get(position).getName());
        summary.setText(publications.get(position).getSummary());
        user.setText(publications.get(position).getUser());

        return convertView;
    }
}
