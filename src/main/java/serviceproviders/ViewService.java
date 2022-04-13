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
                        "9) Inloggen \n" +
                        "0) Exit\n" +
                        "Uw Keuze: "
        );
    }

    public static void chooseExam() {
        ExamService.ListExams();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Voer uw keuze in met een getal: ");
            int keuze = scanner.nextInt();
            switch (keuze) {
                case 1:
                    ExamService.toets(DataService.getExamsArrayList().get(keuze-1));
                    PrintMenu();
                    break;
                case 2:
                    ExamService.toets(DataService.getExamsArrayList().get(keuze-1));
                    PrintMenu();
                    break;
                case 3:
                    ExamService.toetsOpen(DataService.getExamsArrayList().get(keuze-1));
                    PrintMenu();
                    break;
                case 0:
                    PrintMenu();
                    break;
                default:
                    System.out.println("\nVoer een correcte keuze in.\n");
                    chooseExam();
            }
        } catch (InputMismatchException e) {
            System.out.println("\nVoer een getal in.\n");
            chooseExam();
        } catch (Exception e) {
            System.out.println("Er is iets onverwachts fout gegaan, probeer het opnieuw. \n");
            PrintMenu();
        }
        System.out.println();
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

