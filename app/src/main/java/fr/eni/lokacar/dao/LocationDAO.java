package fr.eni.lokacar.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import fr.eni.lokacar.bo.Location;

@Dao
 public interface LocationDAO extends GenericDAO<Location>{

      @Insert
    public long insert(Location entity);

   @Insert
    public long[] insert(List<Location> entities) ;

   @Delete
    public void delete(Location entity) ;

   @Update
    public void update(Location entity) ;
}
