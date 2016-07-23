package com.bigbambu.jewmmunity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Sebas on 06/01/2016.
 */
public class Mapa implements GoogleMap.OnMapLongClickListener{

    public static GoogleMap map;
    public static boolean ready = false;

    public Mapa(boolean clickeable) {
        if(clickeable)
            Mapa.map.setOnMapLongClickListener(this);
        Mapa.ready = true;
        centrarMapa(Constants.BSAS);

    }

    public void centrarMapa(LatLng ubic) {
        if(Mapa.ready)
            Mapa.map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(ubic.latitude, ubic.longitude), 11f));
    }

    @Override
    public void onMapLongClick(LatLng point) {
      }

}
