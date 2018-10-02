package fr.eni.lokacar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import fr.eni.lokacar.bo.TypeVehicule;

public class ConfigurationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        Spinner spin = this.findViewById(R.id.spinnerVehicules);
        spin.setOnItemSelectedListener(this);



        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,getTableauTypesVehicules());
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);



    }


    public String [] getTableauTypesVehicules()
    {
     String [] types = new String[6];

        types[0] = TypeVehicule.BERLINE.toString();
        types[1] = TypeVehicule.BREAK.toString();
        types[2] = TypeVehicule.CABRIOLET.toString();
        types[3] = TypeVehicule.COUPE.toString();
        types[4] = TypeVehicule.MONOSPACE.toString();
        types[5] = TypeVehicule.SUV.toString();

        return types;
    }


    public void onClickRechercheImmatriculation(View view) {
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
