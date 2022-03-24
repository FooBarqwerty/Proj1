import java.util.ArrayList;
import java.util.Scanner;

public class Student{
    private String Naam;
    private static Integer studentNummer;
    private ArrayList<Student> Studenten = new ArrayList<>();
    private Results results;

    public Student(String Naam, Integer studentNummer){
        this.Naam = Naam;
        this.studentNummer = studentNummer;
    }

    public void setStudent(String Naam, Integer studentNummer){
        this.Naam = Naam;
        this.studentNummer = studentNummer;
    }

    public void fillList(){
        Scanner studenten = new Scanner(System.in);
        System.out.println("Whats your name?");
        String naam = studenten.nextLine();
        System.out.println("Whats your studentnumber?");
        Integer studentNummer = studenten.nextInt();
        while(studenten.nextInt() > 99999999) {

        }

        Student student = new Student(naam,studentNummer);
        Studenten.add(student);



    }

    public void removeStudent(String studentNummer){

    }
}


