import java.util.*;
class Menu {

    public static void PrintMenu(){
        System.out.println("1) Lijst met examens");
        System.out.println("2) Lijst met studenten");
        System.out.println("3) Nieuwe student inschrijven");
        System.out.println("4) Student verwijderen");
        System.out.println("5) Examen afnemen");
        System.out.println("6) Is student geslaagd voor test?");
        System.out.println("7) Welke examens heeft student gehaald?");
        System.out.println("8) Welke student heeft de meeste examens gehaald?");
        //Reserved 9 for method for adding new exams
        System.out.println("9) Examen toevoegen");
        System.out.println("0) Exit");
        System.out.print("Uw Keuze: ");

        Scanner scanner = new Scanner(System.in);
        Student awd = new Student("dwa", 1221);
        try{
            int keuze = scanner.nextInt();
            switch (keuze){
                case 1:
                    //code

                    break;
                case 2:
                    awd.DisplayList();
                    Menu.PrintMenu();
                    break;
                case 3:
                    awd.NieuweStudent();
                    Menu.PrintMenu();
                    PrintMenu();
                    break;
                case 4:
                    Scanner scanner2 = new Scanner(System.in);
                    int rmv = scanner2.nextInt();
                    awd.removeStudent(rmv);
                    PrintMenu();
                    break;
                case 5:
                    Examen examen1 = new Examen("Topografie","Multiple Choice");
                    examen1.spel();
                    break;
                case 6:
                    PrintMenu();
                    break;
                case 7:
                    PrintMenu();
                    break;
                case 8:
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
            System.out.println("Voer een getal in.");
            System.out.println(" ");
            PrintMenu();
        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("Er is iets onverwachts fout gegaan, probeer het opnieuw.");
            System.out.println(" ");
            PrintMenu();
        }
        System.out.println();
    }

    private void ListExams(){

    }

    private void ListStudents(){

    }

    private void BestStudent(){

    }

}
