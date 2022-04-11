package serviceproviders;

import model.Student;
import model.Examen;

import java.util.ArrayList;

public class DataService {
    private static ArrayList<Student> StudentLijst = new ArrayList<>();
    private static ArrayList<Examen> ExamenLijst = new ArrayList<>();

    public static void AddExams(){
         Examen examenMulti = new Examen("Topografie","Multiple Choice", 4);
         Examen examenJaNee = new Examen("Verkeers model.Examen", "Ja/Nee",3);
         Examen examenOpen = new Examen("Topografie", "Open Vragen",3);

        ExamenLijst.add(examenMulti);
        ExamenLijst.add(examenJaNee);
        ExamenLijst.add(examenOpen);

        examenMulti.MultiVragen();
        examenMulti.setAantalVragen();
        examenJaNee.JaNeeVragen();
        examenJaNee.setAantalVragen();
        examenOpen.OpenVragen();
        examenOpen.setAantalVragen();

    }



    public static void addStudent(Student student) {
        StudentLijst.add(student);
    }

    public static void addNewStudent() {
        StudentLijst.add(StudentService.NieuweStudent());
    }

    public static void DisplayStudentList() {
        for (int i = 0; i < StudentLijst.size(); i++) {
            System.out.println("_______________________");
            System.out.print("Naam: ");
            System.out.println(StudentLijst.get(i).getNaam());
            System.out.print("Studenten Nummer: ");
            System.out.println(StudentLijst.get(i).getStudentNumber());
            System.out.println("------------------------");
        }

    }

    public static void removeStudent(int studentNummer) {
        for (int i = 0; i < StudentLijst.size(); i++) {
            if (StudentLijst.get(i).getStudentNumber() == studentNummer) {
                StudentLijst.remove(i);
                System.out.println("model.Student is verwijderd");
            } else {
                System.out.println("Deze student Nummer staat niet in onze systeem");
            }
        }
    }

    public static int CurrentStudent() {
        return StudentLijst.get(StudentLijst.size() - 1).getStudentNumber();
    }

}
