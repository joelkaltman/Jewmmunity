package com.bigbambu.jewmmunity.Utiles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

import com.bigbambu.jewmmunity.Clases.CEvento;
import com.bigbambu.jewmmunity.R;

import java.util.ArrayList;

/**
 * Created by Joel on 02-Aug-16.
 */
public class AdapterViewMisEventos extends BaseAdapter implements ListAdapter {

    private Context context;
    private ArrayList<CEvento> eventos;

    public AdapterViewMisEventos(Context context, ArrayList<CEvento> mobiles) {
        this.context = context;
        this.eventos = mobiles;
    }

    @Override
    public int getCount() {
        return eventos.size();
    }

    @Override
    public Object getItem(int position) {
        return eventos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = (View) inflater.inflate(R.layout.view_mis_eventos_entry, null);
        }
        return convertView;
    }
}