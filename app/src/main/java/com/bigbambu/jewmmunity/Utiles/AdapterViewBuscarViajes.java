package com.bigbambu.jewmmunity.Utiles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

import com.bigbambu.jewmmunity.Clases.CViaje;
import com.bigbambu.jewmmunity.R;

import java.util.ArrayList;

/**
 * Created by Joel on 30-Jul-16.
 */
public class AdapterViewBuscarViajes extends BaseAdapter implements ListAdapter {

    private Context context;
    private ArrayList<CViaje> viajes;

    public AdapterViewBuscarViajes(Context context, ArrayList<CViaje> mobiles) {
        this.context = context;
        this.viajes = mobiles;
    }

    @Override
    public int getCount() {
        return viajes.size();
    }

    @Override
    public Object getItem(int position) {
        return viajes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = (View) inflater.inflate(R.layout.view_buscar_viajes_entry, null);
        }

        return convertView;
    }
}
