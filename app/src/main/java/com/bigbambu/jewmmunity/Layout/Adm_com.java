package com.bigbambu.jewmmunity.Layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bigbambu.jewmmunity.Clases.CUsuario;
import com.bigbambu.jewmmunity.R;

/**
 * Created by Joel on 30-Jul-16.
 */
public class Adm_com extends AppCompatActivity {

    Button btn_crear;
    Button btn_volver;
    TextView com_nombre;
    TextView com_ciudad;
    TextView com_tipo;
    TextView com_usuario;
    TextView com_mail;
    CUsuario usuario_actual;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adm_com);

        btn_crear = (Button) findViewById(R.id.btn_crear);
        btn_volver = (Button) findViewById(R.id.btn_volver);

        String usuario_ingresado = getIntent().getStringExtra("usuario");
        if(usuario_ingresado.isEmpty()){
            usuario_ingresado = "miUsuario";
        }
        usuario_actual = CUsuario.generarUsuario(usuario_ingresado);

        com_nombre = (TextView) findViewById(R.id.com_nombre);
        com_ciudad = (TextView) findViewById(R.id.com_ciudad);
        com_tipo = (TextView) findViewById(R.id.com_tipo);
        com_usuario = (TextView) findViewById(R.id.com_usuario);
        com_mail = (TextView) findViewById(R.id.com_mail);


        btn_crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(Adm_com.this, "Se creo la comunidad ".concat(com_nombre.getText().toString()), Toast.LENGTH_LONG);
                toast.show();
                com_nombre.setText("");
                com_ciudad.setText("");
                com_tipo.setText("");
                com_usuario.setText("");
                com_mail.setText("");
            }
        });

        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Adm_com.this, Main.class);
                myIntent.putExtra("usuario", usuario_actual.getUsuario());
                startActivity(myIntent);
                finish();
            }
        });
    }
}
