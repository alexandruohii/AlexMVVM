package com.example.alexmvvm;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProdusDao {

    @Insert
    void add(Produs produs);

    @Update
    void update(Produs produs);

    @Delete
    void delete(Produs produs);

    @Query("DELETE FROM produse")
    void deleteProduse();

    @Query("SELECT * FROM produse ORDER BY pret DESC")
    LiveData<List<Produs>> getProduse();









}
