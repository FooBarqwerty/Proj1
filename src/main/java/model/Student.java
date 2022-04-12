package model;

import serviceproviders.StudentService;

import java.util.ArrayList;

public class Student {
    private String Naam;
    private Integer studentNummer;
    private ArrayList<Results> lijstResults = new ArrayList<>();


    public Student(String Naam, Integer studentNummer) {
        this.Naam = Naam;
        this.studentNummer = studentNummer;
    }

    public Student() {
    }

    public ArrayList<Results> getLijstResults() {
        return lijstResults;
    }

    public void setLijstResults(ArrayList<Results> lijstResults) {
        this.lijstResults = lijstResults;
    }

    public void setStudentNummer(Integer studentNummer) {
        this.studentNummer = studentNummer;
    }

    public void setNaam(String naam) {
        Naam = naam;
    }

    public void setResults(Results results) {
        this.lijstResults.add(results);
    }

    public String getNaam() {
        return Naam;
    }

    public int getStudentNumber() {
        return studentNummer;
    }

}


