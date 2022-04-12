package serviceproviders;

import model.Results;
import model.Student;
import model.Examen;

import java.util.ArrayList;

public class DataService {
    private static ArrayList<Student> StudentLijst = new ArrayList<>();
    private static ArrayList<Examen> Exams = new ArrayList<>();

    public static void AddExams(){
         Examen examenMulti = new Examen("Topografie","Multiple Choice", 4);
         Examen examenJaNee = new Examen("Verkeers Examen", "Ja/Nee",3);
         Examen examenOpen = new Examen("Topografie Open vragen", "Open Vragen",3);

        Exams.add(examenMulti);
        Exams.add(examenJaNee);
        Exams.add(examenOpen);

        ExamService.MultiVragen(examenMulti);
        examenMulti.setAantalVragen();
        ExamService.JaNeeVragen(examenJaNee);
        examenJaNee.setAantalVragen();
        ExamService.OpenVragen(examenOpen);
        examenOpen.setAantalVragen();
    }
    public static ArrayList<Examen> getExamsArrayList() {
        return Exams;
    }

    public static void initilizeStudents(){
        Student student1 = new Student("John", 1234567);
        Student student2 = new Student("John Snow", 1234568);
        DataService.addStudent(student1);
        DataService.addStudent(student2);
    }

    public static void addStudent(Student student) {
        StudentLijst.add(student);
    }

    public static void addNewStudent() {
        StudentLijst.add(StudentService.NieuweStudent());
    }

    public static ArrayList<Student> getStudentLijst(){
        return StudentLijst;
    }

    public static void DisplayStudentList() {
        for (Student student : StudentLijst) {
            System.out.println("_______________________");
            System.out.print("Naam: ");
            System.out.println(student.getNaam());
            System.out.print("Studenten Nummer: ");
            System.out.println(student.getStudentNumber());
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
    public static Student CurrentStudent() {
        return StudentLijst.get(StudentLijst.size() - 1);
    }

    public static int CurrentStudentNumber() {
        return StudentLijst.get(StudentLijst.size() - 1).getStudentNumber();
    }

    public static void  initializeResultsList(){
        //Results results = new Results(
    }

    public static void seeResultsLastTest(){
        //System.out.println(DataService.CurrentStudent().getLijstResults().get(DataService.CurrentStudent().getLijstResults().size()-1));

        System.out.println(
                "De resultaat van uw laatste gemaakt toets: \n\n" +
                "Naam toets: "  +
                DataService.CurrentStudent().getLijstResults().get(DataService.CurrentStudent().getLijstResults().size()-1).getExamenNaam() + " \n" +
                "Aantal goede antwoorden: " +
                DataService.CurrentStudent().getLijstResults().get(DataService.CurrentStudent().getLijstResults().size()-1).getGoedeAntwoorden() + " \n"
        );

        if (DataService.CurrentStudent().getLijstResults().get(DataService.CurrentStudent().getLijstResults().size()-1).getGeslaagd()){
            System.out.println("U bent geslaagd. \n");
        }
        else {
            System.out.println("U bent niet geslaagd. \n");
        }
    }

    public static void DisplayGeslaagdToets(){
        if (DataService.CurrentStudent().getLijstResults().size() == 0) {
            System.out.println("U heeft geen toetsen gemaakt.\n");
        }
        else {
            System.out.println("Deze zijn de toetsen die u een voldoende voor heeft:");
            for (int index = 0; index < DataService.CurrentStudent().getLijstResults().size(); index++) {
                if (DataService.CurrentStudent().getLijstResults().get(index).getGeslaagd()) {
                    System.out.println(
                            "-------------------------\n" +
                                    "Naam toets: " +
                                    DataService.CurrentStudent().getLijstResults().get(index).getExamenNaam() + " \n" +
                                    "Aantal goede antwoorden: " +
                                    DataService.CurrentStudent().getLijstResults().get(index).getGoedeAntwoorden() + " \n" +
                                    "U bent geslaagd \n");
                }
            }
        }
    }

}