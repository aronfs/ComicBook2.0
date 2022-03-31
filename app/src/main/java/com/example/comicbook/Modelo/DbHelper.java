package com.example.comicbook.Modelo;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.comicbook.Utilidades.Utilidades;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NOMBRE = "baseComicSql.db";
    private static final int DATABASE_VERSION=2;
   // ArrayList<Persona> listaPersona;

    public DbHelper(@Nullable Context context, String baseComicSql, Object o, int i) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PERSONA);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_TIPO_PERSONA);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_COMIC);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_TIPO_COMIC);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ Utilidades.TABLA_PERSONA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ Utilidades.TABLA_TIPO_PERSONA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ Utilidades.TABLA_COMIC);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ Utilidades.TABLA_TIPO_COMIC);
        onCreate(sqLiteDatabase);

    }

    protected void noQuery(String nsql ){
        this.getWritableDatabase().execSQL(nsql);
    }

    protected Cursor query(String sql){
        return this.getReadableDatabase().rawQuery(sql, null);
    }


    public Boolean ValidacionUsuario(String usuario){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from persona where Nick_Name= ?", new String[] {usuario});
        if (cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean ValidacionUsuarioPass ( String usuario, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM persona where Nick_Name= ? and Contrasenia= ?", new String[]{usuario,password});
        if (cursor.getCount()>0){

            return true;
        }else{
            return false;
        }
    }




    public ArrayList<Persona> selectPersonas(){
        ArrayList<Persona> listaPersona = new ArrayList<Persona>();
        listaPersona.clear();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PERSONA+" p INNER JOIN "+Utilidades.TIPO_PERSONA+" t ON ( p."+Utilidades.NICK_NAME+"= t."+Utilidades.NICKNAME+") " , null);
        if (cursor.moveToFirst()){
            do {
                Persona p = new Persona();
                p.setNick_Name(cursor.getString(0));
                p.setNombre(cursor.getString(1));
                p.setApellido(cursor.getString(2));
                p.setEdad(cursor.getInt(3));
                p.setCorreo_Electronico(cursor.getString(4));
                p.setTipo_Persona(cursor.getString(7));
                listaPersona.add(p);
            }while (cursor.moveToNext());
        }
        return listaPersona;
    }



    public Persona getPersona(String user) {
        ArrayList<Persona>  listaPersona = selectPersonas();
        for (Persona p: listaPersona){
            if (p.getNick_Name().equals(user)){
                return p;
            }
        }
      return null;

    }


    public Persona getPersonaId(String user) {
        ArrayList<Persona>listaPersona = selectPersonas();
        for (Persona p: listaPersona){
            if (p.getNick_Name().equals(user)){
                return p;
            }
        }
        return null;

    }







    //En construccion Sprint
    public String PersonaLogin( String nickname){
        String cadena = "";
        SQLiteDatabase bd = this.getWritableDatabase();
        Cursor cursor = bd.rawQuery("SELECT p.Nombre, p.Apellido, p.Correo, t.tipo_Titulo_Persona, p.edad FROM persona p INNER JOIN tipo_Persona t ON (p.Nick_Name= t.Nick_Name) WHERE p.Nick_Name='"+nickname+"' " , null);
        if (cursor.moveToFirst()){
            do{
                cadena = cursor.getString(0);
            }while (cursor.moveToNext());
        }
        return cadena;
    }

}