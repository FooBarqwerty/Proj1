package model;

import serviceproviders.DataService;
import serviceproviders.ExamService;
import serviceproviders.ViewService;

import java.util.*;

public class Menu {

    public static void PrintMenu(){
        DataService.displayCurrentStudent();
        ViewService.printMenuOptions();
        Scanner scanner = new Scanner(System.in);
        try{
            int keuze = scanner.nextInt();
            switch (keuze){
                case 1:
                    System.out.println("\nLijst met toetsen:");
                    ExamService.ListExams();
                    PrintMenu();
                    break;
                case 2:
                    System.out.println("\nLijst met Studenten:");
                    DataService.DisplayStudentList();
                    Menu.PrintMenu();
                    break;
                case 3:
                    DataService.addNewStudent();
                    //DataService.setLastStudent();
                    System.out.println("Student toegevoegd \n");
                    DataService.setCurrentStudent(DataService.getStudentLijst().get(DataService.getStudentLijst().size()-1).getStudentNumber());
                    Menu.PrintMenu();
                    break;
                case 4:
                    System.out.print("\n------------------------\nVoer de studenten nummer die uw wilt verwijderen: ");
                    int verwijderenStudent = scanner.nextInt();
                    DataService.removeStudent(verwijderenStudent);
                    PrintMenu();
                    break;
                case 5:
                    DataService.getExamsArrayList();
                    Menu.chooseExam();
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
                    System.out.println("\nVoer het studentnummer van het student waar naar u wilt schakelen:\nVoer 0 (nul) in als uw terug wilt gaan.");
                    int input = scanner.nextInt();
                    DataService.setCurrentStudent(input);
                    Menu.PrintMenu();
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
    public static void chooseExam() {
        ExamService.ListExams();
        ViewService.printChooseExamOptions();
        Scanner scanner = new Scanner(System.in);
        try {
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
    public static void displayLogIn(){
        System.out.print("Voer de studentennummer waar mee u wilt inloggen\nOf creeer een nieuw student.\n1) Inloggen\n2) Nieuwe student inschrijven\n3) Lijst met studenten");
        Scanner scanner = new Scanner(System.in);
        try {
            int keuze = scanner.nextInt();
            switch (keuze) {
                case 1:
                    System.out.println("\nVoer het studentnummer van het student waarmee u wilt inloggen:\nVoer 0 (nul) in als uw terug wilt gaan.\n");
                    DataService.setCurrentStudent(scanner.nextInt());
                    break;
                case 2:
                    DataService.addNewStudent();
                    DataService.setCurrentStudent(DataService.getStudentLijst().get(DataService.getStudentLijst().size()-1).getStudentNumber());
                    System.out.println("Student toegevoegd \n");
                    break;
                case 3:
                    System.out.println("\nLijst met Studenten:");
                    DataService.DisplayStudentList();
                    displayLogIn();
                case 0:
                    displayLogIn();
                    break;
                default:
                    System.out.println("\nVoer een correcte keuze in.\n");
                    displayLogIn();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("\nVoer een getal in.\n");
            displayLogIn();
        } catch (Exception e) {
            System.out.println("Er is iets onverwachts fout gegaan, probeer het opnieuw. \n");
            displayLogIn();
        }
    }
}
