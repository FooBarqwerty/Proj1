package serviceproviders;
import model.Examen;

import java.util.ArrayList;

public class ExamService {
    public static void ListExams() {
        /*System.out.println(
                new Examen("Topografie","Multiple Choice", 4)
                        + "\n" + new Examen("Verkeers model.Examen", "Ja/Nee",3)
                        + "\n" + new Examen("Topografie", "Open Vragen",3));

         */
        for (int index = 0; index < DataService.getExamsArrayList().size(); index++) {
            System.out.println(DataService.getExamsArrayList().get(index));
            //DataService.getExamsArrayList();
        }
    }
}




