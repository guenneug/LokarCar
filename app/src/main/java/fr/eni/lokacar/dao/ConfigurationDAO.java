package fr.eni.lokacar.dao;

import android.content.Context;
import android.content.SharedPreferences;

import fr.eni.lokacar.bo.Configuration;

public class ConfigurationDAO {


    private static final String nomFichier="configuration";
    private static final String triDispo="triDispo";
    private static final String immaParDefaut="immaParDefaut";
    private static final String typeVehicule="typeVehicule";


    public void enregistrer(Context context, Configuration config) {

        SharedPreferences sp = context.getSharedPreferences(nomFichier, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(triDispo, config.isTriDispo());
        editor.putString(immaParDefaut,config.getImmatriculation());
        editor.putInt(typeVehicule,config.getPositionSpinner());
        editor.commit();



    }


    public Configuration lire(Context context) {

        Configuration config = new Configuration();
        SharedPreferences sp = context.getSharedPreferences(nomFichier,Context.MODE_PRIVATE);
        config.setImmatriculation(sp.getString(immaParDefaut,"recherche"));
        config.setTriDispo(sp.getBoolean(triDispo,false));
        config.setPositionSpinner(sp.getInt(typeVehicule,0));
        return config;

    }




}
