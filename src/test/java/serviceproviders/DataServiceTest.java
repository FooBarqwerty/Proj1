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
    void addExams() {
        //arrange
        var addExamsTest = new DataService();
        Examen examenMulti = new Examen("Topografie","Multiple Choice", 4);
        Examen examenJaNee = new Examen("Verkeers Examen", "Ja/Nee",3);
        Examen examenOpen = new Examen("Topografie Open vragen", "Open Vragen",3);

        //act
        addExamsTest.AddExams();

        //Assert
        assertFalse(addExamsTest.getExamsArrayList().contains(examenMulti));
        assertFalse(addExamsTest.getExamsArrayList().contains(examenJaNee));
        assertFalse(addExamsTest.getExamsArrayList().contains(examenOpen));

    }

    @Test
    void initilizeStudents() {
        //arrange
        DataService IS = new DataService();

        //act
        IS.initilizeStudents();

        //assert
        assertTrue(!(IS.getStudentLijst().isEmpty()));
    }

    @Test
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
    }

    @Test
    void removeStudent() {
        //arrange
        Student student = new Student("Jeffery",20971);
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
    }

    @Test
    void initializeResultsList() {
    }

    @Test
    void seeResultsLastTest() {
    }

    @Test
    void displayGeslaagdToets() {
    }
}