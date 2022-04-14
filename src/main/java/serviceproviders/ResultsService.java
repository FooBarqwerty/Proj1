package serviceproviders;
import model.Results;

public class ResultsService {

    public static void addResult(String examName, int goedeAntwoorden, int aantalVragenGoedVoldoende){
        DataService.getCurrentStudent().getLijstResults().add(new Results(examName, goedeAntwoorden, aantalVragenGoedVoldoende));
    }
}
