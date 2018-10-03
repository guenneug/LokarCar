package fr.eni.lokacar.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import fr.eni.lokacar.bo.Client;
import fr.eni.lokacar.bo.Vehicule;

@Dao
public interface ClientDAO extends GenericDAO<Client> {

    @Query("SELECT * FROM CLIENT")
    List<Client> selectAll();

    @Query("SELECT * FROM Client WHERE id_client = :id")
    Client findById(int id);

    @Query("DELETE FROM Client")
    void deleteAll();

    @Query(("SELECT * FROM Client WHERE nom LIKE :result OR prenom LIKE :result"))
    List<Client> findByName(String result);


}
