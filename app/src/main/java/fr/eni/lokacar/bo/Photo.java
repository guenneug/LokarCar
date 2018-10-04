package fr.eni.lokacar.bo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

import fr.eni.lokacar.dao.DateTypeConverter;

@Entity
public class Photo {


    @PrimaryKey(autoGenerate = true)
    private long id_photo;

    private String uri;
    @TypeConverters({DateTypeConverter.class})
    private Date datePriseDeVue;
    private Boolean descriptive;
    private long vehicule_id;


    public Photo() {

    }

    public Photo(String uri, Date datePriseDeVue, Boolean descriptive, long vehicule_id) {
        this.uri = uri;
        this.datePriseDeVue = datePriseDeVue;
        this.descriptive = descriptive;
        this.vehicule_id = vehicule_id;
    }

    public long getId_photo() {
        return id_photo;
    }

    public void setId_photo(long id_photo) {
        this.id_photo = id_photo;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Date getDatePriseDeVue() {
        return datePriseDeVue;
    }

    public void setDatePriseDeVue(Date datePriseDeVue) {
        this.datePriseDeVue = datePriseDeVue;
    }

    public Boolean getDescriptive() {
        return descriptive;
    }

    public void setDescriptive(Boolean descriptive) {
        this.descriptive = descriptive;
    }

    public long getVehicule_id() {
        return vehicule_id;
    }

    public void setVehicule_id(long vehicule_id) {
        this.vehicule_id = vehicule_id;
    }
}
