package fr.eni.lokacar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import fr.eni.lokacar.bo.Photo;
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
    private ImageView ivApercu;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    String localImageFilePath;



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
        ivApercu = findViewById(R.id.ivApercu);


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

        Photo photoPresentation = new Photo();
        photoPresentation.setDatePriseDeVue(new Date());
        photoPresentation.setUri(localImageFilePath);
        photoPresentation.setDescriptive(true);
        photoPresentation.setVehicule_id(vehicule.getId_vehicule());
        Connexion.getConnexion(this).photoDAO().insert(photoPresentation);

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

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photo = null;
            try {
                photo = createImageFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Uri uriToUpload = FileProvider.getUriForFile(CreerVehiculeActivity.this,
                    "fr.eni.lokacar.fileprovider",
                    photo);
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriToUpload);
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    private File createImageFile() throws IOException {
        String timeStamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss",
                        Locale.getDefault()).format(new Date());
        String imageFileName = "IMG_" + timeStamp + "_";
        File storageDir =
                getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = null;
        try {
            image = File.createTempFile(
                    imageFileName,  /* prefix */
                    ".jpg",         /* suffix */
                    storageDir      /* directory */
            );
            localImageFilePath = image.getAbsolutePath();
            Log.i("LOKAKAR IMG PATH: " , localImageFilePath);
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void enregistrerImageEnBase() {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode)
        {
            case REQUEST_IMAGE_CAPTURE:
                Bitmap imageBitmap = BitmapFactory.decodeFile(this.localImageFilePath);
                ivApercu.setImageBitmap(imageBitmap);
                break;
            default:
                super.onActivityResult(requestCode,resultCode,data);
        }

    }

}
