package fr.eni.lokacar.bo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity
//@ForeignKey(entity = Client.class,parentColumns = "id_client",childColumns = "id_client"))
public class Location {

    @PrimaryKey
    private int locationID;

    private Date dateDepart;
    private Date dateRetourPrevu;
    private Date dateRetourReel;
    private Double prix;

    private int id_client;

}
