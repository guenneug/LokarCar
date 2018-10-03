package fr.eni.lokacar.dao;

import android.arch.persistence.room.Room;
import android.content.Context;

public class Connexion {
    public static LokaCarDB getConnexion(Context context)
    {
        return Room.databaseBuilder(context,LokaCarDB.class,"maBDD").allowMainThreadQueries().build();
    }
}