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
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import fr.eni.lokacar.bo.Client;
import fr.eni.lokacar.bo.Location;
import fr.eni.lokacar.dao.Connexion;

public class ResumeLocationActivity extends AppCompatActivity  implements DatePickerDialog.OnDateSetListener{

    private Calendar calendar;

    private TextView calculPrix ;
    private TextView dateEnd;
    private TextView dateStart;
    private TextView nom;
    private TextView prenom;
    private TextView modeleLoue;
    private TextView immatLoue;

    private Button picDateEnd;
    private Button picDateStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_location);
        initComponent();
    }


    private void initComponent() {
        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        dateStart = findViewById(R.id.dateStart);
        dateEnd = findViewById(R.id.dateEnd);
        calculPrix = findViewById(R.id.tvCalculPrix);
        modeleLoue = findViewById(R.id.modeleLoue);
        immatLoue = findViewById(R.id.immatLoue);
        picDateEnd = findViewById(R.id.picDateEnd);
        picDateStart = findViewById(R.id.picDateStart);
    }



    public void onClickRechercheClient(View view) {
        Intent intent = new Intent(this,ListClientActivity.class);
        startActivity(intent);
    }

    public void submitFormAjouterClient(View view) {
        Intent intent = new Intent(this,CreerClientActivity.class);
        startActivity(intent);
    }




    public void datePickerStart(View view) {
        ResumeLocationActivity.DatePickerStartFragment fragmentDateStart = new ResumeLocationActivity.DatePickerStartFragment();
        fragmentDateStart.show(getSupportFragmentManager(),"date");
    }


    public void datePickerFin(View view) {
        ResumeLocationActivity.DatePickerEndFragment fragmentDateEnd = new ResumeLocationActivity.DatePickerEndFragment();
        fragmentDateEnd.show(getSupportFragmentManager(),"date");
    }

    public void onClickValiderLocation(View view) {

//        Client client = new Client();
//        client.setNom(nom.getText().toString());
//        client.setPrenom(prenom.getText().toString());
//
//        Location location = new Location();
//        try {
//            location.setDateDepart(new SimpleDateFormat("dd/MM/yyyy").parse(dateStart.getText().toString()));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        try {
//            location.setDateRetourReel(new SimpleDateFormat("dd/MM/yyyy").parse(dateEnd.getText().toString()));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }




        // enregistrer en base une location avec un id ( qui reprend un id client et un id vehicule
       // long id = Connexion.getConnexion(this).locationDAO().insert(location);
       // location.setId_location((int)id);

        // ajouter méthode envoi du mail de confirmation



        //apres validation retour à écran liste des véhicules
        Intent intent = new Intent(this,ListVehiculesActivity.class);
        startActivity(intent);
    }

    public static class DatePickerStartFragment extends DialogFragment{

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

    public static class DatePickerEndFragment extends DialogFragment{
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



    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Calendar cal = new GregorianCalendar(year, month, day);
        setDateStart(cal);
        setDateEnd(cal);
    }

    private void setDateStart(final Calendar calendar) {
        DateFormat dateFormatStart = DateFormat.getDateInstance(DateFormat.MEDIUM);
        ((TextView) findViewById(R.id.dateStart)).setText(dateFormatStart.format(calendar.getTime()));

    }

    private void setDateEnd(final Calendar calendar) {

        DateFormat dateFormatEnd = DateFormat.getDateInstance(DateFormat.MEDIUM);
        ((TextView) findViewById(R.id.dateEnd)).setText(dateFormatEnd.format(calendar.getTime()));

    }


}
