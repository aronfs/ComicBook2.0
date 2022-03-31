package com.example.comicbook.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comicbook.Modelo.Comic;
import com.example.comicbook.R;

import java.util.ArrayList;

public class ListaComicAdapter extends RecyclerView.Adapter<ListaComicAdapter.ViewHolderDatos> {

    ArrayList <Comic> ListaComic;

    public ListaComicAdapter(ArrayList<Comic> listaComic) {
        ListaComic = listaComic;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_comic, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.txtTituloComic.setText(ListaComic.get(position).getTitulo_Comic());
        holder.DescripcionComic.setText(ListaComic.get(position).getDescripcion());
        holder.txtEditorialComic.setText(ListaComic.get(position).getEditorial_Comic());
        holder.txtFechaComic.setText(ListaComic.get(position).getFecha_Publicacion());
        holder.txtTipoComic.setText(ListaComic.get(position).getTipo_comic());
    }

    @Override
    public int getItemCount() {
        return ListaComic.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView txtTituloComic, DescripcionComic, txtEditorialComic, txtFechaComic, txtTipoComic;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            txtTituloComic = itemView.findViewById(R.id.txtTituloComicMenu);
            DescripcionComic = itemView.findViewById(R.id.txtDescripcionComic);
            txtEditorialComic = itemView.findViewById(R.id.txtEditorialComicMenu);
            txtFechaComic = itemView.findViewById(R.id.txtGeneroComicMenu);
            txtTipoComic = itemView.findViewById(R.id.txtTipoComicMenu);
        }
    }







}