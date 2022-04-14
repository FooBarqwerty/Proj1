package serviceproviders;

import model.Menu;
import model.Results;
import model.Student;
import model.Examen;

import java.util.ArrayList;
import java.util.Scanner;

public class DataService {
    private static ArrayList<Student> StudentLijst = new ArrayList<>();
    private static ArrayList<Examen> Exams = new ArrayList<>();
    private static Student currentStudent;
    private static Boolean loginSuccess;

    public static ArrayList<Examen> getExamsArrayList() {
        return Exams;
    }

    public static void addStudent(Student student) {
        StudentLijst.add(student);
        setLastStudent();
    }

    public static void addNewStudent() {
        StudentLijst.add(StudentService.NieuweStudent());
        setLastStudent();
    }

    public static ArrayList<Student> getStudentLijst() {
        return StudentLijst;
    }

    public static void removeStudent(int studentNumber) {
        Boolean verwijderCheck= false;
        for (int i = 0; i < StudentLijst.size(); i++) {
            if (StudentLijst.get(i).getStudentNumber() == studentNumber) {
                StudentLijst.remove(i);
                setLastStudent();
                System.out.println("Student verwijderd\n");
                verwijderCheck = true;
                break;
            }
        }
        if (verwijderCheck == false){
            System.out.println("Deze studentnummer staat niet in onze systeem");
        }
    }

    public static Student getCurrentStudent() {
        return currentStudent;
    }

    public static Student setLastStudent() {
        return currentStudent = StudentLijst.get(StudentLijst.size() - 1);
    }

    public static Student setCurrentStudent(Integer studentNumber) {
        for (int index = 0; index < StudentLijst.size(); index++) {
            if (StudentLijst.get(index).getStudentNumber() == studentNumber) {
                loginSuccess = true;
                return currentStudent = StudentLijst.get(index);
            }
        }
        if (loginSuccess == false){
            Menu.displayLogIn();
        }
        System.out.println("Deze gebruiker bestaat niet. \nProbeer het opnieuw.");
        return currentStudent;
    }

    public static void initilizeStudents() {
        Student student1 = new Student("Jean-Luc Picard", 20245672);
        Student student2 = new Student("Spock Snow", 20145683);
        Student student3 = new Student("Christiaan de Haan", 18127371);

        DataService.addStudent(student1);
        initializeResultsList();
        DataService.addStudent(student2);
        initializeResultsList();
        DataService.addStudent(student3);
        initializeResultsList();
    }

    public static void AddExams() {
        Examen examenMulti = new Examen("Topografie", "Multiple Choice", 4);
        Examen examenJaNee = new Examen("Verkeers Examen", "Ja/Nee", 3);
        Examen examenOpen = new Examen("Topografie Open vragen", "Open Vragen", 3);

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

    public static void  initializeResultsList(){
        ResultsService.addResult(Exams.get(0).getNaam(),4, Exams.get(0).getAantalVragenGoedVoldoende());
        ResultsService.addResult(Exams.get(1).getNaam(),3, Exams.get(1).getAantalVragenGoedVoldoende());
    }

}