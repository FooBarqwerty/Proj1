package serviceproviders;

import model.Examen;
import model.Results;
import model.Student;
import serviceproviders.DataService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import static model.Menu.PrintMenu;

public class ViewService {

    public static void printMenuOptions() {
        System.out.println(
                "1) Lijst met examens \n" +
                        "2) Lijst met studenten\n" +
                        "3) Nieuwe student inschrijven\n" +
                        "4) Student verwijderen\n" +
                        "5) Examen afnemen\n" +
                        "6) Is student geslaagd voor test?\n" +
                        "7) Welke examens heeft student gehaald?\n" +
                        "8) Welke student heeft de meeste examens gehaald?\n" +
                        "9) Inloggen (wisselen van student) \n" +
                        "0) Exit\n" +
                        "Uw Keuze: "
        );
    }
    public static void printChooseExamOptions(){
        System.out.println("Voer uw keuze in met een getal: ");
    }

    public static void ListExams() {
        for (int i = 0; i < DataService.getExamsArrayList().size(); i++) {
            System.out.println("Examen: " + (i + 1) + " \n" + DataService.getExamsArrayList().get(i).toString());
        }
    }

    public static void DisplayStudentList() {
        for (Student student : DataService.getStudentLijst()) {
            System.out.println("------------------------");
            System.out.print("Naam: ");
            System.out.println(student.getNaam());
            System.out.print("Studenten Nummer: ");
            System.out.println(student.getStudentNumber());
            System.out.println("------------------------");
        }
    }
    public static void displayCurrentStudent(){
        Scanner scanner = new Scanner(System.in);
        if (DataService.getCurrentStudent() == null){
            System.out.println("Er is iets fout gegaan, Voer uw studentennummer in:");
            int studentennummer = scanner.nextInt();
            DataService.setCurrentStudent(studentennummer);
        }
        System.out.println("------------------------\nWelkom: " + DataService.getCurrentStudent().getNaam() + "\nStudentennummer: " + DataService.getCurrentStudent().getStudentNumber());
    }

    public static void seeResultsLastTest(){
        if (DataService.getCurrentStudent().getLijstResults().size() == 0) {
            System.out.println("U heeft geen toetsen gemaakt.\n");
        }
        else {
            System.out.println(
                    "De resultaat van uw laatste gemaakt toets: \n\n" +
                            "Naam toets: " +
                            DataService.getCurrentStudent().getLijstResults().get(DataService.getCurrentStudent().getLijstResults().size() - 1).getExamenNaam() + " \n" +
                            "Aantal goede antwoorden: " +
                            DataService.getCurrentStudent().getLijstResults().get(DataService.getCurrentStudent().getLijstResults().size() - 1).getGoedeAntwoorden() + " \n"
            );
            if (DataService.getCurrentStudent().getLijstResults().get(DataService.getCurrentStudent().getLijstResults().size() - 1).getGeslaagd()) {
                System.out.println("U bent geslaagd. \n");
            } else {
                System.out.println("U bent niet geslaagd. \n");
            }
        }
    }
    public static void DisplayGeslaagdToets(){
        if (DataService.getCurrentStudent().getLijstResults().size() == 0) {
            System.out.println("U heeft geen toetsen gemaakt.\n");
        }
        else {
            System.out.println("Deze zijn de toetsen die u een voldoende voor heeft:");
            for (int index = 0; index < DataService.getCurrentStudent().getLijstResults().size(); index++) {
                if (DataService.getCurrentStudent().getLijstResults().get(index).getGeslaagd()) {
                    System.out.println(
                            "-------------------------\n" +
                                    "Naam toets: " +
                                    DataService.getCurrentStudent().getLijstResults().get(index).getExamenNaam() + " \n" +
                                    "Aantal goede antwoorden: " +
                                    DataService.getCurrentStudent().getLijstResults().get(index).getGoedeAntwoorden() + " \n" +
                                    "U bent geslaagd \n"
                    );
                }
            }
        }
    }
    public static void displayStudentRank(){
        ArrayList<Student> arrayListBestStudents = new ArrayList<>();
        int highScoreInt = 0;
        int studentScoreInt = 0;
        for (Student student:
                DataService.getStudentLijst()
        ) {

            for (Results results:
                    student.getLijstResults()
            ) {
                if (results.getGeslaagd()){
                    studentScoreInt++;
                }
            }

            if (studentScoreInt >= highScoreInt) {
                arrayListBestStudents.add(student);
                if (studentScoreInt > highScoreInt) {
                    arrayListBestStudents.clear();
                    arrayListBestStudents.add(student);
                    highScoreInt = studentScoreInt;
                }
                studentScoreInt=0;
            }
        }
        for (Student bestStudent:
                arrayListBestStudents) {
            System.out.println("Studenen Naam: " +bestStudent.getNaam() + "\nStudenten Nummer: " + bestStudent.getStudentNumber() +"\n");
        }
    }

}
   /* private static void printExamSelection(ArrayList... Exams) {
        System.out.println("Welk examen wilt uw afnemen?");
        ExamService.ListExams();
        for (int i = 0; i <= Exams.length; i++) {
            System.out.println("Examen " + i + " : ");

        };
        System.out.println("Voer 0 in om terug naar het menu te gaan.");
    }

}

    */

