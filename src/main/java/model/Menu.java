package model;

import serviceproviders.DataService;
import serviceproviders.ExamService;
import serviceproviders.StudentService;
import serviceproviders.ViewService;

import java.util.*;

public class Menu {

    private static int currentStudent;


    public static void PrintMenu(){
        ViewService.printMenuOptions();
        Scanner scanner = new Scanner(System.in);
        try{
            int keuze = scanner.nextInt();
            switch (keuze){
                case 1:
                    ExamService.ListExams();
                    PrintMenu();
                    break;
                case 2:
                    DataService.DisplayStudentList();
                    Menu.PrintMenu();
                    break;
                case 3:
                    DataService.addNewStudent();
                    currentStudent = DataService.CurrentStudentNumber();
                    Menu.PrintMenu();
                    break;
                case 4:
                    StudentService.removeStudent();
                    PrintMenu();
                    break;
                case 5:
                    DataService.getExamsArrayList();
                    ViewService.chooseExam();
                    break;
                case 6:
                    DataService.seeResultsLastTest();
                    PrintMenu();
                    break;
                case 7:
                    DataService.DisplayGeslaagdToets();
                    PrintMenu();
                    break;
                case 8:
                    DataService.displayStudentRank();
                    PrintMenu();
                    break;
                case 9:
                    Examen.examenToevoegen();
                    break;
                    case 0:
                    System.out.println("Bedankt dat uw gebruik maakt van onze programma! Een fijne studie gewenst!");
                    System.exit(0); // 0 for successful termination, 0 >for unsuccessful termination (What does it mean?)
                    break;
                default:
                    System.out.println("Voer een correcte keuze in.");
                    PrintMenu();
            }
        }
        catch (InputMismatchException e){
            System.out.println("Voer een getal in." +'\n');
            PrintMenu();
        }
        catch (Exception e){
            System.out.println("Er is iets onverwachts fout gegaan, probeer het opnieuw."+ '\n');
            PrintMenu();
        }
        System.out.println();
    }



    public static int getCurrentStudent() {
        return currentStudent;
    }


    private void BestStudent() {

    }


}
