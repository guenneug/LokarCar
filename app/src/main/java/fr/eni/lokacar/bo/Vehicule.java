package fr.eni.lokacar.bo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity
public class Vehicule implements Parcelable{

    @PrimaryKey(autoGenerate = true)
    private int id_vehicule;

    private float prix;
    private String immatriculation;
    private boolean louee;
    private int nbrePlaces;
    private String marque;
    private String modele;
    TypeVehicule typeVehicule;

    public Vehicule() {
    }

    public Vehicule(int id_vehicule, float prix, String immatriculation, boolean louee, int nbrePlaces, String marque, String modele, TypeVehicule typeVehicule) {
        this.id_vehicule = id_vehicule;
        this.prix = prix;
        this.immatriculation = immatriculation;
        this.louee = louee;
        this.nbrePlaces = nbrePlaces;
        this.marque = marque;
        this.modele = modele;
        this.typeVehicule = typeVehicule;
    }

    protected Vehicule(Parcel in) {
        id_vehicule = in.readInt();
        prix = in.readFloat();
        immatriculation = in.readString();
        louee = in.readByte() != 0;
        nbrePlaces = in.readInt();
        marque = in.readString();
        modele = in.readString();
    }

    public static final Creator<Vehicule> CREATOR = new Creator<Vehicule>() {
        @Override
        public Vehicule createFromParcel(Parcel in) {
            return new Vehicule(in);
        }

        @Override
        public Vehicule[] newArray(int size) {
            return new Vehicule[size];
        }
    };

    public int getId_vehicule() {
        return id_vehicule;
    }

    public void setId_vehicule(int id_vehicule) {
        this.id_vehicule = id_vehicule;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public boolean isLouee() {
        return louee;
    }

    public void setLouee(boolean louee) {
        this.louee = louee;
    }

    public int getNbrePlaces() {
        return nbrePlaces;
    }

    public void setNbrePlaces(int nbrePlaces) {
        this.nbrePlaces = nbrePlaces;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public TypeVehicule getTypeVehicule() {
        return typeVehicule;
    }

    public void setTypeVehicule(TypeVehicule typeVehicule) {
        this.typeVehicule = typeVehicule;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id_vehicule);
        parcel.writeFloat(prix);
        parcel.writeString(immatriculation);
        parcel.writeByte((byte) (louee ? 1 : 0));
        parcel.writeInt(nbrePlaces);
        parcel.writeString(marque);
        parcel.writeString(modele);
    }
}
