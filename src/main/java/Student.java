import java.util.ArrayList;
import java.util.Scanner;

public class Student{
    private String Naam;
    private Integer studentNummer;
    private static ArrayList<Student> StudentLijst;
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

    public static void addStudent(Student student){
        StudentLijst.add(student);
    }

    public void DisplayList(){
        for(int i = 0; i < StudentLijst.size(); i++){
            System.out.println(StudentLijst.get(i).getNaam());
            System.out.println(StudentLijst.get(i).getStudentNumber());
        }
        
    }

    public static void removeStudent(int studentNummer) {
        for (int i = 0; i < StudentLijst.size(); i++) {
            if (StudentLijst.get(i).studentNummer == studentNummer){
                StudentLijst.remove(i);
                System.out.println("Student is verwijderd");
            }
            else {
                System.out.println("Deze student Nummer staat niet in onze systeem");
            }
        }
    }
}


