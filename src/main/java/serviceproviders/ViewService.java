package serviceproviders;

import model.Examen;
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
                        "0) Exit\n" +
                        "Uw Keuze: "
        );
    }
    public static void printChooseExamOptions(){
        System.out.println("Voer uw keuze in met een getal: ");
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

