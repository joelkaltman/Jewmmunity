package com.bigbambu.jewmmunity.Utiles;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bigbambu.jewmmunity.Clases.CPublicacion;
import com.bigbambu.jewmmunity.R;

import java.util.ArrayList;

/**
 * Created by Joel on 17-Jul-16.
 */
public class MyAdapter extends BaseAdapter implements ListAdapter {

    private Context context;
    private ArrayList<CPublicacion> publications;

    public MyAdapter(Context context, ArrayList<CPublicacion> mobiles) {
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
        ImageView imagen = (ImageView)convertView.findViewById(R.id.list_entry_image);
        TextView date = (TextView)convertView.findViewById(R.id.list_entry_date);


        name.setText(publications.get(position).getTitulo());
        summary.setText(publications.get(position).getDescripcion());
        user.setText(publications.get(position).getUsuario().getNombre());
        date.setText(DateFormat.format("dd/mm/yyyy", publications.get(position).getFecha()).toString());
        imagen.setBackground(publications.get(position).getImagen());

        return convertView;
    }
}
