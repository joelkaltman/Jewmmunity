package com.bigbambu.jewmmunity.Utiles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

import com.bigbambu.jewmmunity.Clases.CGrupo;
import com.bigbambu.jewmmunity.R;

import java.util.ArrayList;

/**
 * Created by Joel on 04-Aug-16.
 */
public class AdapterViewBuscarGrupos extends BaseAdapter implements ListAdapter {

    private Context context;
    private ArrayList<CGrupo> grupos;

    public AdapterViewBuscarGrupos(Context context, ArrayList<CGrupo> mobiles) {
        this.context = context;
        this.grupos = mobiles;
    }

    @Override
    public int getCount() {
        return grupos.size();
    }

    @Override
    public Object getItem(int position) {
        return grupos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = (View) inflater.inflate(R.layout.view_buscar_grupo_entry, null);
        }

        return convertView;
    }
}
