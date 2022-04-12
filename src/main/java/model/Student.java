package model;

import serviceproviders.StudentService;

import java.util.ArrayList;

public class Student {
    private String Naam;
    private Integer studentNummer;
    private Results results;


    public Student(String Naam, Integer studentNummer) {
        this.Naam = Naam;
        this.studentNummer = studentNummer;
    }

    public Student() {
    }

    public void setStudentNummer(Integer studentNummer) {
        this.studentNummer = studentNummer;
    }

    public void setNaam(String naam) {
        Naam = naam;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public String getNaam() {
        return Naam;
    }

    public int getStudentNumber() {
        return studentNummer;
    }
}


