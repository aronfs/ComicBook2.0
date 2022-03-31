package com.example.comicbook.Utilidades;


public class Utilidades {




    //Constantes campos tabla persona
    public static final String TABLA_PERSONA = "persona ";
    public static final String NICKNAME = "Nick_Name ";
    public static final String NOMBRE = "Nombre ";
    public static final String APELLIDO = "Apellido ";
    public static final String EDAD = "edad ";
    public static final String CORREO = "Correo ";
    public static final String PASSWORD = "Contrasenia ";
    public static final String IMAGENFOTO = "IMAGEN ";

    public static final String CREAR_TABLA_PERSONA = "CREATE TABLE " +
            "" + TABLA_PERSONA + " (" + NICKNAME + " " +
            " TEXT PRIMARY KEY, " + NOMBRE + " TEXT," + APELLIDO + " TEXT," + EDAD + " INTEGER, " + CORREO + " TEXT," + PASSWORD + " TEXT, "+IMAGENFOTO+" BLOB)";

    //Constantes campos tabla Tipo Persona
    public static final String TABLA_TIPO_PERSONA = "tipo_Persona ";
    public static final String COD_TIPO_PERSONA = "Cod_tipo_Persona ";
    public static final String TIPO_PERSONA = "tipo_Titulo_Persona " ;
    public static final String FECHA_CREACION = "Fecha_Creacion ";
    public static final String NICK_NAME = "Nick_Name ";
    public static final String FK_NICK_NAME = "FK_Nick_Name ";

    public static String CREAR_TABLA_TIPO_PERSONA = "CREATE TABLE " +
            " " + TABLA_TIPO_PERSONA + " (" + COD_TIPO_PERSONA + "" +
            " TEXT PRIMARY KEY, " + TIPO_PERSONA + " TEXT, " + FECHA_CREACION + " TEXT, " + NICK_NAME + " TEXT," +
            " CONSTRAINT "+FK_NICK_NAME+" FOREIGN KEY ("+NICK_NAME+") REFERENCES "+TABLA_PERSONA+"("+NICKNAME+"))";

    //CONSTANTES CAMPOS TABLA COMIC
    public static final String TABLA_COMIC = "comic ";
    public static final String SERIAL_COMIC = "Serial_Comic ";
    public static final String TITULO_COMIC = "Titulo_Comic ";
    public static final String EDITORIAL_COMIC = "Editorial_Comic ";
    public static final String NUMERO_TOMOS = "Numero_Tomos ";
    public static final String GENERO_COMIC = "Genero_Comic ";
    public static final String PUNTUACION = "Puntuacion ";
    public static final String DESCRIPCION = "Descripcion ";


    public static String CREAR_TABLA_COMIC = "CREATE TABLE " +
            "" + TABLA_COMIC + " (" + SERIAL_COMIC + "" +
            " TEXT PRIMARY KEY, " + TITULO_COMIC + " TEXT, " + EDITORIAL_COMIC + " TEXT, " + NUMERO_TOMOS + " INTEGER, " + GENERO_COMIC + " TEXT, " + PUNTUACION + " INTEGER, " + DESCRIPCION + "  TEXT) ";


    //CONSTANTES CAMPOS TABLA TIPO_COMIC
    public static final String TABLA_TIPO_COMIC = "tipo_Comic ";
    public static final String COD_TIPO_COMIC = "Cod_tipo_Comic ";
    public static final String TIPO_COMIC = "tipo_titulo_Comic ";
    public static final String FECHA_PUBLICACION = "Fecha_Publicacion ";
    public static final String COD_TIPO_PERSONA1 = "Cod_tipo_Persona ";
    public static final String SERIAL_COMIC1 = "Serial_Comic ";
    public static final String FK_TIPOPERSONA = "FK_tipo_Persona ";
    public static final String FK_COMIC = "FK_Comic ";
    public static final String IMAGENCOMIC = "Imagen_comic ";

    public static String CREAR_TABLA_TIPO_COMIC = "CREATE TABLE " +
            "" + TABLA_TIPO_COMIC + " ( " + COD_TIPO_COMIC + " TEXT PRIMARY KEY, " +
            "" + TIPO_COMIC + " TEXT, " + FECHA_PUBLICACION + " TEXT, " + COD_TIPO_PERSONA1 + " TEXT, " + SERIAL_COMIC1 + " TEXT," + IMAGENCOMIC + "  TEXT, " +
            " CONSTRAINT  "+FK_TIPOPERSONA+" FOREIGN KEY ("+COD_TIPO_PERSONA1+") REFERENCES "+TABLA_TIPO_PERSONA+" ("+COD_TIPO_PERSONA+")," +
            " CONSTRAINT "+FK_COMIC+" FOREIGN KEY ("+SERIAL_COMIC1+") REFERENCES "+TABLA_COMIC+" ("+SERIAL_COMIC+"))";







}

