package fr.eni.lokacar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import fr.eni.lokacar.bo.Photo;
import fr.eni.lokacar.bo.Vehicule;
import fr.eni.lokacar.dao.Connexion;
import fr.eni.lokacar.dao.TypeVehiculeDAO;

public class DetailVehiculeActivity extends AppCompatActivity {


    private TextView tv_type;

    private TextView tv_immatriculation;
    private TextView tv_marque;
    private TextView tv_modele;
    private TextView tv_nbPlaces;

    private TextView tv_prixJour;

    private ImageView iv_photo;

    private Vehicule vehicule;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_vehicule);

        vehicule = getIntent().getParcelableExtra("vehicule");
        initComponent();

        Photo photo = Connexion.getConnexion(this).photoDAO().findDescriptiveByVhId(vehicule.getId_vehicule());

        iv_photo = findViewById(R.id.imgVehicule);
        File imgFile = new  File(photo.getUri());
        if(imgFile.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            iv_photo.setImageBitmap(myBitmap);
        }else
        {
            Toast.makeText(this, "Photo non trouvée", Toast.LENGTH_SHORT).show();
            Log.i("LOKAKAR DETAIL VH" , "Photo de description non trouvée");
        }


        String typeVehicule = TypeVehiculeDAO.getType(vehicule.getTypeVehicule_id());

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



        intent.putExtra("vehicule", this.vehicule);
        startActivity(intent);
    }

    public void returnLocation(View view) {
        Intent intent = new Intent(this,ResumeLocationActivity.class);
        startActivity(intent);
    }
}
