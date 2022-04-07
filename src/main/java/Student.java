import java.util.ArrayList;
import java.util.Scanner;

public class Student{
    private final String Naam;
    private static Integer studentNummer;
    private ArrayList<Student> StudentLijst;
    private Results results;

    public Student(String Naam, Integer studentNummer){
        this.Naam = Naam;
        this.studentNummer = studentNummer;
        this.StudentLijst = new ArrayList<>();

    }

    public String getNaam() {
        return Naam;
    }

    public int getStudentNumber() {
        return studentNummer;
    }

    public ArrayList<Student> NieuweStudent(){
        Scanner studenten = new Scanner(System.in);
        //ArrayList <Student> NotStudents = new ArrayList<>();

        System.out.println("Wat is jouw naam?");
        String naam = studenten.nextLine();

        System.out.println("Wat is jouw student nummer?");
        Integer studentNummer = studenten.nextInt();

        StudentLijst.add(new Student(naam, studentNummer));
        //Studenten = NotStudents;
        return StudentLijst;
    }

    public void DisplayList(){
        for(int i = 0; i < StudentLijst.size(); i++){
            System.out.println(StudentLijst.get(i).getNaam());
            System.out.println(StudentLijst.get(i).getStudentNumber());
        }
        
    }

    public void removeStudent(int studentNummer) {
        if (StudentLijst.contains(studentNummer)) {
            StudentLijst.remove(studentNummer);
        }
        else{
            System.out.println("Deze student Nummer staat niet in onze systeem");
        }
    }
}


