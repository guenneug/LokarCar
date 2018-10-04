package fr.eni.lokacar.dao;

import java.util.ArrayList;
import java.util.List;

public class TypeVehiculeDAO {

    public static String getType(int idType) {
        switch (idType) {

            case 0:
                return "";
            case 1:
                return "Berline";
            case 2:
                return "Break";
            case 3:
                return "Cabriolet";
            case 4:
                return "Coupé";
            case 5:
                return "Monospace";
            case 6:
                return "SUV";
            default:
                return "Type inconnu";

        }

    }

        public static List<String> getAll()
        {
            List <String> listeTypes = new ArrayList<>();

            listeTypes.add("");
            listeTypes.add("Berline");
            listeTypes.add("Break");
            listeTypes.add("Cabriolet");
            listeTypes.add("Coupé");
            listeTypes.add("Monospace");
            listeTypes.add("SUV");


            return listeTypes;
        }




    }



