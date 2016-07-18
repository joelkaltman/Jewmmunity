package com.bigbambu.jewmmunity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Joel on 17-Jul-16.
 */
public class Login extends AppCompatActivity {
    Button btn_login;
    TextView txt_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btn_login = (Button)findViewById(R.id.btn_login);
        txt_user = (TextView) findViewById(R.id.txt_user);

        btn_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(Login.this, Main.class);
                String nombre_usuario = txt_user.getText().toString();
                myIntent.putExtra("usuario", nombre_usuario);
                Login.this.startActivity(myIntent);
            }
        });

    }
}
