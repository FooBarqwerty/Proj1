package serviceproviders;

import model.Results;
import model.Student;
import model.Examen;

import java.util.ArrayList;
import java.util.Scanner;

public class DataService {
    private static ArrayList<Student> StudentLijst = new ArrayList<>();
    private static ArrayList<Examen> Exams = new ArrayList<>();
    private static Student currentStudent;

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

    public static ArrayList<Examen> getExamsArrayList() {
        return Exams;
    }

    public static void initilizeStudents() {
        Student student1 = new Student("John", 1234567);
        Student student2 = new Student("John Snow", 1234568);
        Student student3 = new Student("Christiaan de Haan", 18127371);

        DataService.addStudent(student1);
        initializeResultsList();
        DataService.addStudent(student2);
        initializeResultsList();
        DataService.addStudent(student3);
        initializeResultsList();
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

    public static void DisplayStudentList() {
        for (Student student : StudentLijst) {
            System.out.println("------------------------");
            System.out.print("Naam: ");
            System.out.println(student.getNaam());
            System.out.print("Studenten Nummer: ");
            System.out.println(student.getStudentNumber());
            System.out.println("------------------------");
        }

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
                    return currentStudent = StudentLijst.get(index);
                }
            }
        System.out.println("Gebruiker bestaat niet. \n Probeer opnieuw.");
        return currentStudent;
    }

    public static void displayCurrentStudent(){
        Scanner scanner = new Scanner(System.in);
        if (currentStudent == null){
            System.out.println("Er is iets fout gegaan, Voer uw studentennummer in:");
            int studentennummer = scanner.nextInt();
            setCurrentStudent(studentennummer);
        }
        System.out.println("Welkom: " + currentStudent.getNaam() + "\nStudentennummer: " + currentStudent.getStudentNumber());
    }

    public static void  initializeResultsList(){
        ResultsService.addResult(Exams.get(0).getNaam(),4, Exams.get(0).getAantalVragenGoedVoldoende());
        ResultsService.addResult(Exams.get(1).getNaam(),3, Exams.get(1).getAantalVragenGoedVoldoende());
    }

    public static void seeResultsLastTest(){
        System.out.println(
                "De resultaat van uw laatste gemaakt toets: \n\n" +
                "Naam toets: "  +
                DataService.getCurrentStudent().getLijstResults().get(DataService.getCurrentStudent().getLijstResults().size()-1).getExamenNaam() + " \n" +
                "Aantal goede antwoorden: " +
                DataService.getCurrentStudent().getLijstResults().get(DataService.getCurrentStudent().getLijstResults().size()-1).getGoedeAntwoorden() + " \n"
        );
        if (DataService.getCurrentStudent().getLijstResults().get(DataService.getCurrentStudent().getLijstResults().size()-1).getGeslaagd()){
            System.out.println("U bent geslaagd. \n");
        }
        else {
            System.out.println("U bent niet geslaagd. \n");
        }
    }

    public static void DisplayGeslaagdToets(){
        if (DataService.getCurrentStudent().getLijstResults().size() == 0) {
            System.out.println("U heeft geen toetsen gemaakt.\n");
        }
        else {
            System.out.println("Deze zijn de toetsen die u een voldoende voor heeft:");
            for (int index = 0; index < DataService.getCurrentStudent().getLijstResults().size(); index++) {
                if (DataService.getCurrentStudent().getLijstResults().get(index).getGeslaagd()) {
                    System.out.println(
                            "-------------------------\n" +
                                    "Naam toets: " +
                                    DataService.getCurrentStudent().getLijstResults().get(index).getExamenNaam() + " \n" +
                                    "Aantal goede antwoorden: " +
                                    DataService.getCurrentStudent().getLijstResults().get(index).getGoedeAntwoorden() + " \n" +
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