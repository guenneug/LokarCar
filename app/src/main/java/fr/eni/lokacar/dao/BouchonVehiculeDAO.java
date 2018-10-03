package fr.eni.lokacar.dao;

import java.util.ArrayList;
import java.util.List;

import fr.eni.lokacar.bo.Vehicule;

public class BouchonVehiculeDAO {




    public static List<Vehicule> selectAll(boolean IsDispo) {


        List<Vehicule> vehicules = new ArrayList<>();

        for (int i=1 ; i<=5 ; i++)
        {
            Vehicule vehicule = new Vehicule();
            vehicule.setModele("Modele "+i);
            vehicule.setImmatriculation("Immatriculation "+i);
            vehicule.setTypeVehicule_id(1);

            if (i%2==0)
            {
                vehicule.setLouee(false);
            }else
            {
                vehicule.setLouee(true);
            }

            vehicules.add(vehicule);

        }

        Vehicule voitureCHR = new Vehicule();
        voitureCHR.setModele("206");
        voitureCHR.setImmatriculation("Christophe");
        voitureCHR.setTypeVehicule_id(4);
        voitureCHR.setLouee(true);

        Vehicule voitureCLA = new Vehicule();
        voitureCLA.setModele("Mustang");
        voitureCLA.setImmatriculation("Claude");
        voitureCLA.setTypeVehicule_id(3);
        voitureCLA.setLouee(false);

        Vehicule voitureLAU = new Vehicule();
        voitureLAU.setModele("C3");
        voitureLAU.setImmatriculation("Christophe");
        voitureLAU.setTypeVehicule_id(4);
        voitureLAU.setLouee(false);

        vehicules.add(voitureCHR);
        vehicules.add(voitureCLA);
        vehicules.add(voitureLAU);

        List <Vehicule> vehiculesDispo = new ArrayList<>();

        for (Vehicule v : vehicules)
        {
            if (!v.isLouee())
            {
                vehiculesDispo.add(v);
            }

        }

        if (IsDispo)
        {
            return vehiculesDispo;
        }
        else
        {
            return vehicules;
        }

    }
}
