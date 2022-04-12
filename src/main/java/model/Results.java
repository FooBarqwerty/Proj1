package model;

public class Results {
    private int examCode;
    private int goedeAntwoorden;
    private int aantalVragenGoedVoldoende;
    private int studentNumber;
    private Boolean geslaagd;

    public Results(int examCode, int goedeAntwoorden, int aantalVragenGoedVoldoende, int studentNumber) {
        this.examCode = examCode;
        this.goedeAntwoorden = goedeAntwoorden;
        this.aantalVragenGoedVoldoende = aantalVragenGoedVoldoende;
        this.studentNumber = studentNumber;
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

    @Override
    public String toString() {
        return "Results{" +
                "examCode='" + examCode + '\'' +
                ", goedeAntwoorden=" + goedeAntwoorden +
                ", studentNumber=" + studentNumber +
                ", geslaagd=" + geslaagd +
                '}';
    }
}


