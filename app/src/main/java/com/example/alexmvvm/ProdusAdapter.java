package com.example.alexmvvm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProdusAdapter extends RecyclerView.Adapter<ProdusAdapter.ProdusHolder> {

    private List<Produs> produse = new ArrayList<>();

    @NonNull
    @Override
    public ProdusHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.produs_item, parent, false);
        return new ProdusHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdusHolder produsHolder, int position) {
        Produs produsCurent = produse.get(position);
        produsHolder.textViewTitlu.setText(produsCurent.getTitlu());
        produsHolder.textViewDescriere.setText(produsCurent.getDescriere());
        produsHolder.textViewPret.setText(String.valueOf(produsCurent.getPret()));
    }

    @Override
    public int getItemCount() {
        return produse.size();
    }

    public void setProduse(List<Produs> produse) {
        this.produse = produse;
        notifyDataSetChanged();
    }

    class ProdusHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitlu;
        private TextView textViewDescriere;
        private TextView textViewPret;

        public ProdusHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitlu = itemView.findViewById(R.id.text_view_titlu);
            textViewDescriere = itemView.findViewById(R.id.edit_text_descriere);
            textViewPret = itemView.findViewById(R.id.text_view_pret);
        }
    }

}
