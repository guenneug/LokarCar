package fr.eni.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ResumeLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_location);
    }

    public void onClickRechercheClient(View view) {
    }

    public void submitFormAjouterClient(View view) {
        Intent intent = new Intent(this,DetailsClientActivity.class);
        startActivity(intent);
    }
}
