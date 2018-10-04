package fr.eni.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.eni.lokacar.bo.Vehicule;
import fr.eni.lokacar.dao.Connexion;
import fr.eni.lokacar.dao.TypeVehiculeDAO;
import fr.eni.lokacar.dao.VehiculeDAO;

public class CreerVehiculeActivity extends AppCompatActivity {

    private TextView modele ;
    private TextView marque;
    private TextView immatriculation;
    private TextView prix;
    private TextView nbrePlaces;
    private Spinner typeVehiculeSpinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_vehicule);
        initComponent();
        createListeTypeVehicule();


    }

    private void initComponent() {
        modele = findViewById(R.id.modele);
        marque = findViewById(R.id.marque);
        immatriculation = findViewById(R.id.immatriculation);
        prix = findViewById(R.id.prix);
        nbrePlaces = findViewById(R.id.nbrePlaces);
        typeVehiculeSpinner = findViewById(R.id.typeVehicule);

    }

    public void submitFormCreerVehicule(View view) {

        Vehicule vehicule = new Vehicule();


        vehicule.setMarque(marque.getText().toString());
        vehicule.setModele(modele.getText().toString());
        vehicule.setImmatriculation(immatriculation.getText().toString());
        vehicule.setPrix(Float.parseFloat(prix.getText().toString()));
        vehicule.setNbrePlaces(Integer.parseInt(nbrePlaces.getText().toString()));
        vehicule.setTypeVehicule_id(typeVehiculeSpinner.getSelectedItemPosition());

        long id = Connexion.getConnexion(this).vehiculeDAO().insert(vehicule);
        vehicule.setId_vehicule((int)id);


        Intent intent = new Intent(this,ListVehiculesActivity.class);
        startActivity(intent);
    }

    private void createListeTypeVehicule() {

        List typeList = TypeVehiculeDAO.getAll();

        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                typeList
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeVehiculeSpinner.setAdapter(adapter);
    }


    public void prendrePhoto(View view) {
    }
}
