package fr.eni.lokacar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import fr.eni.lokacar.bo.Configuration;
import fr.eni.lokacar.bo.TypeVehicule;
import fr.eni.lokacar.dao.ConfigurationDAO;

public class ConfigurationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Switch switchDispo;

    private EditText etImmatriculation;

    private Spinner spin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        this.spin = this.findViewById(R.id.spinnerVehicules);
        spin.setOnItemSelectedListener(this);

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

    }

    @Override
    protected void onPause() {
        super.onPause();
        Configuration config = new Configuration(this.switchDispo.isChecked(),this.etImmatriculation.getText().toString());
        new ConfigurationDAO().enregistrer(this,config);
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
