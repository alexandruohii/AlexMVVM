package com.example.alexmvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ProdusViewModel extends AndroidViewModel {
    private ProdusRepository produsRepository;
    private LiveData<List<Produs>> toateProdusele;
    public ProdusViewModel(@NonNull Application application) {
        super(application);
        produsRepository = new ProdusRepository(application);
        toateProdusele = produsRepository.getProduse();
    }
    public void add(Produs produs) {
        produsRepository.add(produs);
    }
    public void update(Produs produs) {
        produsRepository.update(produs);
    }
    public void deleteprodus(Produs produs) {
        produsRepository.delete(produs);
    }
    public void deleteProduse() {
        produsRepository.deleteProduse();
    }
    public LiveData<List<Produs>> getProduse() {
        return toateProdusele;
    }
}
