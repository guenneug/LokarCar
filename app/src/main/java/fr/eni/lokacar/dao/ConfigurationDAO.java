package fr.eni.lokacar.dao;

import android.content.Context;
import android.content.SharedPreferences;

import fr.eni.lokacar.ConfigurationActivity;
import fr.eni.lokacar.bo.Configuration;

public class ConfigurationDAO {


    private static final String nomFichier="configuration";
    private static final String triDispo="triDispo";
    private static final String immaParDefaut="immaParDefaut";


    public void enregistrer(Context context, Configuration config) {

        SharedPreferences sp = context.getSharedPreferences(nomFichier, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(triDispo, config.isTriDispo());
        editor.putString(immaParDefaut,config.getImmatriculation());
        editor.commit();



    }


    public Configuration lire(Context context) {

        Configuration config = new Configuration();
        SharedPreferences sp = context.getSharedPreferences(nomFichier,Context.MODE_PRIVATE);
        config.setImmatriculation(sp.getString(immaParDefaut,"VIDE"));
        config.setTriDispo(sp.getBoolean(triDispo,false));
        return config;

    }




}
