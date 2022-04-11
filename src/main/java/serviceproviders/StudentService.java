package serviceproviders;

import java.util.Scanner;
import model.Student;

public class StudentService {

    public static Student NieuweStudent(){
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voer uw naam in");
        String setnaam = scanner.nextLine();
        student.setNaam(setnaam);

        System.out.println("voer uw studentnummer in");
        int studentnummer = scanner.nextInt();
        student.setStudentNummer(studentnummer);

        return student;
    }

    public  static void removeStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Voer de studenten nummer die uw wilt verwijderen: ");
        int verwijderenStudent = scanner.nextInt();
        DataService.removeStudent(verwijderenStudent);
    }
}
