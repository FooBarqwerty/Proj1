package serviceproviders;

import java.util.ArrayList;
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
        studentnummer= checkStudentNumber(studentnummer);

            while (studentnummer == -1 || studentnummer > 99999999){
            System.out.println("Nog een keer Typen");
            studentnummer = scanner.nextInt();
            studentnummer = checkStudentNumber(studentnummer);
            }
        student.setStudentNummer(studentnummer);

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

    public static void removeStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Voer de studenten nummer die uw wilt verwijderen: ");
        int verwijderenStudent = scanner.nextInt();
        DataService.removeStudent(verwijderenStudent);
    }

}

/*
    public static int switchStudent(int studentNummer){
        for(int i = 0; i < StudentLijst.size(); i++) {
            if (studentNummer == StudentLijst.get(i).getStudentNumber()) {
                System.out.println(StudentLijst.get(i).getStudentNumber());
                return  StudentLijst.get(i).getStudentNumber();
            }
        }
        return 0;
    }
}

 */