import java.util.ArrayList;
import java.util.Scanner;

public class Student{
    private final String Naam;
    private static Integer studentNummer;
    private ArrayList<Student> Studenten;
    private Student Studentadd;
    private Results results;

    public Student(String Naam, Integer studentNummer){
        this.Naam = Naam;
        this.studentNummer = studentNummer;
        this.Studenten = new ArrayList<>();
        this.Studentadd = Studentadd;
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

        for (int i = 0; i < Studenten.size(); i++) {
            while((!(studentNummer > 99999999)) || (!(Studenten.contains(studentNummer)))){
                System.out.println("Write it again");
                studentNummer = studenten.nextInt();
            }
        }
        Studenten.add(new Student(naam, studentNummer));
        //Studenten = NotStudents;
        return Studenten;
    }

    public void DisplayList(){

        for(int i = 0; i < Studenten.size(); i++){
            System.out.println(Studenten.get(i).getNaam());
            System.out.println(Studenten.get(i).getStudentNumber());
        }
        
    }

    public void removeStudent(String studentNummer){

    }
}


