package fr.eni.lokacar.dao;

import android.arch.persistence.room.Dao;
import android.content.Context;

import fr.eni.lokacar.bo.Client;

@Dao
public class ClientDAO  {

    public ClientDAO(Context context) {
    }

    public long insert(Client client) {
        return 0;
    }
}
