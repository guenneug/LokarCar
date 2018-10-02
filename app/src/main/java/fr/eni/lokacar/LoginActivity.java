package fr.eni.lokacar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
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
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {


    // UI references.
    private AutoCompleteTextView mAgencyView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private Button mbtnLogin;

    private Boolean creationAgence = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mAgencyView = (AutoCompleteTextView) findViewById(R.id.agency);
        populateAutoComplete();

        mPasswordView = (EditText) findViewById(R.id.password);


        mbtnLogin = (Button) findViewById(R.id.btnLogin);

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }


    private void populateAutoComplete() {
        //Lire le fichier intra activité pour retrouver le nom de l'agence
        SharedPreferences spIntra = this.getPreferences(MODE_PRIVATE);
        mAgencyView.setText(spIntra.getString("nomAgenceIntra", "Nom de l agence"));

        if (mAgencyView.getText().toString() == "Nom de l agence") {
            mbtnLogin.setText("Creer Agence");
        }



    }

    private boolean isPasswordCorrect (String password){
        //Lire le fichier intra activité pour récuperer le mot de passe
        SharedPreferences spIntra = this.getPreferences(MODE_PRIVATE);
        spIntra.getString("MdpIntra", "none");

        if (mAgencyView.getText().toString() == "Mot de passe") {
            mbtnLogin.setText("Creer Agence");
            return true;
        }
        return false;
    }
    public void connecterCreerAgence (View view){
        if (!creationAgence) {

        }
    }

}




