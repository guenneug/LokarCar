package fr.eni.lokacar.dao;

import java.util.ArrayList;
import java.util.List;

public class TypeVehiculeDAO {

    public static String getType(int idType) {
        switch (idType) {

            case 0:
                return "Berline";
            case 1:
                return "Break";
            case 2:
                return "Cabriolet";
            case 3:
                return "Coupé";
            case 4:
                return "Monospace";
            case 5:
                return "SUV";
            default:
                return "Type inconnu";

        }

    }

        public static List<String> getAll()
        {
            List <String> listeTypes = new ArrayList<>();

            listeTypes.add("Berline");
            listeTypes.add("Break");
            listeTypes.add("Cabriolet");
            listeTypes.add("Coupé");
            listeTypes.add("Monospace");
            listeTypes.add("SUV");


            return listeTypes;
        }




    }



