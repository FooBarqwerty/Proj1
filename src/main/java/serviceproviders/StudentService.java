package serviceproviders;

import java.util.ArrayList;
import java.util.Scanner;
import model.Student;

public class StudentService {

    public static Student NieuweStudent(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Voer uw naam in:");
        String setnaam = scanner.nextLine();

        System.out.println("Voer uw studentennummer in:");
        int studentnummer = scanner.nextInt();


        studentnummer= checkStudentNumber(studentnummer);

            while (studentnummer == -1 || studentnummer > 99999999){
            System.out.println("Nog een keer Typen");
            studentnummer = scanner.nextInt();
            studentnummer = checkStudentNumber(studentnummer);
            }
        Student student = new Student(setnaam,studentnummer);

        return student;
    }
    public static int checkStudentNumber(int studentNumber){
        for (int index = 0; index < DataService.getStudentLijst().size(); index++) {
            if (DataService.getStudentLijst().get(index).getStudentNumber() == studentNumber) {
                return -1;
            }
        }
        return studentNumber;
    }
}