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
/*
    public static int switchStudent(int studentNummer){
        for(int i = 0; i < StudentLijst.size(); i++) {
            if (studentNummer == StudentLijst.get(i).getStudentNumber()) {
                System.out.println(StudentLijst.get(i).getStudentNumber());
                return  StudentLijst.get(i).getStudentNumber();
            }
        }
        return 0;
    }
}

 */


