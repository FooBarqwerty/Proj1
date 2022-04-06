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

    public int getStudentNumber() {
        return studentNummer;
    }
    public String getNaam(){
        return Naam;
    }

    public ArrayList<Student> NieuweStudent(){
        Scanner studenten = new Scanner(System.in);
        //ArrayList <Student> NotStudents = new ArrayList<>();

        System.out.println("Whats your name?");
        String naam = studenten.nextLine();

        System.out.println("Whats your studentnumber?");
        Integer studentNummer = studenten.nextInt();

        for (int i = 0; i < Studenten.size(); i++) {
            while (!(studentNummer > 9999999 && studentNummer < 99999999) && Studenten.get(i).getStudentNumber().contains(studentNummer)) {
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


