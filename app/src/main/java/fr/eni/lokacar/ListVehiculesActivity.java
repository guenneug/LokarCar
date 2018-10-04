package fr.eni.lokacar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fr.eni.lokacar.adapters.VehiculeAdapter;
import fr.eni.lokacar.bo.Configuration;
import fr.eni.lokacar.bo.Vehicule;
import fr.eni.lokacar.dao.BouchonVehiculeDAO;
import fr.eni.lokacar.dao.ConfigurationDAO;
import fr.eni.lokacar.dao.Connexion;

public class ListVehiculesActivity extends AppCompatActivity implements VehiculeAdapter.ClickListenerVehicule {

    private static String KEY_AGENCE = "nomAgence";
    private static String KEY_NOM_FICHIER = "fichierAgence";

    private static final String TAG = "CHRISTOPHE";
    private Toolbar toolbar;
    private RecyclerView rvVehicules;
    private VehiculeAdapter vehiculeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vehicules);


        this.toolbar=this.findViewById(R.id.tb_ListVehicules);
        SharedPreferences sp = this.getSharedPreferences(KEY_NOM_FICHIER,MODE_PRIVATE);
        String nomAgence = sp.getString(KEY_AGENCE,"Nom agence");

       this.toolbar.setTitle(nomAgence);

        this.setSupportActionBar(toolbar);


        this.rvVehicules=this.findViewById(R.id.rv_Vehicules);
        this.rvVehicules.setHasFixedSize(true);




    }


    @Override
    protected void onResume() {
        super.onResume();

        Configuration config = new ConfigurationDAO().lire(this);

        //List<Vehicule> vehicules = BouchonVehiculeDAO.selectAll(config.isTriDispo());

        List<Vehicule> vehicules = Connexion.getConnexion(this).vehiculeDAO().selectAll();



        this.vehiculeAdapter = new VehiculeAdapter(this);
        this.vehiculeAdapter.addVehicules(vehicules);
        this.rvVehicules.setAdapter(vehiculeAdapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_list_vehicules,menu);
        return true;


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.itemAdd:
                Intent intentAdd = new Intent(this, CreerVehiculeActivity.class);
                startActivity(intentAdd);
                return true;

            case R.id.itemConfig:
                Intent intentConfig = new Intent(this, ConfigurationActivity.class);
                startActivity(intentConfig);
                return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClickVehicule(Vehicule vehicule) {
        Toast.makeText(this, "Vous avez cliqué sur "+vehicule.getModele(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,DetailVehiculeActivity.class);
        intent.putExtra("vehicule",vehicule);
        startActivity(intent);

    }


}
