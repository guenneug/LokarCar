package fr.eni.lokacar;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import fr.eni.lokacar.bo.Client;
import fr.eni.lokacar.dao.ClientDAO;


public class DetailsClientActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{


    private Calendar calendar;

    private TextView nom ;
    private TextView prenom;
    private TextView adresse;
    private TextView codePostal;
    private TextView ville;
    private TextView tel;
    private TextView email;
    private TextView numeroPermis;
    private Button picDateNaissance;
    private TextView dateNaissance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_client);
        initComponent();




    }

    private void initComponent() {
        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        adresse = findViewById(R.id.adresse);
        codePostal = findViewById(R.id.codePostal);
        ville = findViewById(R.id.ville);
        tel = findViewById(R.id.ville);
        email = findViewById(R.id.email);
        numeroPermis = findViewById(R.id.permis);
        picDateNaissance = findViewById(R.id.picDateNaissance);
        dateNaissance = findViewById(R.id.dateNaissance);
    }


    public void submitForm(View view) {

        //ClientDAO clientDAO = new ClientDAO(this);

        Client client = new Client();
        client.setNom(nom.getText().toString());
        client.setPrenom(prenom.getText().toString());
        client.setAdresse(adresse.getText().toString());
        client.setCodePostal(codePostal.getText().toString());
        client.setVille(ville.getText().toString());
        client.setTel(tel.getText().toString());
        client.setEmail(email.getText().toString());
        client.setNumeroPermis(numeroPermis.getText().toString());
        try {
            client.setDateNaissance(new SimpleDateFormat("dd/MM/yyyy").parse(dateNaissance.getText().toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //long id = clientDAO.insert(client);
        //client.setId_client((int)id);

        Intent intent = new Intent(this,ResumeLocationActivity.class);
        startActivity(intent);
    }


    /*********************/



    /**
     * Create a DatePickerFragment class that extends DialogFragment.
     * Define the onCreateDialog() method to return an instance of DatePickerDialog
     */
    public static class DatePickerFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(),
                    (DatePickerDialog.OnDateSetListener)
                            getActivity(), year, month, day);
        }

    }
    /**
     * To receive a callback when the user sets the date.
     * @param view
     * @param year
     * @param month
     * @param day
     */
    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Calendar cal = new GregorianCalendar(year, month, day);
        setDate(cal);
    }
    /**
     * To set date on TextView
     * @param calendar
     */
    private void setDate(final Calendar calendar) {
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        ((TextView) findViewById(R.id.dateNaissance)).setText(dateFormat.format(calendar.getTime()));

    }

    /**
     * This callback method, call DatePickerFragment class,
     * DatePickerFragment class returns calendar view.
     * @param view
     */
    public void datePicker(View view) {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(),"date");
    }

}
