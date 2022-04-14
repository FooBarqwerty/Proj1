package serviceproviders;

import model.Results;
import model.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultsServiceTest {

    @Test
    void addResult() {
        //arrange
        ResultsService testResultService = new ResultsService();

        DataService addStudentTest = new DataService();
        Student student = new Student("Jeffery", 372949);
        var expectedAnswer = true;
        addStudentTest.addStudent(student);

        //act
        testResultService.addResult("Test question",3,1);
        //assert
        assertFalse(DataService.getCurrentStudent().getLijstResults().isEmpty());
    }
}