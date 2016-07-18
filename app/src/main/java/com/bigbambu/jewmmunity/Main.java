package com.bigbambu.jewmmunity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main extends AppCompatActivity {
    TextView lbl_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        lbl_user = (TextView) findViewById(R.id.lbl_user);

        String nombre_usuario = getIntent().getStringExtra("usuario");
        lbl_user.setText(nombre_usuario);



        CPublication publication;

        ArrayList<CPublication> publications =  new ArrayList<CPublication>();

        publication = new CPublication();
        publication.setName("Publicacion1");
        publication.setSummary("Descripcion de publicacion");
        publications.add(publication);

        publication = new CPublication();
        publication.setName("Publicacion2");
        publication.setSummary("Descripcion de publicacion");
        publications.add(publication);

        publication = new CPublication();
        publication.setName("Publicacion2");
        publication.setSummary("Descripcion de publicacion");
        publications.add(publication);

        publication = new CPublication();
        publication.setName("Publicacion2");
        publication.setSummary("Descripcion de publicacion");
        publications.add(publication);

        publication = new CPublication();
        publication.setName("Publicacion2");
        publication.setSummary("Descripcion de publicacion");
        publications.add(publication);

        publication = new CPublication();
        publication.setName("Publicacion2");
        publication.setSummary("Descripcion de publicacion");
        publications.add(publication);

        ListView lista_publicaciones = (ListView)findViewById(R.id.lst_publicaciones);
        lista_publicaciones.setAdapter(new MyAdapter(this, publications));
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
