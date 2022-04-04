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

    public void setStudent(String Naam){
        this.Naam = Naam;
        this.studentNummer = studentNummer;
    }
    public int getStudentNumber() {
        return studentNummer;
    }
    public String getNaam(){
        return Naam;
    }

    public void NieuweStudent(){
        Scanner studenten = new Scanner(System.in);
        ArrayList <Student> NotStudents = new ArrayList<>();
        System.out.println("Whats your name?");
        String naam = studenten.nextLine();
        System.out.println("Whats your studentnumber?");
        Integer studentNummer = studenten.nextInt();
        while((studentNummer > 9999999 && NotStudents.contains(studentNummer)) {
            System.out.println("Write it again");
            studentNummer = studenten.nextInt();
        }
        Student student = new Student(naam,studentNummer);
        NotStudents.add(student);
        Studenten = NotStudents;
        }

    
    public void DisplayList(){
        Student student = new Student("Hello",123123);
        Student student2 = new Student("Hello",122123);

        for(int i = 0; i < Studenten.size(); i++){
            System.out.println(Studenten.get(i).getNaam());
            System.out.println(Studenten.get(i).getStudentNumber());
        }
        
    }

    public void removeStudent(String studentNummer){

    }
}


