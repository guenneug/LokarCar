package fr.eni.lokacar.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import fr.eni.lokacar.bo.Photo;

@Dao
public interface PhotoDAO extends GenericDAO<Photo>{


    @Query("SELECT * FROM Photo WHERE vehicule_id = :id AND descriptive")
    Photo findDescriptiveByVhId(long id);

}
