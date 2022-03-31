package com.example.comicbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.comicbook.Adaptadores.ListaComicAdapter;
import com.example.comicbook.Modelo.Comic;
import com.example.comicbook.Modelo.DbHelper;
import com.example.comicbook.Utilidades.Utilidades;

import java.util.ArrayList;

public class Catalogo_Comic extends AppCompatActivity {


    ArrayList<Comic> listComic;
    RecyclerView recyclerView;


    DbHelper conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo_comic);
        conn = new DbHelper(Catalogo_Comic.this, "baseComicSql", null, 1);
        listComic = new ArrayList<>();
        recyclerView= (RecyclerView) findViewById(R.id.RecyclerViewComicMenu);
        recyclerView.setLayoutManager(new LinearLayoutManager(Catalogo_Comic.this));
        consultarComic();
        ListaComicAdapter adapter = new ListaComicAdapter(listComic);
        recyclerView.setAdapter(adapter);
    }


    protected void consultarComic(){
        SQLiteDatabase sqLiteDatabase = conn.getReadableDatabase();
        Comic comic = null;
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT c.Titulo_Comic, c.Editorial_Comic, c.Descripcion, t.Fecha_Publicacion, t.tipo_titulo_Comic FROM "+ Utilidades.TABLA_COMIC+"c INNER JOIN "+Utilidades.TABLA_TIPO_COMIC+"t ON (c.Serial_Comic=t.Serial_Comic)", null);

        while(cursor.moveToNext()){
            comic = new Comic();
            comic.setTitulo_Comic("Titulo Comic: "+cursor.getString(0));
            comic.setEditorial_Comic("Editorial: "+cursor.getString(1));
            comic.setDescripcion("Descripcion: "+cursor.getString(2));
            comic.setFecha_Publicacion("Fecha Publicacion: "+cursor.getString(3));
            comic.setTipo_comic("Tipo Comic: "+cursor.getString(4));

            listComic.add(comic);
        }

    }
}