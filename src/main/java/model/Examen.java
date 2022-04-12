package model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Examen {

    public String naam;
    private String TypeOfExam;
    private Integer aantalVragen;
    private Integer aantalVragenGoedVoldoende;
    private static Integer uniqueExamCode = 007 ;
    private Integer examCode;
    private ArrayList<Question> lijstVragen = new ArrayList<>();

    public Examen(String naam, String TypeOfExamen, int aantalVragenGoedVoldoende) {
        this.naam = naam;
        this.TypeOfExam = TypeOfExamen;
        this.aantalVragenGoedVoldoende = aantalVragenGoedVoldoende;
        examCode = setExamCode();
    }

    public void setAantalVragen() {
        this.aantalVragen = lijstVragen.size();
    }

    @Override
    public String toString() {
        return  "----------------------------------" + '\n' +
                "model.lijstVragen: " + naam + '\n' +
                "TypeOfExam= " + TypeOfExam + '\n' +
                "aantalVragen: " + aantalVragen + '\n'
                        + "----------------------------------" + '\n';
    }

    public ArrayList<Question> getLijstVragen() {
        return lijstVragen;
    }

    public void setQuestionLijstVragen(Question lijstVragen) {
        this.lijstVragen.add(lijstVragen);
    }

    public static Integer setExamCode() {
        Integer examenCode = uniqueExamCode;
        uniqueExamCode++;
        return examenCode;
    }

    public Integer getExamCode() {
        return examCode;
    }


    public Integer getAantalVragen() {
        return aantalVragen;
    }

    public Integer getAantalVragenGoedVoldoende() {
        return aantalVragenGoedVoldoende;
    }

    public static void examenToevoegen(){
        try {
            System.out.println("--------------------------");
            System.out.println("welkom bij het 'toevoegen Examens programma!'");
            System.out.println("Voer een optie in:");
            System.out.println("1.  model.lijstVragen toevoegen.");
            System.out.println("2.  Opslaan en terug naar de menu. (Exit)");

            Scanner scanner = new Scanner(System.in);
            int keuze = scanner.nextInt();
            switch (keuze) {
                case 1:
                    Menu.PrintMenu();
                    break;
                case 2:
                    //model.Menu.PrintMenu();
                    break;
                default:
                    //testQuestion();
                    break;
            }
        }
        catch (Exception e) {
            System.out.println("Er is iets gebeurt. Probeer het opnieuw.");
            //methode terug?
            Menu.PrintMenu();
        }
    }
}
