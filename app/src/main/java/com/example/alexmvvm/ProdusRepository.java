package com.example.alexmvvm;

import android.app.Application;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;

import java.util.List;


public class ProdusRepository {

    private ProdusDao produsDao;
    private LiveData<List<Produs>> toateProdusele;

    public ProdusRepository(Application application) {
        ProdusDatabase produsDatabase = ProdusDatabase.getSession(application);
        produsDao = produsDatabase.produsDao();
        toateProdusele = produsDao.getProduse();
    }
    public void add(Produs produs) {
        new AddProdusAsyncTask(produsDao).execute(produs);
    }
    public void update(Produs produs) {
        new UpdateProdusAsyncTask(produsDao).execute(produs);
    }
    public void delete(Produs produs) {
        new DeleteProdusAsyncTask(produsDao).execute(produs);
    }
    public void deleteProduse() {
       new DeleteProduseAsyncTask(produsDao).execute();
    }
    public LiveData<List<Produs>> getProduse() {
        return toateProdusele;
    }


    private static class AddProdusAsyncTask extends AsyncTask<Produs, Void, Void> {
        private ProdusDao produsDao;
        private AddProdusAsyncTask(ProdusDao produsDao) {
            this.produsDao = produsDao;
        }
        @Override
        protected Void doInBackground(Produs... produse) {
            produsDao.add(produse[0]);
            return null;
        }
    }
    private static class UpdateProdusAsyncTask extends AsyncTask<Produs, Void, Void> {
        private ProdusDao produsDao;
        private UpdateProdusAsyncTask(ProdusDao produsDao) {
            this.produsDao = produsDao;
        }
        @Override
        protected Void doInBackground(Produs... produse) {
            produsDao.update(produse[0]);
            return null;
        }
    }
    private static class DeleteProdusAsyncTask extends AsyncTask<Produs, Void, Void> {
        private ProdusDao produsDao;
        private DeleteProdusAsyncTask(ProdusDao produsDao) {
            this.produsDao = produsDao;
        }
        @Override
        protected Void doInBackground(Produs... produse) {
            produsDao.delete(produse[0]);
            return null;
        }
    }
    private static class DeleteProduseAsyncTask extends AsyncTask<Void, Void, Void> {
        private ProdusDao produsDao;
        private DeleteProduseAsyncTask(ProdusDao produsDao) {
            this.produsDao = produsDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            produsDao.deleteProduse();
            return null;
        }
    }


}
