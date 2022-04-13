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
        Student student3 = new Student("John Snows From the mountains", 1236969);

        DataService.addStudent(student1);
        ResultsService.addResult(Exams.get(0).getNaam(),4, Exams.get(0).getAantalVragenGoedVoldoende());
        ResultsService.addResult(Exams.get(1).getNaam(),3, Exams.get(1).getAantalVragenGoedVoldoende());
        ResultsService.addResult(Exams.get(2).getNaam(),4, Exams.get(2).getAantalVragenGoedVoldoende());

        DataService.addStudent(student2);
        ResultsService.addResult(Exams.get(0).getNaam(),4, Exams.get(0).getAantalVragenGoedVoldoende());
        ResultsService.addResult(Exams.get(1).getNaam(),3, Exams.get(1).getAantalVragenGoedVoldoende());
        ResultsService.addResult(Exams.get(2).getNaam(),4, Exams.get(2).getAantalVragenGoedVoldoende());
        DataService.addStudent(student3);
        ResultsService.addResult(Exams.get(0).getNaam(),4, Exams.get(0).getAantalVragenGoedVoldoende());
        ResultsService.addResult(Exams.get(1).getNaam(),3, Exams.get(1).getAantalVragenGoedVoldoende());
        ResultsService.addResult(Exams.get(2).getNaam(),4, Exams.get(2).getAantalVragenGoedVoldoende());
        //ResultsService.addResult(Exams.get(2).getNaam(),4, Exams.get(2).getAantalVragenGoedVoldoende());
        //ResultsService.addResult(Exams.get(2).getNaam(),4, Exams.get(2).getAantalVragenGoedVoldoende());

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

    public static int setCurrentStudent(Integer studentNumber) {
        for (Student student:
             StudentLijst) {
            if (student.getStudentNumber() == studentNumber){
                return studentNumber;
            }
        }
        return -1;
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
                                    "U bent geslaagd \n"
                    );
                }
            }
        }
    }
    public static void displayStudentRank(){
        ArrayList<Student> arrayListBestStudents = new ArrayList<>();
        int highScoreInt = 0;
        int studentScoreInt = 0;
        for (Student student:
                DataService.StudentLijst
        ) {

            for (Results results:
                    student.getLijstResults()
            ) {
                if (results.getGeslaagd()){
                    studentScoreInt++;
                }
            }

            if (studentScoreInt >= highScoreInt) {
                arrayListBestStudents.add(student);
                if (studentScoreInt > highScoreInt) {
                    arrayListBestStudents.clear();
                    arrayListBestStudents.add(student);
                    highScoreInt = studentScoreInt;
                }
                studentScoreInt=0;
            }
        }
        for (Student bestStudent:
             arrayListBestStudents) {
            System.out.println("Studenen Naam: " +bestStudent.getNaam() + "\nStudenten Nummer: " + bestStudent.getStudentNumber() +"\n");
        }
    }
}