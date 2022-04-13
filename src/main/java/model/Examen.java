package model;

import java.util.ArrayList;

public class Examen {

    public String naam;
    private String TypeOfExam;
    private Integer aantalVragen;
    private Integer aantalVragenGoedVoldoende;
    private ArrayList<Question> lijstVragen = new ArrayList<>();

    public Examen(String naam, String TypeOfExamen, int aantalVragenGoedVoldoende) {
        this.naam = naam;
        this.TypeOfExam = TypeOfExamen;
        this.aantalVragenGoedVoldoende = aantalVragenGoedVoldoende;
    }

    public String getNaam() {
        return naam;
    }

    public Integer getAantalVragen() {
        return aantalVragen;
    }

    public void setAantalVragen() {
        this.aantalVragen = lijstVragen.size();
    }

    public ArrayList<Question> getLijstVragen() {
        return lijstVragen;
    }

    public void setQuestionLijstVragen(Question lijstVragen) {
        this.lijstVragen.add(lijstVragen);
    }

    public Integer getAantalVragenGoedVoldoende() {
        return aantalVragenGoedVoldoende;
    }

    @Override
    public String toString() {
        return  "----------------------------------" + '\n' +
                "Naam examen: " + naam + '\n' +
                "Soort toets: " + TypeOfExam + '\n' +
                "Aantal vragen: " + aantalVragen + '\n' +
                "----------------------------------" + '\n';
    }
}
