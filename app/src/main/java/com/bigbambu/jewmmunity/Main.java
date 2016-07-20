package com.bigbambu.jewmmunity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Main extends AppCompatActivity {
    Context contexto;
    RelativeLayout vista_inferior;
    TextView lbl_user;
    ImageButton btn_home;
    ImageButton btn_fotos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        contexto = this;

        // Contenido layout
        vista_inferior = (RelativeLayout) findViewById(R.id.layout_relativo);
        lbl_user = (TextView) findViewById(R.id.lbl_user);
        btn_home = (ImageButton) findViewById(R.id.btn_home);
        btn_fotos = (ImageButton) findViewById(R.id.btn_fotos);

        // Usuario Actual
        CUsuario usuario_actual = CUsuario.generarUsuario(getIntent().getStringExtra("usuario"));
        lbl_user.setText(usuario_actual.getUsuario());

        // Usuario ajeno
        CUsuario usuario_publicador = CUsuario.generarUsuario("Usuario1");

        // Publicaciones
        ArrayList<CPublicacion> publicaciones =  new ArrayList<CPublicacion>();

        for(int i = 0; i < 10; i++) {
            CPublicacion publicacion = CPublicacion.generarPublicacion(usuario_publicador);
            publicacion.setImagen(getResources().getDrawable(R.drawable.default_photo));
            publicaciones.add(publicacion);
        }

        // Contenido de vista inferior (default: home)
        vista_inferior.removeAllViews();
        vista_inferior.addView(View.inflate(this, R.layout.view_publicaciones, null));

        // Cargo layout de publicaciones
        ListView lista_publicaciones = (ListView)findViewById(R.id.lst_publicaciones);
        lista_publicaciones.setAdapter(new MyAdapter(contexto, publicaciones));

        // Listeners
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vista_inferior.removeAllViews();
                vista_inferior.addView(View.inflate(contexto, R.layout.view_publicaciones, null));
            }
        });

        btn_fotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vista_inferior.removeAllViews();
                vista_inferior.addView(View.inflate(contexto, R.layout.view_fotos, null));
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
}
