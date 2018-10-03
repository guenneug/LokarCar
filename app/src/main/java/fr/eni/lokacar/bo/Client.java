package fr.eni.lokacar.bo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

import fr.eni.lokacar.dao.DateTypeConverter;

@Entity
public class Client implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id_client;
    @ColumnInfo(name="NOM")
    private String nom;
    @ColumnInfo(name="PRENOM")
    private String prenom;
    private String adresse;
    private String codePostal;
    private String ville;
    private String tel;
    private String email;
    private String numeroPermis;
    @TypeConverters({DateTypeConverter.class})
    private Date dateNaissance;


    public Client() {
    }

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Client(int id_client, String nom, String prenom) {
        this.id_client = id_client;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Client(int id_client, String nom, String prenom, String adresse, String codePostal, String ville, String tel, String email, String numeroPermis, Date dateNaissance) {
        this.id_client = id_client;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.tel = tel;
        this.email = email;
        this.numeroPermis = numeroPermis;
        this.dateNaissance = dateNaissance;
    }

    protected Client(Parcel in) {
        id_client = in.readInt();
        nom = in.readString();
        prenom = in.readString();
        adresse = in.readString();
        codePostal = in.readString();
        ville = in.readString();
        tel = in.readString();
        email = in.readString();
        numeroPermis = in.readString();
        dateNaissance = new Date(in.readLong());
    }

    public static final Creator<Client> CREATOR = new Creator<Client>() {
        @Override
        public Client createFromParcel(Parcel in) {
            return new Client(in);
        }

        @Override
        public Client[] newArray(int size) {
            return new Client[size];
        }
    };

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroPermis() {
        return numeroPermis;
    }

    public void setNumeroPermis(String numeroPermis) {
        this.numeroPermis = numeroPermis;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id_client=" + id_client +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", numeroPermis='" + numeroPermis + '\'' +
                ", dateNaissance=" + dateNaissance +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id_client);
        parcel.writeString(nom);
        parcel.writeString(prenom);
        parcel.writeString(adresse);
        parcel.writeString(codePostal);
        parcel.writeString(ville);
        parcel.writeString(tel);
        parcel.writeString(email);
        parcel.writeString(numeroPermis);
        parcel.writeLong(dateNaissance.getTime());
    }
}
