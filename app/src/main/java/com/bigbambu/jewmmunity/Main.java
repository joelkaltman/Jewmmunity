package com.bigbambu.jewmmunity;

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

import java.util.ArrayList;

public class Main extends AppCompatActivity {
    Main contexto;
    RelativeLayout vista_inferior;
    TextView lbl_user;
    TextView lbl_puntaje;
    ImageButton btn_home;
    ImageButton btn_fotos;
    Button btn_settings;


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
        btn_fotos = (ImageButton) findViewById(R.id.btn_fotos);
        btn_settings = (Button) findViewById(R.id.btn_settings);


        // Usuario Actual
        String usuario_ingresado = getIntent().getStringExtra("usuario");
        if(usuario_ingresado.isEmpty()){
            usuario_ingresado = "miUsuario";
        }
        CUsuario usuario_actual = CUsuario.generarUsuario(usuario_ingresado);
        lbl_user.setText(usuario_actual.getUsuario());
        lbl_puntaje.setText(String.valueOf(usuario_actual.getPuntaje()));

        // Contenido de vista inferior (default: home)
        btn_home.setBackgroundResource(R.drawable.icon_home_selected);
        vista_inferior.removeAllViews();
        vista_inferior.addView(View.inflate(contexto, R.layout.view_publicaciones, null));
        this.cargarViewPublicaciones(contexto);

        // Listeners
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_home.setBackgroundResource(R.drawable.icon_home_selected);
                btn_fotos.setBackgroundResource(R.drawable.icon_photos);

                vista_inferior.removeAllViews();
                vista_inferior.addView(View.inflate(contexto, R.layout.view_publicaciones, null));
                Main.cargarViewPublicaciones(contexto);
            }
        });

        btn_fotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_home.setBackgroundResource(R.drawable.icon_home);
                btn_fotos.setBackgroundResource(R.drawable.icon_photos_selected);

                vista_inferior.removeAllViews();
                vista_inferior.addView(View.inflate(contexto, R.layout.view_fotos, null));
                Main.cargarViewFotos(contexto);
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

    public static void cargarViewFotos(Main contexto)
    {

    }

}
