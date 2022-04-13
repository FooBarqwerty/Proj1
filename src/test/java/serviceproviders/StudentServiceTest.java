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

    }

    @Test
    void checkStudentNumber() {

    }

    @Test
    void removeStudent() {
        //Arrange
        Student student = new Student("John ", 12345678);
        DataService tes = new DataService();
        var expectedAnswer = false;
        tes.addStudent(student);



        //Act
        tes.removeStudent(12345678);




        //Arrange
        assertEquals(tes.getStudentLijst().contains(student),expectedAnswer);

    }
}