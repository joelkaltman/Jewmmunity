package com.bigbambu.jewmmunity.Layout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bigbambu.jewmmunity.R;

/**
 * Created by Joel on 19-Jul-16.
 */
public class Settings extends AppCompatActivity {
    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        guardar = (Button)findViewById(R.id.btn_guardar_settings);

        guardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
