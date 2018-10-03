package fr.eni.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import fr.eni.lokacar.bo.Configuration;
import fr.eni.lokacar.dao.ConfigurationDAO;

public class ConfigurationActivity extends AppCompatActivity  {

    private Switch switchDispo;
    private EditText etImmatriculation;
    private Spinner spin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        this.spin = this.findViewById(R.id.spinnerVehicules);


        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,getTableauTypesVehicules());
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setAdapter(aa);


        this.switchDispo=this.findViewById(R.id.swDispo);
        this.etImmatriculation=this.findViewById(R.id.etRechercheImma);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Configuration config = new ConfigurationDAO().lire(this);
        this.switchDispo.setChecked(config.isTriDispo());
        this.etImmatriculation.setText(config.getImmatriculation()!=null?config.getImmatriculation():"DEFAULT");
        this.spin.setSelection(config.getPositionSpinner());

    }

    @Override
    protected void onPause() {
        super.onPause();

       int position = getPositionSelectionee();

        Configuration config = new Configuration(this.switchDispo.isChecked(),this.etImmatriculation.getText().toString(), position);
        new ConfigurationDAO().enregistrer(this,config);
    }

    public int getPositionSelectionee()
    {
        String type = this.spin.getSelectedItem().toString();

        int position=0;

        String [] tableau = getTableauTypesVehicules();

        for (int i=0 ; i<tableau.length ; i++)
        {
            if (tableau[i].equals(type))
            {
                position=i;
            }
        }
        return position;
    }

    public String [] getTableauTypesVehicules()
    {
     String [] types = new String[7];

        types[0] = "";
        types[1] = "Berline";
        types[2] = "Break";
        types[3] = "Cabriolet";
        types[4] = "Coupé";
        types[5] = "Monospace";
        types[6] = "SUV";

        return types;
    }


    public void onClickRechercheImmatriculation(View view) {


        String immatriculation = this.etImmatriculation.getText().toString();

        Log.i("CHRISTOPHE",immatriculation);

        Intent intent = new Intent(this,DetailVehiculeActivity.class);

    }


}
