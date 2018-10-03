package fr.eni.lokacar.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.content.Context;

import java.util.List;

import fr.eni.lokacar.bo.Client;

@Dao
public interface ClientDAO extends GenericDAO<Client> {

   @Insert
   public long insert(Client entity) ;

   @Insert
   public long[] insert(List<Client> entities) ;

   @Delete
   public void delete(Client entity);

   @Update
   public void update(Client entity);
}
