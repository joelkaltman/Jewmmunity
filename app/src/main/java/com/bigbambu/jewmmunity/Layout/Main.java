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

import com.bigbambu.jewmmunity.Clases.CComunidad;
import com.bigbambu.jewmmunity.Clases.CPublicacion;
import com.bigbambu.jewmmunity.Clases.CUsuario;
import com.bigbambu.jewmmunity.R;
import com.bigbambu.jewmmunity.Utiles.AdapterViewMisComunidades;
import com.bigbambu.jewmmunity.Utiles.AdapterViewPublicaciones;
import com.bigbambu.jewmmunity.Utiles.Constants;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class Main extends AppCompatActivity {
    Main contexto;
    RelativeLayout vista_inferior;
    TextView lbl_user;
    TextView lbl_puntaje;
    ImageButton btn_home;
    ImageButton btn_perfil;
    ImageButton btn_mis_comunidades;
    ImageButton btn_buscar_eventos;
    ImageButton btn_buscar_comunidades;
    Button btn_settings;
    FragmentManager fragmentManager;
    private static GoogleMap mapa_eventos;
    private static GoogleMap mapa_comunidades;

    View view_perfil;
    View view_publicaciones;
    View view_mis_comunidades;
    View view_buscar_evento;
    View view_buscar_comunidad;

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
        btn_perfil = (ImageButton) findViewById(R.id.btn_perfil);
        btn_mis_comunidades = (ImageButton) findViewById(R.id.btn_mis_comunidades);
        btn_buscar_eventos = (ImageButton) findViewById(R.id.btn_buscar_eventos);
        btn_buscar_comunidades = (ImageButton) findViewById(R.id.btn_buscar_comunidades);
        btn_settings = (Button) findViewById(R.id.btn_settings);


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
        view_publicaciones = View.inflate(contexto, R.layout.view_publicaciones, null);
        view_mis_comunidades = View.inflate(contexto, R.layout.view_mis_comunidades, null);
        view_perfil = View.inflate(contexto, R.layout.view_perfil, null);
        view_buscar_evento = View.inflate(contexto, R.layout.view_buscar_evento, null);
        view_buscar_comunidad = View.inflate(contexto, R.layout.view_buscar_comunidad, null);

        vista_inferior.removeAllViews();
        vista_inferior.addView(view_mis_comunidades);
        vista_inferior.addView(view_perfil);
        vista_inferior.addView(view_publicaciones);

        cargarViewPerfil(contexto);
        cargarViewPublicaciones(contexto);
        cargarViewMisComunidades(contexto);
        cargarViewBuscarEventos(contexto);
        cargarViewBuscarComunidades(contexto);

        btn_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_home.setBackgroundResource(R.drawable.icon_publications);
                btn_perfil.setBackgroundResource(R.drawable.icon_profile_selected);
                btn_buscar_eventos.setBackgroundResource(R.drawable.icon_search_event);
                btn_buscar_comunidades.setBackgroundResource(R.drawable.icon_search_community);
                btn_mis_comunidades.setBackgroundResource(R.drawable.icon_community);

                vista_inferior.removeAllViews();
                vista_inferior.addView(view_perfil);
            }
        });

        // Listeners
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_home.setBackgroundResource(R.drawable.icon_publications_selected);
                btn_perfil.setBackgroundResource(R.drawable.icon_profile);
                btn_buscar_eventos.setBackgroundResource(R.drawable.icon_search_event);
                btn_buscar_comunidades.setBackgroundResource(R.drawable.icon_search_community);
                btn_mis_comunidades.setBackgroundResource(R.drawable.icon_community);

                vista_inferior.removeAllViews();
                vista_inferior.addView(view_publicaciones);
            }
        });

        btn_mis_comunidades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_home.setBackgroundResource(R.drawable.icon_publications);
                btn_perfil.setBackgroundResource(R.drawable.icon_profile);
                btn_buscar_eventos.setBackgroundResource(R.drawable.icon_search_event);
                btn_buscar_comunidades.setBackgroundResource(R.drawable.icon_search_community);
                btn_mis_comunidades.setBackgroundResource(R.drawable.icon_community_selected);

                vista_inferior.removeAllViews();
                vista_inferior.addView(view_mis_comunidades);
            }
        });

        btn_buscar_eventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    btn_home.setBackgroundResource(R.drawable.icon_publications);
                    btn_perfil.setBackgroundResource(R.drawable.icon_profile);
                    btn_buscar_eventos.setBackgroundResource(R.drawable.icon_search_event_selected);
                    btn_buscar_comunidades.setBackgroundResource(R.drawable.icon_search_community);
                    btn_mis_comunidades.setBackgroundResource(R.drawable.icon_community);

                    vista_inferior.removeAllViews();
                    vista_inferior.addView(view_buscar_evento);
                }
                catch (Exception e){}
            }
        });

        btn_buscar_comunidades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    btn_home.setBackgroundResource(R.drawable.icon_publications);
                    btn_perfil.setBackgroundResource(R.drawable.icon_profile);
                    btn_buscar_eventos.setBackgroundResource(R.drawable.icon_search_event);
                    btn_buscar_comunidades.setBackgroundResource(R.drawable.icon_search_community_selected);
                    btn_mis_comunidades.setBackgroundResource(R.drawable.icon_community);

                    vista_inferior.removeAllViews();
                    vista_inferior.addView(view_buscar_comunidad);
                }
                catch (Exception e){}
            }
        });

        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Main.this, Settings.class);
                Main.this.startActivity(myIntent);
            }
        });
        Button btn_inbox = ((Button) findViewById(R.id.btn_inbox));
        btn_inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usuario_actual.getUsuario().equals("chebita")) {
                    Intent myIntent = new Intent(Main.this, Adm_com.class);
                    myIntent.putExtra("usuario", usuario_actual.getUsuario());
                    Main.this.startActivity(myIntent);
                }
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
        lista_publicaciones.setAdapter(new AdapterViewPublicaciones(contexto, publicaciones));
    }

    public static void cargarViewPerfil(Main contexto)
    {
        TextView lbl_nombre = (TextView)contexto.findViewById(R.id.view_perfil_lbl_nombre);
        TextView lbl_apellido = (TextView)contexto.findViewById(R.id.view_perfil_lbl_apellido);
        TextView lbl_apellido_madre = (TextView)contexto.findViewById(R.id.view_perfil_lbl_apellido_madre);
        TextView lbl_comunidades = (TextView)contexto.findViewById(R.id.view_perfil_lbl_comunidades);
        TextView lbl_email = (TextView)contexto.findViewById(R.id.view_perfil_lbl_email);
        TextView lbl_sexo = (TextView)contexto.findViewById(R.id.view_perfil_lbl_sexo);
        TextView lbl_telefono = (TextView)contexto.findViewById(R.id.view_perfil_lbl_telefono);
        TextView lbl_nacimiento = (TextView)contexto.findViewById(R.id.view_perfil_lbl_nacimiento);

        lbl_nombre.setText(contexto.usuario_actual.getNombre());
        lbl_apellido.setText(contexto.usuario_actual.getApellido());
        lbl_apellido_madre.setText(contexto.usuario_actual.getApellido_madre());
        lbl_comunidades.setText("SD");
        lbl_email.setText(contexto.usuario_actual.getEmail());
        if(contexto.usuario_actual.getSexo() == Constants.SexoUsuario.HOMBRE)
        {
            lbl_sexo.setText("Man");
        }else {
            lbl_sexo.setText("Woman");
        }
        lbl_telefono.setText(String.valueOf(contexto.usuario_actual.getTelefono()));
        lbl_nacimiento.setText(contexto.usuario_actual.getNacimiento());

    }

    public void cargarViewMisComunidades(Main contexto)
    {
        // Publicaciones
        ArrayList<CComunidad> comunidades =  new ArrayList<CComunidad>();

        for(int i = 0; i < 2; i++) {
            CComunidad comunidad = CComunidad.generarComunidad();
            comunidades.add(comunidad);
        }

        // Cargo view_publicaciones
        ListView lista_publicaciones = (ListView)findViewById(R.id.lst_mis_comunidades);
        lista_publicaciones.setAdapter(new AdapterViewMisComunidades(this, comunidades));
    }

    public static void cargarViewBuscarEventos(Main contexto) {
        try {
            contexto.fragmentManager = contexto.getFragmentManager();
            mapa_eventos = ((MapFragment) contexto.fragmentManager.findFragmentById(R.id.view_buscar_evento_map)).getMap();
        }catch (Exception e){}

        if(mapa_eventos != null){
            CameraPosition cameraPosition = new CameraPosition.Builder().target(Constants.BSAS).zoom(12).bearing(0).tilt(45).build();
            mapa_eventos.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            mapa_eventos.addMarker(new MarkerOptions().position(Constants.BSAS).title("Shabbaton SD").snippet("22:00hs"));
            mapa_eventos.addMarker(new MarkerOptions().position(new LatLng(-34.588258, -58.427869)).title("Purim").snippet("22:00hs"));
            mapa_eventos.addMarker(new MarkerOptions().position(new LatLng(-34.620756, -58.407871)).title("Rikudim contest").snippet("20:30hs"));
            mapa_eventos.addMarker(new MarkerOptions().position(new LatLng(-34.607900, -58.468811)).title("Cortada de prepucio gratuita").snippet("3:00hs"));

        }

    }

    public static void cargarViewBuscarComunidades(Main contexto) {
        try {
            contexto.fragmentManager = contexto.getFragmentManager();
            mapa_comunidades = ((MapFragment) contexto.fragmentManager.findFragmentById(R.id.view_buscar_comunidad_map)).getMap();
        }catch (Exception e){}

        if(mapa_comunidades != null){
            CameraPosition cameraPosition = new CameraPosition.Builder().target(Constants.BSAS).zoom(12).bearing(0).tilt(45).build();
            mapa_comunidades.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            mapa_comunidades.addMarker(new MarkerOptions().position(new LatLng(-34.596501, -58.481868)).title("Sucath David").snippet("54 members"));
            mapa_comunidades.addMarker(new MarkerOptions().position(new LatLng(-34.605427, -58.450786)).title("Dor jaddash").snippet("256 members"));
            mapa_comunidades.addMarker(new MarkerOptions().position(new LatLng(-34.595460, -58.419731)).title("Menora").snippet("115 members"));
            mapa_comunidades.addMarker(new MarkerOptions().position(new LatLng(-34.560484, -58.465862)).title("Isej").snippet("99 members"));

        }

    }

}
