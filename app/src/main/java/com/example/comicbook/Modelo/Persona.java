package com.example.comicbook.Modelo;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

public class Persona extends Tipo_Persona{

    private String Nick_Name;
    private String Nombre;
    private String apellido;
    private int edad;
    private String Correo_Electronico;
    private String password;
    ArrayList<Persona> listaPersona;



    public void guardar(Context context ){
        DbHelper dbHelper = new DbHelper(context, "baseComicSql", null, 1);
        String nsql = "INSERT INTO persona (Nick_Name, Nombre, Apellido, edad, Correo, Contrasenia) " +
                "VALUES ('"+getNick_Name()+"','"+getNombre()+"','"+getApellido()+"',"+getEdad()+",'"+getCorreo_Electronico()+"','"+getPassword()+"');";
        dbHelper.noQuery(nsql);
        dbHelper.close();
    }



    public void buscar(Context context, String user){
        DbHelper dbHelper = new DbHelper(context, "baseComicSql", null, 1);
        String sql = "SELECT * FROM persona WHERE Nick_Name='"+ user +"'";
        dbHelper.query(sql);
        dbHelper.close();
        Toast.makeText(context, "Este Metodo funciona", Toast.LENGTH_SHORT).show();

    }

    public Persona() {
    }

    public Persona(String nick_Name, String nombre, String apellido, int edad, String correo_Electronico, String password) {
        Nick_Name = nick_Name;
        Nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        Correo_Electronico = correo_Electronico;
        this.password = password;
    }

    public Persona(String cod_Tipo_Persona, String tipo_Persona, String fecha_Creacion, String nick_Name2, String nick_Name, String nombre, String apellido, int edad, String correo_Electronico, String password) {
        super(cod_Tipo_Persona, tipo_Persona, fecha_Creacion, nick_Name2);
        Nick_Name = nick_Name;
        Nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        Correo_Electronico = correo_Electronico;
        this.password = password;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNick_Name() {
        return Nick_Name;
    }

    public void setNick_Name(String nick_Name) {
        Nick_Name = nick_Name;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo_Electronico() {
        return Correo_Electronico;
    }

    public void setCorreo_Electronico(String correo_Electronico) {
        Correo_Electronico = correo_Electronico;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
