package serviceproviders;

import model.Examen;
import model.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DataServiceTest {

    @Test
    @ValueSource
        //deze methode controleert of de Exam-objecten aan de araylijst Exam zijn toegevoegd
    void addExams() {
        //arrange
        var addExamsTest = new DataService();
        var expectedAnswer = true;

        //act
        addExamsTest.AddExams();

        //Assert
        assertFalse(addExamsTest.getExamsArrayList().isEmpty());
    }

    @Test
    void initilizeStudents() {
        //arrange
        DataService IS = new DataService();
        var expectedAnswer = true;

        //act
        IS.initilizeStudents();

        //assert
        assertEquals(IS.getStudentLijst().isEmpty(), expectedAnswer);
    }

    @Test
        //
    void addStudent() {
        //arrange
        DataService addStudentTest = new DataService();
        Student student = new Student("Jeffery", 372949);
        var expectedAnswer = true;
        //act
        addStudentTest.addStudent(student);

        //assert
        assertEquals(addStudentTest.getStudentLijst().contains(student), expectedAnswer);

    }

    @Test
    void addNewStudent() {
        //NA
    }

    @Test
    void displayStudentList() {
        //NA
    }

    @Test
    void removeStudent() {
        //arrange
        Student student = new Student("Jeffery", 20971);
        DataService RS = new DataService();
        RS.addStudent(student);
        var expectedAnswer = false;

        //act
        RS.removeStudent(20971);

        //assert
        assertEquals(RS.getStudentLijst().contains(student), expectedAnswer);

    }

    @Test
    void currentStudent() {
        //arrange
        DataService CS = new DataService();
        Student student = new Student("Jeffery", 372949);
        Student student2 = new Student("Jeff", 2020202);
        Student expectedAnswer = student2;

        //act
        CS.addStudent(student);
        CS.addStudent(student2);
        Student test = CS.getCurrentStudent();

        //assert
        assertEquals(test, expectedAnswer);

    }

    @Test
    void initializeResultsList() {
        //arrange
        Student IRL = new Student();
        var expectedAnswer = true;

        //act
        DataService.initializeResultsList();

        //assert
        assertFalse(IRL.getLijstResults().isEmpty());


    }
}

