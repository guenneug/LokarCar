package fr.eni.lokacar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private static String KEY_MDP = "mdp";
    private static String KEY_AGENCE = "nomAgence";
    private static String KEY_NOM_FICHIER = "fichierAgence";

    // UI references.
    private AutoCompleteTextView mAgencyView;
    private EditText mPasswordView;
    private EditText mConfirmPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private Button mbtnLogin;

    private Boolean creationAgence = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mAgencyView =  findViewById(R.id.agency);
        mbtnLogin = findViewById(R.id.btnLogin);

        mPasswordView = (EditText) findViewById(R.id.password);
        mConfirmPasswordView = (EditText) findViewById(R.id.confirmpassword);

        mLoginFormView = findViewById(R.id.login_form);


        SharedPreferences spIntra = this.getPreferences(MODE_PRIVATE);
        SharedPreferences spInter = this.getSharedPreferences(KEY_NOM_FICHIER,MODE_PRIVATE);
        if (spInter.contains(KEY_AGENCE)) {
            Toast.makeText(this, "Agence trouvee", Toast.LENGTH_SHORT).show();
            mAgencyView.setText(spIntra.getString(KEY_AGENCE, null));
            findViewById(R.id.tilConfirm).setVisibility(View.INVISIBLE);
            mbtnLogin.setText("Se Connecter");
        }else {
            creationAgence = true;
            mbtnLogin.setText("Creer Agence");
        }

    }


    private boolean isPasswordCorrect (String password){

        //Lire le fichier intra activité pour récuperer le mot de passe
        SharedPreferences spIntra = this.getPreferences(MODE_PRIVATE);
        String mdpintra =  spIntra.getString(KEY_MDP, null);

        Log.i("locakar: mdpstocké" , spIntra.getString(KEY_MDP, null));
        Log.i("locakar: mdptenté" , password);
        if (password.equals(mdpintra)) {
            return true;
        }
        return false;
    }

    public void connecterCreerAgence (View view){
        String mdp = mPasswordView.getText().toString();
        if (!creationAgence && isPasswordCorrect(mdp)) {
            Toast.makeText(this, "mdp ok", Toast.LENGTH_SHORT).show();
        }else if(!creationAgence && !isPasswordCorrect(mConfirmPasswordView.getText().toString())){
            Toast.makeText(this, "mauvais mdp", Toast.LENGTH_SHORT).show();
        }

        if(creationAgence){
            Toast.makeText(this, "Creation agence", Toast.LENGTH_SHORT).show();
            if (mPasswordView.getText().toString().equals(mConfirmPasswordView.getText().toString()))
            {
                //Enregistrer le mot de passe en  intra-activité
                SharedPreferences sp = this.getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editeur = sp.edit();
                editeur.putString(KEY_MDP,mPasswordView.getText().toString());
                editeur.commit();

                //Enregistrer le nom de l'agence en inter-activité
                SharedPreferences sp1 = this.getSharedPreferences(KEY_NOM_FICHIER,MODE_PRIVATE);
                SharedPreferences.Editor editeur1 = sp1.edit();
                editeur1.putString(KEY_AGENCE,mAgencyView.getText().toString());
                editeur1.commit();
            }
            else{
                Toast.makeText(this, "Mots de passe differents", Toast.LENGTH_SHORT).show();
            }
        }

        Intent intent = new Intent(this, ListVehiculesActivity.class);
        startActivity(intent);

    }

}




