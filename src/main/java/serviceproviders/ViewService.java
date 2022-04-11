package serviceproviders;

import model.Examen;
import model.Student;
import serviceproviders.DataService;

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
    public static void chooseExam(){

        printExamSelection();


        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Voer een getal in:");
            int keuze = scanner.nextInt();
            switch (keuze){
                case 1:
                    //examenMulti.toets();
                    PrintMenu();
                    break;
                case 2:
                    //examenJaNee.toets();
                    PrintMenu();
                    break;
                case 3:
                    //examenOpen.toetsOpen();
                    PrintMenu();
                    break;
                case 0:
                    PrintMenu();
                    break;
                default:
                    System.out.println("Voer een correcte keuze in.");
                    chooseExam();
            }
        }
        catch (InputMismatchException e){
            System.out.println("Voer een getal in.");
            System.out.println(" ");
            chooseExam();
        }
        catch (Exception e){
            System.out.println("Er is iets onverwachts fout gegaan, probeer het opnieuw. \n   ");

            PrintMenu();
        }
        System.out.println();
    }

    private static void printExamSelection(Examen... Exams) {
        System.out.println("Welk examen wilt uw afnemen?");
        for (int i = 0; i <= Exams.length; i++) {
            System.out.println("Examen " + i + " : ");

        };
        System.out.println("Voer 0 in om terug naar het menu te gaan.");
    }

}