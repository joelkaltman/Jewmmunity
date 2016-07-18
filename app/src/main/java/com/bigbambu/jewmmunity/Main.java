package com.bigbambu.jewmmunity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        CPublication publication;

        ArrayList<CPublication> publications =  new ArrayList<CPublication>();

        publication = new CPublication();
        publication.setName("Android");
        publication.setSummary("summary goes here");
        publications.add(publication);

        publication = new CPublication();
        publication.setName("Blackberry");
        publication.setSummary("summary goes here");
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
