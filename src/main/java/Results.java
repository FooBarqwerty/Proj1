public class Results {
    private int totaalVragen;
    private int goedeVragen;
    private Boolean geslaagd;
    private static double geslaagdPercentage = 0.55;

    public Results(int totaalVragen, int goedeVragen, Boolean geslaagd) {
        this.totaalVragen = totaalVragen;
        this.goedeVragen = goedeVragen;
        this.geslaagd = geslaagd;
    }

    public Boolean getGeslaagd() {
        return geslaagd;
    }

    public void setGeslaagd(Boolean geslaagd) {
        this.geslaagd = geslaagd;
    }

    public void Results(Boolean Geslaagd){

    }
}


