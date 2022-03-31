package com.example.comicbook.Modelo;


import android.content.Context;

public class Tipo_Persona {

    private String Cod_Tipo_Persona;
    private String Tipo_Persona;
    private String Fecha_Creacion;
    private String Nick_Name2;



    public void GuardarTipo(Context context){
        DbHelper dbHelper = new DbHelper(context, "baseComicSql", null, 1);
        String sql= "INSERT INTO tipo_Persona (Cod_tipo_Persona, tipo_Titulo_Persona, Fecha_Creacion, Nick_Name)  " +
                "VALUES ( '"+getCod_Tipo_Persona()+"','"+getTipo_Persona()+"','"+getFecha_Creacion()+"','"+getNick_Name2()+"');";
        dbHelper.noQuery(sql);
        dbHelper.close();
    }

    public Tipo_Persona() {
    }

    public Tipo_Persona(String cod_Tipo_Persona, String tipo_Persona, String fecha_Creacion, String nick_Name2) {
        Cod_Tipo_Persona = cod_Tipo_Persona;
        Tipo_Persona = tipo_Persona;
        Fecha_Creacion = fecha_Creacion;
        Nick_Name2 = nick_Name2;
    }

    public String getCod_Tipo_Persona() {
        return Cod_Tipo_Persona;
    }

    public void setCod_Tipo_Persona(String cod_Tipo_Persona) {
        Cod_Tipo_Persona = cod_Tipo_Persona;
    }

    public String getTipo_Persona() {
        return Tipo_Persona;
    }

    public void setTipo_Persona(String tipo_Persona) {
        Tipo_Persona = tipo_Persona;
    }

    public String getFecha_Creacion() {
        return Fecha_Creacion;
    }

    public void setFecha_Creacion(String fecha_Creacion) {
        Fecha_Creacion = fecha_Creacion;
    }

    public String getNick_Name2() {
        return Nick_Name2;
    }

    public void setNick_Name2(String nick_Name2) {
        Nick_Name2 = nick_Name2;
    }
}
