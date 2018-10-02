package fr.eni.lokacar.bo;

public class Configuration {

        private boolean triDispo;

        private String immatriculation;

        private TypeVehicule typeVehicule;

    public Configuration() {
    }

    public Configuration(boolean triDispo, String immatriculation) {
        this.triDispo = triDispo;
        this.immatriculation = immatriculation;
    }

    public Configuration(boolean triDispo, String immatriculation, TypeVehicule typeVehicule) {
        this.triDispo = triDispo;
        this.immatriculation = immatriculation;
        this.typeVehicule = typeVehicule;
    }

    public boolean isTriDispo() {
        return triDispo;
    }

    public void setTriDispo(boolean triDispo) {
        this.triDispo = triDispo;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public TypeVehicule getTypeVehicule() {
        return typeVehicule;
    }

    public void setTypeVehicule(TypeVehicule typeVehicule) {
        this.typeVehicule = typeVehicule;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "triDispo=" + triDispo +
                ", immatriculation='" + immatriculation + '\'' +
                ", typeVehicule=" + typeVehicule +
                '}';
    }
}
