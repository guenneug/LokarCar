package fr.eni.lokacar.bo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

import fr.eni.lokacar.dao.DateTypeConverter;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Client.class,
                                    parentColumns = "id_client",
                                    childColumns = "client_id",
                                    onDelete = CASCADE))
public class Location {

    @PrimaryKey
    private int locationID;

    @TypeConverters({DateTypeConverter.class})
    private Date dateDepart;
    @TypeConverters({DateTypeConverter.class})
    private Date dateRetourPrevu;
    @TypeConverters({DateTypeConverter.class})
    private Date dateRetourReel;
    private Float prix;
    private int client_id;
    private int vehicule_id;

    public Location(Date dateDepart, Date dateRetourPrevu, Float prix, int client_id, int vehicule_id) {
        this.dateDepart = dateDepart;
        this.dateRetourPrevu = dateRetourPrevu;
        this.prix = prix;
        this.client_id = client_id;
        this.vehicule_id = vehicule_id;
    }

    public Location() {
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateRetourPrevu() {
        return dateRetourPrevu;
    }

    public void setDateRetourPrevu(Date dateRetourPrevu) {
        this.dateRetourPrevu = dateRetourPrevu;
    }

    public Date getDateRetourReel() {
        return dateRetourReel;
    }

    public void setDateRetourReel(Date dateRetourReel) {
        this.dateRetourReel = dateRetourReel;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getVehicule_id() {
        return vehicule_id;
    }

    public void setVehicule_id(int vehicule_id) {
        this.vehicule_id = vehicule_id;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationID=" + locationID +
                ", dateDepart=" + dateDepart +
                ", dateRetourPrevu=" + dateRetourPrevu +
                ", dateRetourReel=" + dateRetourReel +
                ", prix=" + prix +
                ", client_id=" + client_id +
                ", vehicule_id=" + vehicule_id +
                '}';
    }
}
