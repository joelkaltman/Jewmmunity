package com.bigbambu.jewmmunity.Utiles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bigbambu.jewmmunity.Clases.CComunidad;
import com.bigbambu.jewmmunity.R;

import java.util.ArrayList;

/**
 * Created by Joel on 30-Jul-16.
 */
public class AdapterViewMisComunidades extends BaseAdapter implements ListAdapter {

    private Context context;
    private ArrayList<CComunidad> comunidades;

    public AdapterViewMisComunidades(Context context, ArrayList<CComunidad> mobiles) {
        this.context = context;
        this.comunidades = mobiles;
    }

    @Override
    public int getCount() {
        return comunidades.size();
    }

    @Override
    public Object getItem(int position) {
        return comunidades.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = (View) inflater.inflate(R.layout.view_mis_comunidades_entry, null);
        }

        TextView nombre = (TextView)convertView.findViewById(R.id.view_mis_comunidades_nombre);
        TextView ubicacion = (TextView)convertView.findViewById(R.id.view_mis_comunidades_ubicacion);
        TextView admin =(TextView)convertView.findViewById(R.id.view_mis_comunidades_administradores);
        TextView alojamiento =(TextView)convertView.findViewById(R.id.view_mis_comunidades_alojamiento);
        TextView antiguedad = (TextView)convertView.findViewById(R.id.view_mis_comunidades_antiguedad);
        TextView edades = (TextView)convertView.findViewById(R.id.view_mis_comunidades_edades);
        TextView miembros = (TextView)convertView.findViewById(R.id.view_mis_comunidades_miembros);
        TextView origen = (TextView)convertView.findViewById(R.id.view_mis_comunidades_origen);
        TextView telefono = (TextView)convertView.findViewById(R.id.view_mis_comunidades_telefono);
        TextView tipo = (TextView)convertView.findViewById(R.id.view_mis_comunidades_tipo);
        TextView viajes = (TextView)convertView.findViewById(R.id.view_mis_comunidades_viajes);

        nombre.setText(comunidades.get(position).getNombre());
        ubicacion.setText(comunidades.get(position).getDireccion());
        admin.setText("You");
        if(comunidades.get(position).getAlojamiento()){
            alojamiento.setText("Yes");
        }else{
            alojamiento.setText("No");
        }
        antiguedad.setText(String.valueOf(comunidades.get(position).getAntiguedad()));
        edades.setText(String.valueOf(comunidades.get(position).getMinEdad()) + "-" + String.valueOf(comunidades.get(position).getMaxEdad()));
        miembros.setText("0");
        if(comunidades.get(position).getAsendencia() == Constants.Asendencia.ASHKENAZI){
            origen.setText("Ashkenazi");
        }else if(comunidades.get(position).getAsendencia() == Constants.Asendencia.SEFARADI){
            origen.setText("Sefaradi");
        }
        telefono.setText(String.valueOf(comunidades.get(position).getTelefono()));
        if(comunidades.get(position).getTipo() == Constants.TipoComunidad.CONSERVADORA){
            tipo.setText("Conservadora");
        }else if(comunidades.get(position).getTipo() == Constants.TipoComunidad.REFORMISTA){
            tipo.setText("Reformista");
        }
        viajes.setText("No");

        return convertView;
    }
}
