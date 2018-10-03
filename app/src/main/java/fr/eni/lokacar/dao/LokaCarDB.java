package fr.eni.lokacar.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import fr.eni.lokacar.bo.Client;
import fr.eni.lokacar.bo.Location;
import fr.eni.lokacar.bo.Photo;
import fr.eni.lokacar.bo.Vehicule;


@Database(entities = {Client.class, Location.class, Photo.class, Vehicule.class}, version = 4)
public abstract class LokaCarDB extends RoomDatabase {

    public static final String DATABASE_NAME = "LokaCarDB";

    public abstract ClientDAO clientDAO();

    public abstract LocationDAO locationDAO();

    public abstract PhotoDAO photoDAO();

    public abstract VehiculeDAO vehiculeDAO();
}
