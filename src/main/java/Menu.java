import java.util.*;
class Menu {
    private static Examen examenMulti = new Examen("Topografie","Multiple Choice");
    private static Examen examenJaNee = new Examen("Verkeers Examen", "Ja/Nee");
    private static Examen examenOpen = new Examen("Topografie", "Open Vragen");


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
        //System.out.println("9) Examen toevoegen");
        System.out.println("0) Exit");
        System.out.print("Uw Keuze: ");

        Scanner scanner = new Scanner(System.in);
        Student awd = new Student("dwa", 1221);
        try{
            int keuze = scanner.nextInt();
            switch (keuze){
                case 1:
                    Menu.ListExams();
                    PrintMenu();
                    break;
                case 2:
                    awd.DisplayList();
                    Menu.PrintMenu();
                    break;
                case 3:
                    Student.addStudentNew();
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
                    chooseExam();
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
            System.out.println("Voer een getal in." +'\n');
            PrintMenu();
        }
        catch (Exception e){
            System.out.println("Er is iets onverwachts fout gegaan, probeer het opnieuw."+ '\n');
            PrintMenu();
        }
        System.out.println();
    }

    public static void ListExams(){
        System.out.println(examenMulti.toString());
        System.out.println(examenJaNee.toString());
        System.out.println(examenOpen.toString());
    }

    private void ListStudents(){

    }

    private void BestStudent(){

    }

    public static void chooseExam(){

        System.out.println("Welk examen wilt uw afnemen?");
        System.out.println("Examen 1: ");
        System.out.println(examenMulti.toString());
        System.out.println("Examen 2: ");
        System.out.println(examenJaNee.toString());
        System.out.println("Examen 3: ");
        System.out.println(examenOpen.toString());
        System.out.println("Voer 0 in om terug naar het menu te gaan.");

        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Voer een getal in:");
            int keuze = scanner.nextInt();
            switch (keuze){
                case 1:
                    examenMulti.toets();
                    PrintMenu();
                    break;
                case 2:
                    examenJaNee.toets();
                    PrintMenu();
                    break;
                case 3:
                    examenOpen.toetsOpen();
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
            System.out.println("Er is iets onverwachts fout gegaan, probeer het opnieuw.");
            System.out.println(" ");
            PrintMenu();
        }
        System.out.println();
    }
    public static void initializeList(){
        examenMulti.MultiVragen();
        examenMulti.setAantalVragen();
        examenJaNee.JaNeeVragen();
        examenJaNee.setAantalVragen();
        examenOpen.OpenVragen();
        examenOpen.setAantalVragen();

    }

}
