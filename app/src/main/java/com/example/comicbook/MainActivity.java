package com.example.comicbook;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.comicbook.Modelo.*;
import com.example.comicbook.Utilidades.*;
import com.example.comicbook.Modelo.DbHelper;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


  Button btnRegistrarse, btnCrearBase, btnIngresar;
  DbHelper db;
  TextView user, pass, txtNombre;
  DbHelper conn;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conn = new DbHelper(MainActivity.this, "baseComicSql", null, 1);
        Registrarse();
        Crear();
        InicioSesion();

    }


    public void InicioSesion(){
        user = findViewById(R.id.editTextNickNameLogin);
        pass = findViewById(R.id.editTextPasswordLogin);

        btnIngresar = findViewById(R.id.btnIngresarLogin);
        db = new DbHelper(this, "baseComicSql", null, 1);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = user.getText().toString();
                String contra = pass.getText().toString();

                if (usuario.equals(" ") || contra.equals(" ")){
                    Toast.makeText(MainActivity.this, "Existen Campos Vacios", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean validacion = db.ValidacionUsuarioPass(usuario, contra);
                    if (validacion==true){
                       //Persona per = db.getPersona(usuario);
                        Toast.makeText(MainActivity.this, "Ingreso Correctamente", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Menu_Comic.class);
                        intent.putExtra("Nick_Name", usuario);
                        startActivity(intent);

                    }else{
                        Toast.makeText(MainActivity.this, "Usuario o Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
                        user.setText("");
                        pass.setText("");
                    }
                }
            }
        });



    }


    protected String Nombre(String NickName){
        String nombre="";
        SQLiteDatabase sqLiteDatabase = conn.getReadableDatabase();
        Persona persona = null;
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " +Utilidades.TABLA_PERSONA+" WHERE Nick_Name='"+NickName+"'", null);
        while (cursor.moveToNext()){
            nombre = cursor.getString(1);

        }
        return nombre;
    }





    public void Crear(){
        btnCrearBase = findViewById(R.id.btnCrearBase);
        btnCrearBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper = new DbHelper(MainActivity.this, "baseComicSql", null, 1);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if(db!=null){
                    Toast.makeText(getApplicationContext(), "Base Creada", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Error al Crear la base", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void Registrarse(){
        btnRegistrarse = findViewById(R.id.btnRegistrarseLogin);
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Registro_Usuario.class);
                startActivity(intent);
            }
        });
    }



}