package fr.eni.lokacar.bo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Client.class,
                                    parentColumns = "id_client",
                                    childColumns = "client_id",
                                    onDelete = CASCADE))
public class Location {

    @PrimaryKey
    private int locationID;

    private Date dateDepart;
    private Date dateRetourPrevu;
    private Date dateRetourReel;
    private Double prix;
    private int client_id;

}
