package com.example.comicbook.Modelo;

import android.content.Context;

public class Comic extends Tipo_Comic{

    private String Serial_Comic;
    private String Titulo_Comic;
    private String Editorial_Comic;
    private int Numero_Tomos;
    private String Genero_Comic;
    private int Puntuacion;
    private String Descripcion;
    private String img;

    public Comic() {

    }

    public void Guardar(Context context){
        DbHelper helper = new DbHelper(context, "baseComicSql", null, 1);
        String sql = "INSERT INTO comic (Serial_Comic, Titulo_Comic, Editorial_Comic, Numero_tomos, Genero_Comic, Puntuacion, Descripcion) " +
                "VALUES ('"+getSerial_Comic()+"','"+getTitulo_Comic()+"','"+getEditorial_Comic()+"',"+getNumero_Tomos()+",'"+getGenero_Comic()+"',"+getPuntuacion()+",'"+getDescripcion()+"');";
        helper.noQuery(sql);
        helper.close();

    }

    public Comic(String cod_tipo_Comic, String tipo_comic, String fecha_Publicacion, String cod_tipo_Persona1, String serial_Comic1, String serial_Comic, String titulo_Comic, String editorial_Comic, int numero_Tomos, String genero_Comic, int puntuacion, String descripcion, String img) {
        super(cod_tipo_Comic, tipo_comic, fecha_Publicacion, cod_tipo_Persona1, serial_Comic1);
        Serial_Comic = serial_Comic;
        Titulo_Comic = titulo_Comic;
        Editorial_Comic = editorial_Comic;
        Numero_Tomos = numero_Tomos;
        Genero_Comic = genero_Comic;
        Puntuacion = puntuacion;
        Descripcion = descripcion;
        this.img = img;
    }

    public Comic(String cod_Tipo_Persona, String tipo_Persona, String fecha_Creacion, String nick_Name2, String cod_tipo_Comic, String tipo_comic, String fecha_Publicacion, String cod_tipo_Persona1, String serial_Comic1, String serial_Comic, String titulo_Comic, String editorial_Comic, int numero_Tomos, String genero_Comic, int puntuacion, String descripcion, String img) {
        super(cod_Tipo_Persona, tipo_Persona, fecha_Creacion, nick_Name2, cod_tipo_Comic, tipo_comic, fecha_Publicacion, cod_tipo_Persona1, serial_Comic1);
        Serial_Comic = serial_Comic;
        Titulo_Comic = titulo_Comic;
        Editorial_Comic = editorial_Comic;
        Numero_Tomos = numero_Tomos;
        Genero_Comic = genero_Comic;
        Puntuacion = puntuacion;
        Descripcion = descripcion;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSerial_Comic() {
        return Serial_Comic;
    }

    public void setSerial_Comic(String serial_Comic) {
        Serial_Comic = serial_Comic;
    }

    public String getTitulo_Comic() {
        return Titulo_Comic;
    }

    public void setTitulo_Comic(String titulo_Comic) {
        Titulo_Comic = titulo_Comic;
    }

    public String getEditorial_Comic() {
        return Editorial_Comic;
    }

    public void setEditorial_Comic(String editorial_Comic) {
        Editorial_Comic = editorial_Comic;
    }

    public int getNumero_Tomos() {
        return Numero_Tomos;
    }

    public void setNumero_Tomos(int numero_Tomos) {
        Numero_Tomos = numero_Tomos;
    }

    public String getGenero_Comic() {
        return Genero_Comic;
    }

    public void setGenero_Comic(String genero_Comic) {
        Genero_Comic = genero_Comic;
    }

    public int getPuntuacion() {
        return Puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        Puntuacion = puntuacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
