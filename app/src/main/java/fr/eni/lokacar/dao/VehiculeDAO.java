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

    @Query("SELECT * FROM Vehicule WHERE louee = :IsDispo AND typeVehicule_id = :typeId")
    List<Vehicule> selectAll(boolean IsDispo, int typeId);

    @Query("SELECT * FROM Vehicule WHERE louee = :IsDispo")
    List<Vehicule> selectAll(boolean IsDispo);

    @Query("SELECT * FROM Vehicule WHERE immatriculation = :imma")
    Vehicule selectByImma(String imma);
}
