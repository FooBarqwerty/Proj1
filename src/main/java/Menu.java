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
        System.out.println("0) Exit");
        System.out.println("Uw Keuze: ");

        Scanner scanner = new Scanner(System.in);
        try{
            int keuze = scanner.nextInt();
            switch (keuze){
                case 1:
                    //code
                    PrintMenu();
                    break;
                case 2:
                    PrintMenu();
                    break;
                case 3:
                    PrintMenu();
                    break;
                case 4:
                    PrintMenu();
                    break;
                case 5:
                    PrintMenu();
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
                case 0:
                    System.out.println("Bedankt dat uw gebruik maakt van onze programma! Een fijne studie gewenst!");;
                    break;
                default:
                    System.out.printf("Voer een correcte keuze in.","/n");
                    PrintMenu();
            }
        }
        catch (InputMismatchException e){
            System.out.println("Voer een getal in.");
            System.out.println("");
            PrintMenu();
        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("Er is iets onverwachts fout gegaan, probeer het opnieuw.");
            System.out.println("");
            PrintMenu();
        }

        System.out.print(" ");
    }

    private void ListExams(){

    }

    private void ListStudents(){

    }

    private void BestStudent(){

    }

}
