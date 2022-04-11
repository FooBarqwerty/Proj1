package serviceproviders;
import model.Examen;

public class ExamService {
    public static void ListExams() {
        System.out.println(
                new Examen("Topografie","Multiple Choice", 4)
                        + "\n" + new Examen("Verkeers model.Examen", "Ja/Nee",3)
                        + "\n" + new Examen("Topografie", "Open Vragen",3));
    }
}




