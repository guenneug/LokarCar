package fr.eni.lokacar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fr.eni.lokacar.adapters.VehiculeAdapter;
import fr.eni.lokacar.bo.Vehicule;

public class ListVehiculesActivity extends AppCompatActivity {

    private RecyclerView rvVehicules;
    private VehiculeAdapter vehiculeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vehicules);

        this.rvVehicules=this.findViewById(R.id.rv_Vehicules);
        this.rvVehicules.setHasFixedSize(true);

        List<Vehicule> vehicules = mockVehicules();

        this.vehiculeAdapter = new VehiculeAdapter();
        this.vehiculeAdapter.addVehicules(vehicules);
        this.rvVehicules.setAdapter(vehiculeAdapter);


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
            vehicules.add(vehicule);

        }

        return vehicules;

    }




}
