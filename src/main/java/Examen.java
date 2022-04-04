import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Examen {

    public final String naam;
    private String TypeOfExam;
    private Integer aantalVragen;
    private ArrayList<Question> lijstVragen = new ArrayList<Question>();


    private static ArrayList<Examen> LijstExamen;

    public Examen(String naam, String TypeOfExamen) {

        this.naam = naam;
        this.TypeOfExam = TypeOfExamen;

    }

    public static void examenToevoegen(){
        try {
            System.out.println("--------------------------");
            System.out.println("welkom bij het 'toevoegen Examens programma!'");
            System.out.println("Voer een optie in:");
            System.out.println("1.  Examen toevoegen.");
            System.out.println("2.  Opslaan en terug naar de menu. (Exit)");

            Scanner scanner = new Scanner(System.in);
            int keuze = scanner.nextInt();
            switch (keuze) {
                case 1:
                    Menu.PrintMenu();
                    break;
                case 2:
                    Menu.PrintMenu();
                    break;
                default:
                    //testQuestion();
                    break;
            }
        }
        catch (Exception e) {
            System.out.println(e);
            //methode terug???
            Menu.PrintMenu();
        }
    }
    public void testQuestion() {
        //Plaatsen wij question objects in
        // Om vragen doortegeven aan de Question.java construtor en de vraag, met vragenArrayList en String Correcte_antwoord in een ArrayList lijstVragen te zetten
        String vraag = "Beste stad?";
        String [] antwoorden = {"Amsterdam",  "Den Haag", "Amstelveen","Hertog Jan"};
        String correct_answer = antwoorden [0];
        lijstVragen.add(new Question(vraag, antwoorden, correct_answer)); // met String correct_answer als juiste antwoord

        vraag = "Beste Stad?";
        antwoorden = new String[] {"Heineken",  "Papaya", "Goedkoopste bier","Hertog Jan"};
        correct_answer = antwoorden [0];
        lijstVragen.add(new Question(vraag, antwoorden, correct_answer)); // met String correct_answer als juiste antwoord

        vraag = "Beste bier?";
        antwoorden = new String[] {"Heineken",  "Papaya", "Goedkoopste bier","Hertog Jan"};
        correct_answer = antwoorden [0];
        lijstVragen.add(new Question(vraag, antwoorden, correct_answer)); // met String correct_answer als juiste antwoord

        vraag = "Beste man?";
        antwoorden = new String[] {"Heineken",  "Papaya", "Goedkoopste bier","Hertog Jan"};
        correct_answer = antwoorden [0];
        lijstVragen.add(new Question(vraag, antwoorden, correct_answer)); // met String correct_answer als juiste antwoord

        vraag = "Beste koffie?";
        antwoorden = new String[] {"Heineken",  "Papaya", "Goedkoopste bier","Hertog Jan"};
        correct_answer = antwoorden [0];
        lijstVragen.add(new Question(vraag, antwoorden, correct_answer)); // met String correct_answer als juiste antwoord

        vraag = "Ben jij de beste wow?";
        antwoorden = new String[] {"True",  "False"};
        correct_answer = antwoorden [0];
        lijstVragen.add(new Question(vraag, antwoorden, correct_answer)); // met String correct_answer als juiste antwoord

        //Shuffle vragen. Antwoorden zijn al geshuffeled.
        //Collections.shuffle(lijstVragen);

    }
    public void spel () {
        testQuestion();
        Scanner scanner = new Scanner(System.in);
        int goede_antwoorden = 0;

        //for loop voor elke vraag uit  ArrayList lijstVragen.
        try {
            for (int vraag = 0; vraag < lijstVragen.size(); vraag++) {
                //print vraag
                System.out.println(lijstVragen.get(vraag).getQuestion());
                //voor mogelijke waar/niet waar vragen, multi-vragen. Open vragen komen in een andere methode.
                int aantalAntwoorden = lijstVragen.get(vraag).getAnswers().size();

                //for loop print antwoorden van vraag.
                for (int antwoord_in_ArrayList = 0; antwoord_in_ArrayList < aantalAntwoorden; antwoord_in_ArrayList++) {
                    System.out.println("Antwoord " + (antwoord_in_ArrayList + 1) + ": " + lijstVragen.get(vraag).getAnswers().get(antwoord_in_ArrayList));
                }

                //correcte vraag wordt in een string en int gezet
                String correcteAntwoord = lijstVragen.get(vraag).getCorrect_answer();
                System.out.println("Correcte vraag: " + correcteAntwoord);
                int correcteAntwoordInt = correcteAntwoord.indexOf(correcteAntwoord);

                //gebruiker moet nu getal invoeren als antwoord op vraag.
                int gegevenAntwoordInt = scanner.nextInt();

                if (gegevenAntwoordInt == correcteAntwoordInt + 1) {
                    goede_antwoorden++;
                    System.out.println("Goed!");
                } else {
                    System.out.println("Fout!");
                }
            }
        }
        catch (InputMismatchException geenGetal) {
            System.out.println(geenGetal);
            System.out.println("Probeer het opnieuw");
            Menu.PrintMenu();
        }
        System.out.println("Aantal goede antwoorden:" + goede_antwoorden);
        scanner.close();
    }

}
