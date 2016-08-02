package com.bigbambu.jewmmunity.Utiles;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Sebas on 09/01/2016.
 */
public class Constants {

    public static final LatLng BSAS = new LatLng(-34.6229419,-58.4491101);

    public enum TipoComunidad {
        CONSERVADORA, REFORMISTA
    }

    public enum Asendencia{
        SEFARADI, ASHKENAZI
    }

    public enum TipoEvento{
        SHABBATON, PEGUISHA, OTRO
    }

    public enum TipoPublicacion{
        EVENTO, NOTICIA
    }

    public enum RubrosTrabajo{
        INFORMATICA, LIDER, ADMINISTRACION,
    }

    public enum SexoUsuario{
        HOMBRE, MUJER
    }
}
