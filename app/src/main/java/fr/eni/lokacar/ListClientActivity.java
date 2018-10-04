package fr.eni.lokacar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import fr.eni.lokacar.adapters.ClientAdapter;
import fr.eni.lokacar.bo.Client;
import fr.eni.lokacar.bo.Vehicule;
import fr.eni.lokacar.dao.Connexion;

public class ListClientActivity extends AppCompatActivity implements ClientAdapter.ClickListenerClient{

    private static String KEY_AGENCE = "nomAgence";
    private static String KEY_NOM_FICHIER = "fichierAgence";

    private static final String TAG = "CHRISTOPHE";

    private android.support.v7.widget.Toolbar toolbar;
    private RecyclerView recyclerView;
    private EditText etSearchClient;
    private ClientAdapter clientAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_client);

        initComponent();

    }


    public void initComponent()
    {
        this.toolbar = findViewById(R.id.tb_ListClients);
        SharedPreferences sp = this.getSharedPreferences(KEY_NOM_FICHIER,MODE_PRIVATE);
        String nomAgence = sp.getString(KEY_AGENCE,"Nom agence");
        this.toolbar.setTitle(nomAgence);
        this.setSupportActionBar(toolbar);

        this.recyclerView= findViewById(R.id.rv_clients);
        recyclerView.setHasFixedSize(true);

        this.etSearchClient=findViewById(R.id.etRechercheClient);



    }

    @Override
    protected void onResume() {
        super.onResume();

        List<Client> clients = new ArrayList<>();

        if(this.etSearchClient == null || this.etSearchClient.getText().toString().length() == 0)
        {
            clients = Connexion.getConnexion(this).clientDAO().selectAll();

        }

        this.clientAdapter = new ClientAdapter(this);

        this.clientAdapter.addClients(clients);
        this.recyclerView.setAdapter(clientAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_list_clients,menu);
        return true;


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.itemAddClient:
                Intent intentAdd = new Intent(this, CreerClientActivity.class);
                startActivity(intentAdd);
                return true;

        }


        return super.onOptionsItemSelected(item);
    }

    public void onClickSearchClient(View view) {

        List<Client> clientsRecherches = new ArrayList<>();

        String recherche = etSearchClient.getText().toString();

        Log.i(TAG,"Recherche : "+recherche);

        clientsRecherches=Connexion.getConnexion(this).clientDAO().findByName(recherche);
        this.clientAdapter = new ClientAdapter(this);

        this.clientAdapter.addClients(clientsRecherches);
        this.recyclerView.setAdapter(clientAdapter);

    }

    @Override
    public void onClickClient(Client client) {

        Intent intent = new Intent(this, ResumeLocationActivity.class);
        intent.putExtra("client", client);
        startActivity(intent);
    }
}
