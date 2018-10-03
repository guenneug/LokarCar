package fr.eni.lokacar.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import java.util.List;

import fr.eni.lokacar.bo.Photo;

@Dao
public interface PhotoDAO extends GenericDAO<Photo>{

    @Insert
    public long insert(Photo entity) ;

    @Insert
    public long[] insert(List<Photo> entities) ;

    @Delete
    public void delete(Photo entity) ;

    @Update
    public void update(Photo entity) ;
}
