package fr.eni.lokacar.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import java.util.List;

import fr.eni.lokacar.bo.Photo;

@Dao
public interface PhotoDAO extends GenericDAO<Photo>{


}
