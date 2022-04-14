package serviceproviders;
import model.Examen;
import model.Menu;
import model.Question;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExamService {

    public static void toets(Examen examen) {
        Scanner scanner = new Scanner(System.in);
        int goede_antwoorden = 0;
        int totaal_vragen = examen.getAantalVragen();
        int aantalVragenGoedVoldoende = examen.getAantalVragenGoedVoldoende();

        //for loop voor elke vraag uit ArrayList lijstVragen.
        try {
            for (int vraag = 0; vraag < examen.getLijstVragen().size(); vraag++) {
                //shuffled antwoorden voor elke vraag.
                examen.getLijstVragen().get(vraag).shuffle();

                //print vraag
                System.out.println(examen.getLijstVragen().get(vraag).getQuestion());
                //Voor mogelijke waar/niet waar vragen, multi-vragen. Open vragen komen in een andere methode.
                int aantalAntwoorden = examen.getLijstVragen().get(vraag).getAnswers().size();

                //for loop print antwoorden van vraag.
                for (int antwoord_in_ArrayList = 0; antwoord_in_ArrayList < aantalAntwoorden; antwoord_in_ArrayList++) {
                    System.out.println("Antwoord " + (antwoord_in_ArrayList + 1) + ": " + examen.getLijstVragen().get(vraag).getAnswers().get(antwoord_in_ArrayList));
                }

                //correcte vraag wordt in een string en int gezet
                String correcteAntwoord = examen.getLijstVragen().get(vraag).getCorrect_answer();
                //TEST System.out.println("Correcte vraag: " + correcteAntwoord);
                int correcteAntwoordInt = examen.getLijstVragen().get(vraag).getAnswers().indexOf(correcteAntwoord);
                //TEST System.out.println("correcteAntwoordInt" + correcteAntwoordInt);

                //gebruiker moet nu getal invoeren als antwoord op vraag.
                System.out.println("Voer uw antwoord in: ");
                int gegevenAntwoordInt = -1;
                try {
                    gegevenAntwoordInt = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Voer een getal in: \n");
                }

                if (gegevenAntwoordInt == correcteAntwoordInt + 1) {
                    goede_antwoorden++;
                    System.out.println("Goed!\n");
                } else {
                    System.out.println("Fout!\n");
                    System.out.println("Het correcte antwoord was: " + correcteAntwoord +"\n");
                }
            }

            System.out.println("U heeft " + goede_antwoorden +" correcte antwoorden " + "van de " + examen.getAantalVragen() + "\n");
            ResultsService.addResult(examen.getNaam(), goede_antwoorden, aantalVragenGoedVoldoende);
            if (DataService.getCurrentStudent().getLijstResults().get(DataService.getCurrentStudent().getLijstResults().size()-1).getGeslaagd()){
                System.out.println("U bent geslaagd!");
            }
            else {
                System.out.println("U bent niet geslaagd.");
            }
        }
        catch (Exception e) {
            System.out.println("Er is iets fout gegaan. Probeer het opnieuw\n");
            Menu.PrintMenu();
        }
        System.out.println("Aantal goede antwoorden:" + goede_antwoorden);
    }
    public static void toetsOpen(Examen examen){
        Scanner scanner = new Scanner(System.in);
        int goede_antwoorden = 0;
        int aantalVragenGoedVoldoende = examen.getAantalVragenGoedVoldoende();

        //for loop voor elke vraag uit ArrayList lijstVragen.
        try {
            for (int vraag = 0; vraag < examen.getLijstVragen().size(); vraag++) {
                //print vraag
                System.out.println(examen.getLijstVragen().get(vraag).getQuestion());

                //correcte vraag wordt in een string gezet
                String correcteAntwoord = examen.getLijstVragen().get(vraag).getCorrect_answer();

                //speler moet antwoord invoeren
                System.out.println("Voer uw antwoord in: \n");
                String gegevenAntwoord = scanner.nextLine();

                //Antwoord is goed if antwoord is zelfde als goedeAntwoord (hoofdletters maakt geen verschil)
                if (correcteAntwoord.equals(gegevenAntwoord) || correcteAntwoord.toLowerCase().equals(gegevenAntwoord) || correcteAntwoord.toUpperCase().equals(gegevenAntwoord)) {
                    goede_antwoorden++;
                    System.out.println("Goed!\n");
                } else {
                    System.out.println("Fout!");
                    System.out.println("Het correcte antwoord was: " + correcteAntwoord +"\n");

                }
            }
            ResultsService.addResult(examen.getNaam(), goede_antwoorden, aantalVragenGoedVoldoende);
            System.out.println("U heeft " + goede_antwoorden +" correcte antwoorden " + "van de " + examen.getAantalVragen() + "\n");
            if (DataService.getCurrentStudent().getLijstResults().get(DataService.getCurrentStudent().getLijstResults().size()-1).getGeslaagd()){
                System.out.println("U bent geslaagd!");
            }
            else {
                System.out.println("U bent niet geslaagd.");
            }
        }
        catch (Exception e){
            System.out.println("Er is iets fout gegaan. Probeer het opnieuw\n");
        }
    }

    public static void MultiVragen(Examen examen) {
        //Plaatsen wij question objects in
        // Om vragen doorgegeven aan de model.Question.java constructor en de vraag, met vragenArrayList en String Correcte_antwoord in een ArrayList lijstVragen te zetten
        String vraag = "Wat is de hoofdstad van Nederland?";
        String [] antwoorden = {"Amsterdam",  "Den Haag", "Rotterdam","Eindhoven"};
        String correct_answer = antwoorden [0];
        examen.setQuestionLijstVragen(new Question(vraag, antwoorden, correct_answer)); // met String correct_answer als juiste antwoord

        vraag = "Wat is de hoofdstad van de Verenigd Koninkrijk?";
        antwoorden = new String[] {"London", "York", "Wales", "Derry"};
        correct_answer = antwoorden [0];
        examen.setQuestionLijstVragen(new Question(vraag, antwoorden, correct_answer)); // met String correct_answer als juiste antwoord

        vraag = "Wat is de hoofdstad van Frankrijk?";
        antwoorden = new String[] {"Parijs",  "Nice", "Monaco","Calais"};
        correct_answer = antwoorden [0];
        examen.setQuestionLijstVragen(new Question(vraag, antwoorden, correct_answer)); // met String correct_answer als juiste antwoord

        vraag = "Wat is de hoofdstad van de Verenigde Staten?";
        antwoorden = new String[] {"Washington DC", "New York", "Los Angeles", "Miami"};
        correct_answer = antwoorden [0];
        examen.setQuestionLijstVragen(new Question(vraag, antwoorden, correct_answer)); // met String correct_answer als juiste antwoord

        vraag = "Wat is de hoofdstad van Monaco";
        antwoorden = new String[] {"Monaco-Ville",  "Monaco", "Parijs","Het heeft geen hoofdstad"};
        correct_answer = antwoorden [0];
        examen.setQuestionLijstVragen(new Question(vraag, antwoorden, correct_answer)); // met String correct_answer als juiste antwoord

        vraag = "Wat is de hoofdstad van Duitsland";
        antwoorden = new String[] {"Berlijn",  "München", "Hamburg", "Dusseldorf" , "Cologne"};
        correct_answer = antwoorden [0];
        examen.setQuestionLijstVragen(new Question(vraag, antwoorden, correct_answer)); // met String correct_answer als juiste antwoord
    }
    public static void JaNeeVragen(Examen examen){
        String vraag = "is dit een test vraag?";
        String [] antwoorden = {"Ja", "Nee"};
        String correct_answer = antwoorden [0];
        examen.setQuestionLijstVragen(new Question(vraag, antwoorden, correct_answer));

        vraag = "Ben jij een ja of nee?";
        antwoorden = new String[] {"Ja", "Ja"};
        correct_answer = antwoorden [0];
        examen.setQuestionLijstVragen(new Question(vraag, antwoorden, correct_answer));

        vraag = "is Hertog Jan de beste bier?";
        antwoorden = new String[] {"Ja", "Nee"};
        correct_answer = antwoorden [0];
        examen.setQuestionLijstVragen(new Question(vraag, antwoorden, correct_answer));

    }
    public static void OpenVragen(Examen examen){
        String vraag = "Wat is de hoofdstad van Nederland?";
        String [] antwoorden = {"Amsterdam"};
        String correct_answer = antwoorden [0];
        examen.setQuestionLijstVragen(new Question(vraag, antwoorden, correct_answer));

        vraag = "Wat is de hoofdstad van de Verenigde Staten?";
        antwoorden = new String[] {"Washington DC"};
        correct_answer = antwoorden [0];
        examen.setQuestionLijstVragen(new Question(vraag, antwoorden, correct_answer));

        vraag = "Wat is de hoofdstad van de Verenigd Koninkrijk?";
        antwoorden = new String[] {"London"};
        correct_answer = antwoorden [0];
        examen.setQuestionLijstVragen(new Question(vraag, antwoorden, correct_answer));

        vraag = "Wat is de hoofdstad van Canada?";
        antwoorden = new String[] {"Ottawa"};
        correct_answer = antwoorden [0];
        examen.setQuestionLijstVragen(new Question(vraag, antwoorden, correct_answer));

        vraag = "Wat is de hoofdstad van Duitsland?";
        antwoorden = new String[] {"Berlijn"};
        correct_answer = antwoorden [0];
        examen.setQuestionLijstVragen(new Question(vraag, antwoorden, correct_answer));

        vraag = "Wat is de hoofdstad van Frankrijk?";
        antwoorden = new String[] {"Parijs"};
        correct_answer = antwoorden [0];
        examen.setQuestionLijstVragen(new Question(vraag, antwoorden, correct_answer));
    }

}




