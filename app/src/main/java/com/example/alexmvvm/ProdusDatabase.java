package com.example.alexmvvm;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Produs.class}, version = 1)
public abstract class ProdusDatabase extends RoomDatabase {

    private static ProdusDatabase session;

     public abstract ProdusDao produsDao();

    public static synchronized ProdusDatabase getSession(Context context) {
        if (session == null) {
            session = Room.databaseBuilder(context.getApplicationContext(),
                    ProdusDatabase.class,"produsDatabase")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return session;
    }


    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(session).execute();
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private ProdusDao produsDao;
        private PopulateDbAsyncTask(ProdusDatabase database) {
            produsDao = database.produsDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            produsDao.add(new Produs("Samsung Galaxy A71", "Telefon mobil Samsung Galaxy A71, Dual SIM", 1664.1));
            produsDao.add(new Produs("Samsung 43RU7092", "Televizor LED Smart Samsung, 108 cm", 1399.99));
            produsDao.add(new Produs("Lenovo Ideapad S145-15IGM", "Laptop Lenovo Ideapad S145-15IGM cu procesor Intel Celeron N4000", 11099.99));
            return null;
        }
    }
}
