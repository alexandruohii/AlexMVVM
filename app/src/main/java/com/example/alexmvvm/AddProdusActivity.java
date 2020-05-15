package com.example.alexmvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class AddProdusActivity extends AppCompatActivity{

    public static final String A_TITLU =
            "com.example.alexmvvm.A_TITLU";
    public static final String A_DESCRIERE =
            "com.example.alexmvvm.A_DESCRIERE";
    public static final String A_PRET =
            "com.example.alexmvvm.A_PRET";

    private EditText editTextTitlu;
    private EditText editTextDescriere;
    private EditText editTextPret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_produs);

        editTextTitlu= findViewById(R.id.edit_text_titlu);
        editTextDescriere = findViewById(R.id.edit_text_descriere);
        editTextPret = findViewById(R.id.text_view_pret);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Adauga Produs");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_produs_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_produs:
                saveProdus();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void saveProdus() {
        String titlu = editTextTitlu.getText().toString();
        String descriere = editTextDescriere.getText().toString();
        String pret = editTextPret.getText().toString();
        if (titlu.trim().isEmpty() || descriere.trim().isEmpty()) {
            Toast.makeText(this, "Introdu titlu si descriere", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(A_TITLU, titlu);
        data.putExtra(A_DESCRIERE, descriere);
        data.putExtra(A_PRET, pret);
        setResult(RESULT_OK, data);
        finish();
    }

}
