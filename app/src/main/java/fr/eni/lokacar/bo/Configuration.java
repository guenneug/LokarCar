package fr.eni.lokacar.bo;

public class Configuration {

        private boolean triDispo;

        private String immatriculation;

        private int positionSpinner;

    public Configuration() {
    }

    public Configuration(boolean triDispo, String immatriculation, int positionSpinner) {
        this.triDispo = triDispo;
        this.immatriculation = immatriculation;
        this.positionSpinner = positionSpinner;
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

    public int getPositionSpinner() {
        return positionSpinner;
    }

    public void setPositionSpinner(int positionSpinner) {
        this.positionSpinner = positionSpinner;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "triDispo=" + triDispo +
                ", immatriculation='" + immatriculation + '\'' +
                ", positionSpinner=" + positionSpinner +
                '}';
    }
}
