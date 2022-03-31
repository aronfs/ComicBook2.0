package com.example.comicbook.Modelo;

import android.content.Context;

public class Tipo_Comic extends Tipo_Persona{

    private String Cod_tipo_Comic;
    private String tipo_comic;
    private String Fecha_Publicacion;
    private String Cod_tipo_Persona1;
    private String Serial_Comic1;

    public void GuardarTipoComic(Context context){
        DbHelper dbHelper = new DbHelper(context, "baseComicSql", null, 1);
        String sql = "INSERT INTO tipo_Comic (Cod_tipo_Comic, tipo_titulo_Comic, Fecha_Publicacion, Cod_tipo_Persona, Serial_Comic) " +
                "VALUES ('"+getCod_tipo_Comic()+"','"+getTipo_comic()+"','"+getFecha_Publicacion()+"','"+"Autor"+"','"+getSerial_Comic1()+"')";
        dbHelper.noQuery(sql);
        dbHelper.close();
    }

    public Tipo_Comic() {
    }

    public Tipo_Comic(String cod_tipo_Comic, String tipo_comic, String fecha_Publicacion, String cod_tipo_Persona1, String serial_Comic1) {
        Cod_tipo_Comic = cod_tipo_Comic;
        this.tipo_comic = tipo_comic;
        Fecha_Publicacion = fecha_Publicacion;
        Cod_tipo_Persona1 = cod_tipo_Persona1;
        Serial_Comic1 = serial_Comic1;
    }

    public Tipo_Comic(String cod_Tipo_Persona, String tipo_Persona, String fecha_Creacion, String nick_Name2, String cod_tipo_Comic, String tipo_comic, String fecha_Publicacion, String cod_tipo_Persona1, String serial_Comic1) {
        super(cod_Tipo_Persona, tipo_Persona, fecha_Creacion, nick_Name2);
        Cod_tipo_Comic = cod_tipo_Comic;
        this.tipo_comic = tipo_comic;
        Fecha_Publicacion = fecha_Publicacion;
        Cod_tipo_Persona1 = cod_tipo_Persona1;
        Serial_Comic1 = serial_Comic1;
    }

    public String getCod_tipo_Comic() {
        return Cod_tipo_Comic;
    }

    public void setCod_tipo_Comic(String cod_tipo_Comic) {
        Cod_tipo_Comic = cod_tipo_Comic;
    }

    public String getTipo_comic() {
        return tipo_comic;
    }

    public void setTipo_comic(String tipo_comic) {
        this.tipo_comic = tipo_comic;
    }

    public String getFecha_Publicacion() {
        return Fecha_Publicacion;
    }

    public void setFecha_Publicacion(String fecha_Publicacion) {
        Fecha_Publicacion = fecha_Publicacion;
    }

    public String getCod_tipo_Persona1() {
        return Cod_tipo_Persona1;
    }

    public void setCod_tipo_Persona1(String cod_tipo_Persona1) {
        Cod_tipo_Persona1 = cod_tipo_Persona1;
    }

    public String getSerial_Comic1() {
        return Serial_Comic1;
    }

    public void setSerial_Comic1(String serial_Comic1) {
        Serial_Comic1 = serial_Comic1;
    }
}
