package serviceproviders;
import model.Results;
import serviceproviders.DataService;

public class ResultsService {

    public static void addResult(String examName, int goedeAntwoorden, int aantalVragenGoedVoldoende){
        DataService.CurrentStudent().getLijstResults().add(new Results(examName, goedeAntwoorden, aantalVragenGoedVoldoende));
    }

    public int setStudentNumber(){
        int studentNumber = DataService.CurrentStudentNumber();
        return studentNumber;
    }




}
