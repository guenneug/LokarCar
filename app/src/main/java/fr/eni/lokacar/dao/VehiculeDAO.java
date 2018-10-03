package fr.eni.lokacar.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.Update;

import java.util.Date;
import java.util.List;

import fr.eni.lokacar.bo.Vehicule;

@Dao
public interface VehiculeDAO extends GenericDAO<Vehicule> {

    @Insert
    public long insert(Vehicule entity);

    @Insert
    public long[] insert(List<Vehicule> entities) ;

    @Delete
    public void delete(Vehicule entity) ;

    @Update
    public void update(Vehicule entity) ;
}
