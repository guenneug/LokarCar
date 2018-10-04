package fr.eni.lokacar.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Date;

import fr.eni.lokacar.bo.Location;
import fr.eni.lokacar.dao.Connexion;

public class LocationService extends Service {

    private static final String TAG = "SERVICE_THIERRY";
    private locationBinder mpb = new locationBinder();
    private Location locationCourante;

    public LocationService() {

    }


    /*
     * Le paramètre intent contient l'intent passé en paramètre au niveau
     * de la méthode bindService de l'activity
     * */
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind");
        return mpb;
    }

    /*
     * Permet de faire en sorte que la méthode onServiceDisconnected de l'activity
     * soit appelée
     * */
    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate service");
    }

    /*
     * Le paramètre intent contient l'intent passé en paramètre au niveau
     * de la méthode startService de l'activity
     * */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    private Location donneAMoiLocation() {
        Log.i(TAG, "Je suis le service et je te file la location en cours");
        return locationCourante;
    }

    private void creeUneLocation(long vehiculeId) {
        Log.i(TAG, "Je suis le service et je te file la location en cours");
        locationCourante = new Location();
        locationCourante.setVehicule_id(vehiculeId);
    }

    private void ajouteCeClientALaLocation(long clientId) {
        locationCourante.setClient_id(clientId);
    }

    private void ajouteCesDetailsALaLocation(Date dateDebut, Date dateFin) {
        locationCourante.setDateDepart(dateDebut);
        locationCourante.setDateRetourPrevu(dateFin);
    }

    private void validerLaLocation() {
        Connexion.getConnexion(this).locationDAO().insert(locationCourante);
    }


    //Mon IBinder permettant de faire le pont entre l'activity et le service
    public class locationBinder extends Binder {
        public LocationService getService() {
            return LocationService.this;
        }

        public Location passeMoiLaLocation() {
            return LocationService.this.donneAMoiLocation();
        }

        public void enregistreCeClient(long clientId) {
            LocationService.this.ajouteCeClientALaLocation(clientId);
        }

        public void creeUneLocationAvecCeVehicule(long vehiculeId) {
            LocationService.this.creeUneLocation(vehiculeId);
        }

        public void ajouterDatesALaLocation(Date dateDepart, Date dateRestitutionPrevue) {
            LocationService.this.ajouteCesDetailsALaLocation(dateDepart, dateRestitutionPrevue);
        }

        public void valideLaLocation() {
            LocationService.this.validerLaLocation();
        }

    }

}


