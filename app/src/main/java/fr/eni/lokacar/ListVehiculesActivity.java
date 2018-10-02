package fr.eni.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fr.eni.lokacar.adapters.VehiculeAdapter;
import fr.eni.lokacar.bo.TypeVehicule;
import fr.eni.lokacar.bo.Vehicule;

public class ListVehiculesActivity extends AppCompatActivity implements VehiculeAdapter.ClickListenerVehicule {


    private Toolbar toolbar;
    private RecyclerView rvVehicules;
    private VehiculeAdapter vehiculeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vehicules);


        this.toolbar=this.findViewById(R.id.tb_ListVehicules);
        this.setSupportActionBar(toolbar);


        this.rvVehicules=this.findViewById(R.id.rv_Vehicules);
        this.rvVehicules.setHasFixedSize(true);

        List<Vehicule> vehicules = mockVehicules();

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


    /**
     * Bouchon Test
     * @return
     */
    public List<Vehicule> mockVehicules()
    {
        List<Vehicule> vehicules = new ArrayList<>();

        for (int i=1 ; i<=5 ; i++)
        {
            Vehicule vehicule = new Vehicule();
            vehicule.setModele("Modele "+i);
            vehicule.setImmatriculation("Immatriculation "+i);
            vehicule.setTypeVehicule(TypeVehicule.BERLINE);

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
        voitureCHR.setTypeVehicule(TypeVehicule.COUPE);
        voitureCHR.setLouee(true);

        Vehicule voitureCLA = new Vehicule();
        voitureCLA.setModele("Mustang");
        voitureCLA.setImmatriculation("Claude");
        voitureCLA.setTypeVehicule(TypeVehicule.CABRIOLET);
        voitureCLA.setLouee(false);

        Vehicule voitureLAU = new Vehicule();
        voitureLAU.setModele("C3");
        voitureLAU.setImmatriculation("Christophe");
        voitureLAU.setTypeVehicule(TypeVehicule.COUPE);
        voitureLAU.setLouee(false);

        vehicules.add(voitureCHR);
        vehicules.add(voitureCLA);
        vehicules.add(voitureLAU);


        return vehicules;

    }


}
