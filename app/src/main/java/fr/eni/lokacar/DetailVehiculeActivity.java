package fr.eni.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import fr.eni.lokacar.bo.Vehicule;
import fr.eni.lokacar.dao.TypeVehiculeDAO;

public class DetailVehiculeActivity extends AppCompatActivity {


    private TextView tv_type;

    private TextView tv_immatriculation;
    private TextView tv_marque;
    private TextView tv_modele;
    private TextView tv_nbPlaces;

    private TextView tv_prixJour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_vehicule);

        Vehicule vehicule = getIntent().getParcelableExtra("vehicule");
        initComponent();

        String typeVehicule = TypeVehiculeDAO.getType(vehicule.getId_vehicule());

        tv_type.setText(typeVehicule);
        tv_immatriculation.setText(vehicule.getImmatriculation());
        tv_marque.setText(vehicule.getMarque());
        tv_modele.setText(vehicule.getModele());
        tv_nbPlaces.setText(String.valueOf(vehicule.getNbrePlaces()));
        tv_prixJour.setText(String.valueOf(vehicule.getPrix())+" €");


    }

    private void initComponent() {

        this.tv_marque=findViewById(R.id.tvD_marque);
        this.tv_modele=findViewById(R.id.tvD_modele);
        this.tv_type=findViewById(R.id.tvD_type);
        this.tv_immatriculation=findViewById(R.id.tvD_immatriculation);
        this.tv_nbPlaces=findViewById(R.id.tvD_nbPlaces);
        this.tv_prixJour=findViewById(R.id.tvD_prixJ);
    }

    public void createLocation(View view) {
        Intent intent = new Intent(this,ResumeLocationActivity.class);
        startActivity(intent);
    }

    public void returnLocation(View view) {
        Intent intent = new Intent(this,ResumeLocationActivity.class);
        startActivity(intent);
    }
}
