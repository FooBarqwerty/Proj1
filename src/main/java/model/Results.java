package model;

import serviceproviders.DataService;

public class    Results {
    private String examenNaam;
    private int goedeAntwoorden;
    private int aantalVragenGoedVoldoende;
    private Boolean geslaagd;

    public Results(String examenNaam, int goedeAntwoorden, int aantalVragenGoedVoldoende) {
        this.examenNaam = examenNaam;
        this.goedeAntwoorden = goedeAntwoorden;
        this.aantalVragenGoedVoldoende = aantalVragenGoedVoldoende;
        setGeslaagd(this.geslaagd);
    }

    public void setGeslaagd(Boolean geslaagd) {
        if (goedeAntwoorden >= aantalVragenGoedVoldoende)
            this.geslaagd = true;
        else {
            this.geslaagd = false;
        }
    }

    public Boolean getGeslaagd() {
        return geslaagd;
    }

    public String getExamenNaam() {
        return examenNaam;
    }

    public int getGoedeAntwoorden() {
        return goedeAntwoorden;
    }

    public int getAantalVragenGoedVoldoende() {
        return aantalVragenGoedVoldoende;
    }

    @Override
    public String toString() {
        return "Uw toets resultaten: \n" +
                "Toets naam: " + examenNaam + '\n' +
                "Aantal Goede Antwoorden = " + goedeAntwoorden + '\n' +
                "" + geslaagd +
                '}';
    }
}


