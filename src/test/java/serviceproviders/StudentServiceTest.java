package serviceproviders;

import model.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.xml.crypto.Data;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void nieuweStudent() {
        //NA
    }

    @Test
    void checkStudentNumber() {
        //arrange
        Student student = new Student("John", 210362);
        var expectedAnswer = -1;
        DataService.addStudent(student);

        //assert
        assertEquals(StudentService.checkStudentNumber(210362), expectedAnswer);


    }

}