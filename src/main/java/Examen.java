import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Examen {

    public final String naam;
    private String TypeOfExam;
    private Integer aantalVragen;
    private ArrayList<Question> lijstVragen = new ArrayList<Question>();

    public Examen(String naam, String TypeOfExamen) {
        this.naam = naam;
        this.TypeOfExam = TypeOfExamen;
    }

    public void setAantalVragen() {
        this.aantalVragen = lijstVragen.size();
    }

    @Override
    public String toString() {
        return  "----------------------------------" + '\n' +
                "Examen: " + naam + '\n' +
                "TypeOfExam= " + TypeOfExam + '\n' +
                "aantalVragen: " + aantalVragen + '\n'
                        + "----------------------------------" + '\n';

    }

    public void spel () {
        Scanner scanner = new Scanner(System.in);
        int goede_antwoorden = 0;
        int totaal_vragen = aantalVragen;

        //for loop voor elke vraag uit ArrayList lijstVragen.
        try {
            for (int vraag = 0; vraag < lijstVragen.size(); vraag++) {
                //shuffled antwoorden voor elke vraag.
                lijstVragen.get(vraag).shuffle();

                //print vraag
                System.out.println(lijstVragen.get(vraag).getQuestion());
                //Voor mogelijke waar/niet waar vragen, multi-vragen. Open vragen komen in een andere methode.
                int aantalAntwoorden = lijstVragen.get(vraag).getAnswers().size();

                //for loop print antwoorden van vraag.
                for (int antwoord_in_ArrayList = 0; antwoord_in_ArrayList < aantalAntwoorden; antwoord_in_ArrayList++) {
                    System.out.println("Antwoord " + (antwoord_in_ArrayList + 1) + ": " + lijstVragen.get(vraag).getAnswers().get(antwoord_in_ArrayList));
                }

                //correcte vraag wordt in een string en int gezet
                String correcteAntwoord = lijstVragen.get(vraag).getCorrect_answer();
                //TEST System.out.println("Correcte vraag: " + correcteAntwoord);
                int correcteAntwoordInt = lijstVragen.get(vraag).answers.indexOf(correcteAntwoord);
                //TEST System.out.println("correcteAntwoordInt" + correcteAntwoordInt);

                //gebruiker moet nu getal invoeren als antwoord op vraag.
                System.out.println("Voer uw antwoord in: ");
                int gegevenAntwoordInt = -1;
                try {
                    gegevenAntwoordInt = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Voer een getal in: ");
                    System.out.println();
                }

                if (gegevenAntwoordInt == correcteAntwoordInt + 1) {
                    goede_antwoorden++;
                    System.out.println("Goed!");
                } else {
                    System.out.println("Fout!");
                }
                System.out.println("Goede antwoorden: " + goede_antwoorden + " van Totaal: " + totaal_vragen + "Vragen");
            }
        }
        catch (Exception e) {
            System.out.println("Er is iets fout gegaan. Probeer het opnieuw");
            Menu.PrintMenu();
        }
        System.out.println("Aantal goede antwoorden:" + goede_antwoorden);
        scanner.close();
    }
    public void spelOpen(){
        Scanner scanner = new Scanner(System.in);
        int goede_antwoorden = 0;
        //for loop voor elke vraag uit ArrayList lijstVragen.
        try {
            for (int vraag = 0; vraag < lijstVragen.size(); vraag++) {
                //print vraag
                System.out.println(lijstVragen.get(vraag).getQuestion());
                //Voor mogelijke waar/niet waar vragen, multi-vragen. Open vragen komen in een andere methode.
                int aantalAntwoorden = lijstVragen.get(vraag).getAnswers().size();
                System.out.println("aantal antwoorden "+aantalAntwoorden);

                //for loop print antwoorden van vraag.
                for (int antwoord_in_ArrayList = 0; antwoord_in_ArrayList < aantalAntwoorden; antwoord_in_ArrayList++) {
                    System.out.println("Antwoord " + (antwoord_in_ArrayList + 1) + ": " + lijstVragen.get(vraag).getAnswers().get(antwoord_in_ArrayList));
                }

                //correcte vraag wordt in een string gezet
                String correcteAntwoord = lijstVragen.get(vraag).getCorrect_answer();
                System.out.println("Correcte vraag: " + correcteAntwoord);

                //speler moet antwoord invoeren
                String gegevenAntwoord = scanner.nextLine();

                //Antwoord is goed if antwoord is zelfde als goedeAntwoord (hoofdletters maakt geen verschil)
                if (correcteAntwoord.equals(gegevenAntwoord) || correcteAntwoord.toLowerCase().equals(gegevenAntwoord) || correcteAntwoord.toUpperCase().equals(gegevenAntwoord)) {
                    goede_antwoorden++;
                    System.out.println("Goed!");
                } else {
                    System.out.println("Fout!");
                }
                System.out.println("Goede antwoorden: " + goede_antwoorden);
            }
        }
        catch (Exception e){
            System.out.println("Er is iets fout gegaan. Probeer het opnieuw");
            Menu.PrintMenu();
        }
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
                    //Menu.PrintMenu();
                    break;
                default:
                    //testQuestion();
                    break;
            }
        }
        catch (Exception e) {
            System.out.println("Er is iets gebeurt. Probeer het opnieuw.");
            //methode terug?
            Menu.PrintMenu();
        }
    }

    public void MultiVragen() {
        //Plaatsen wij question objects in
        // Om vragen doorgegeven aan de Question.java constructor en de vraag, met vragenArrayList en String Correcte_antwoord in een ArrayList lijstVragen te zetten
        String vraag = "Wat is de hoofdstad van Nederland?";
        String [] antwoorden = {"Amsterdam",  "Den Haag", "Rotterdam","Eindhoven"};
        String correct_answer = antwoorden [0];
        lijstVragen.add(new Question(vraag, antwoorden, correct_answer)); // met String correct_answer als juiste antwoord

        vraag = "Wat is de hoofdstad van de Verenigd Koninkrijk?";
        antwoorden = new String[] {"London", "York", "Wales", "Derry"};
        correct_answer = antwoorden [0];
        lijstVragen.add(new Question(vraag, antwoorden, correct_answer)); // met String correct_answer als juiste antwoord

        vraag = "Wat is de hoofdstad van Frankrijk?";
        antwoorden = new String[] {"Parijs",  "Nice", "Monaco","Calais"};
        correct_answer = antwoorden [0];
        lijstVragen.add(new Question(vraag, antwoorden, correct_answer)); // met String correct_answer als juiste antwoord

        vraag = "Wat is de hoofdstad van de Verenigde Staten?";
        antwoorden = new String[] {"Washington DC", "New York", "Los Angeles", "Miami"};
        correct_answer = antwoorden [0];
        lijstVragen.add(new Question(vraag, antwoorden, correct_answer)); // met String correct_answer als juiste antwoord

        vraag = "Wat is de hoofdstad van Monaco";
        antwoorden = new String[] {"Monaco-Ville",  "Monaco", "Parijs","Het heeft geen hoofdstad"};
        correct_answer = antwoorden [0];
        lijstVragen.add(new Question(vraag, antwoorden, correct_answer)); // met String correct_answer als juiste antwoord

        vraag = "Wat is de hoofdstad van Duitsland";
        antwoorden = new String[] {"Berlijn",  "München", "Hamburg", "Dusseldorf" , "Cologne"};
        correct_answer = antwoorden [0];
        lijstVragen.add(new Question(vraag, antwoorden, correct_answer)); // met String correct_answer als juiste antwoord
    }
    public void JaNeeVragen(){
        String vraag = "is dit een test vraag?";
        String [] antwoorden = {"Ja", "Nee"};
        String correcte_vraag = antwoorden [0];
        lijstVragen.add(new Question(vraag, antwoorden, correcte_vraag));

        vraag = "Ben jij een ja of nee?";
        antwoorden = new String[] {"Ja", "Ja"};
        correcte_vraag = antwoorden [0];
        lijstVragen.add(new Question(vraag, antwoorden, correcte_vraag));

        vraag = "is Hertog Jan de beste bier?";
        antwoorden = new String[] {"Ja", "Nee"};
        correcte_vraag = antwoorden [0];
        lijstVragen.add(new Question(vraag, antwoorden, correcte_vraag));

    }
    public void OpenVragen(){
        String vraag = "Wat is de hoofdstad van Nederland?";
        String [] antwoorden = {"Amsterdam"};
        String correcte_vraag = antwoorden [0];
        lijstVragen.add(new Question(vraag, antwoorden, correcte_vraag));

        vraag = "Wat is de hoofdstad van de Verenigde Staten?";
        antwoorden = new String[] {"Washington DC"};
        correcte_vraag = antwoorden [0];
        lijstVragen.add(new Question(vraag, antwoorden, correcte_vraag));

        vraag = "Wat is de hoofdstad van de Verenigd Koninkrijk?";
        antwoorden = new String[] {"London"};
        correcte_vraag = antwoorden [0];
        lijstVragen.add(new Question(vraag, antwoorden, correcte_vraag));

        vraag = "Wat is de hoofdstad van Canada?";
        antwoorden = new String[] {"Ottawa"};
        correcte_vraag = antwoorden [0];
        lijstVragen.add(new Question(vraag, antwoorden, correcte_vraag));

        vraag = "Wat is de hoofdstad van Duitsland?";
        antwoorden = new String[] {"Berlijn"};
        correcte_vraag = antwoorden [0];
        lijstVragen.add(new Question(vraag, antwoorden, correcte_vraag));

        vraag = "Wat is de hoofdstad van Frankrijk?";
        antwoorden = new String[] {"Parijs"};
        correcte_vraag = antwoorden [0];
        lijstVragen.add(new Question(vraag, antwoorden, correcte_vraag));
    }

}
