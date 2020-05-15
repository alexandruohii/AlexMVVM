package com.example.alexmvvm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ProdusViewModel produsViewModel;
    public static final int ADD_REQUEST_PRODUS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton buttonAddProdus = findViewById(R.id.button_add_produs);
        buttonAddProdus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddProdusActivity.class);
                startActivityForResult(intent, ADD_REQUEST_PRODUS);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

       final ProdusAdapter produsAdapter = new ProdusAdapter();
        recyclerView.setAdapter(produsAdapter);

        produsViewModel = new ViewModelProvider(this).get(ProdusViewModel.class);
        produsViewModel.getProduse().observe(this, new Observer<List<Produs>>() {
            @Override
            public void onChanged(List<Produs> produse) {
            //   produse.add(new Produs("Samsung Galaxy A71", "Telefon mobil Samsung Galaxy A71, Dual SIM", 1664.1));
                produsAdapter.setProduse(produse);
                Toast.makeText(MainActivity.this,"onChanged"+produse.size(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_REQUEST_PRODUS && resultCode == RESULT_OK) {
            String titlu = data.getStringExtra(AddProdusActivity.A_TITLU);
            String descriere = data.getStringExtra(AddProdusActivity.A_DESCRIERE);
            double pret = data.getDoubleExtra(AddProdusActivity.A_PRET, 1);
            Produs produs = new Produs(titlu, descriere, pret);
            produsViewModel.add(produs);
            Toast.makeText(this, "Produs salvat", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Produs nesalvat", Toast.LENGTH_SHORT).show();
        }
    }
}
