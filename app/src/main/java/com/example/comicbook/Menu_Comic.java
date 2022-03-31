package com.example.comicbook;

import androidx.appcompat.app.AppCompatActivity;
import com.example.comicbook.Modelo.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu_Comic extends AppCompatActivity {


    Button btnPerfilMenu, btnCatalagoMenu, btnPublicacionMenu, btnConsumiendoServicios;
    TextView txtNombre, txtCorreo;
    String nick_Name="";
    Persona per;
    DbHelper db;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        txtNombre = findViewById(R.id.txtNombreMenu);
        RegistroComic();
        Perfil();
        Catalogos();
        Bundle b = getIntent().getExtras();
        nick_Name = b.getString("Nick_Name");
        //per = db.getPersonaId(nick_Name);
        txtNombre.setText(nick_Name);



    }





    public void RegistroComic(){
        btnPublicacionMenu = findViewById(R.id.btnPublicacionMenu);
        btnPublicacionMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu_Comic.this, Registro_Comic.class);
                startActivity(intent);
            }
        });
    }

    public void Perfil(){
        txtCorreo = findViewById(R.id.txtCorreoMenu);
        btnPerfilMenu = findViewById(R.id.btnPerfilMenu);
        btnPerfilMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                per = db.getPersonaId(nick_Name);
               txtCorreo.setText(per.getCorreo_Electronico());
            }
        });
    }


    public void Catalogos(){
        btnCatalagoMenu = findViewById(R.id.btnCatalogoMenu);
        btnCatalagoMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu_Comic.this, Catalogo_Comic.class );
                startActivity(intent);
            }
        });
    }





}