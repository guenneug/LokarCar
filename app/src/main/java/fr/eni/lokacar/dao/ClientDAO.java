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


}
