package com.bigbambu.jewmmunity.Layout;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigbambu.jewmmunity.Clases.CPublicacion;
import com.bigbambu.jewmmunity.Clases.CUsuario;
import com.bigbambu.jewmmunity.R;
import com.bigbambu.jewmmunity.Utiles.MyAdapter;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

import java.util.ArrayList;

public class Main extends AppCompatActivity {
    Main contexto;
    RelativeLayout vista_inferior;
    TextView lbl_user;
    TextView lbl_puntaje;
    ImageButton btn_home;
    ImageButton btn_perfil;
    ImageButton btn_buscar_eventos;
    Button btn_settings;
    FragmentManager fragmentManager;
    private static GoogleMap mMap;

    View view_publicaciones;
    View view_perfil;
    View view_buscar_evento;

    CUsuario usuario_actual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        contexto = this;

        // Contenido layout
        vista_inferior = (RelativeLayout) findViewById(R.id.layout_relativo);
        lbl_user = (TextView) findViewById(R.id.lbl_user);
        lbl_puntaje = (TextView) findViewById(R.id.lbl_score);
        btn_home = (ImageButton) findViewById(R.id.btn_home);
        btn_buscar_eventos = (ImageButton) findViewById(R.id.btn_buscar_eventos);
        btn_settings = (Button) findViewById(R.id.btn_settings);
        btn_perfil = (ImageButton) findViewById(R.id.btn_perfil);


        // Usuario Actual
        String usuario_ingresado = getIntent().getStringExtra("usuario");
        if(usuario_ingresado.isEmpty()){
            usuario_ingresado = "miUsuario";
        }
        usuario_actual = CUsuario.generarUsuario(usuario_ingresado);
        lbl_user.setText(usuario_actual.getUsuario());
        lbl_puntaje.setText(String.valueOf(usuario_actual.getPuntaje()));

        // Contenido de vista inferior (default: home)
        btn_home.setBackgroundResource(R.drawable.icon_publications_selected);
        vista_inferior.removeAllViews();
        vista_inferior.addView(View.inflate(contexto, R.layout.view_publicaciones, null));

        cargarViewPublicaciones(contexto);
        cargarViewPerfil(contexto);
        cargarViewBuscarEventos(contexto);

        // Listeners
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_home.setBackgroundResource(R.drawable.icon_publications_selected);
                btn_perfil.setBackgroundResource(R.drawable.icon_profile);
                btn_buscar_eventos.setBackgroundResource(R.drawable.icon_search_event);

                vista_inferior.removeAllViews();
                vista_inferior.addView(view_publicaciones);
            }
        });

        btn_buscar_eventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    btn_home.setBackgroundResource(R.drawable.icon_publications);
                    btn_perfil.setBackgroundResource(R.drawable.icon_profile);
                    btn_buscar_eventos.setBackgroundResource(R.drawable.icon_search_event_selected);

                    vista_inferior.removeAllViews();
                    vista_inferior.addView(view_buscar_evento);
                }
                catch (Exception e){}
            }
        });

        btn_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*try {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Constants.BSAS, 11f));
                    mMap.addMarker(new MarkerOptions().position(new LatLng(-34.619950, -58.420246)).title("Evento").snippet("Shabbaton con los pibes"));
                } catch (Exception e) {
                }*/
                btn_home.setBackgroundResource(R.drawable.icon_publications);
                btn_perfil.setBackgroundResource(R.drawable.icon_profile_selected);
                btn_buscar_eventos.setBackgroundResource(R.drawable.icon_search_event);

                vista_inferior.removeAllViews();
                vista_inferior.addView(view_perfil);
            }
        });

        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Main.this, Settings.class);
                Main.this.startActivity(myIntent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public static void cargarViewPublicaciones(Main contexto)
    {
        // Usuario ajeno
        CUsuario usuario_publicador = CUsuario.generarUsuario("Usuario1");

        // Publicaciones
        ArrayList<CPublicacion> publicaciones =  new ArrayList<CPublicacion>();

        for(int i = 0; i < 10; i++) {
            CPublicacion publicacion = CPublicacion.generarPublicacion(usuario_publicador);
            publicacion.setImagen(contexto.getResources().getDrawable(R.drawable.default_photo));
            publicaciones.add(publicacion);
        }

        // Cargo view_publicaciones
        ListView lista_publicaciones = (ListView)contexto.findViewById(R.id.lst_publicaciones);
        lista_publicaciones.setAdapter(new MyAdapter(contexto, publicaciones));
    }

    public static void cargarViewPerfil(Main contexto)
    {
        contexto.view_perfil = View.inflate(contexto, R.layout.perfil, null);
    }

    public static void cargarViewBuscarEventos(Main contexto) {
        try {
            contexto.fragmentManager = contexto.getFragmentManager();
            contexto.view_buscar_evento = View.inflate(contexto, R.layout.view_buscar_evento, null);
            mMap = ((MapFragment) contexto.fragmentManager.findFragmentById(R.id.map)).getMap();
        }catch (Exception e){}


    }


}
