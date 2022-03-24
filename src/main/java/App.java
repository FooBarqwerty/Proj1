import java.util.ArrayList;

public class App {

	public static void main(String[] args){

	}
}

class Student{
private String Naam;
private static Integer studentNummer = 20000000;
private ArrayList<Student> student;

public void Student(String Naam){
	this.Naam = Naam;
	this.studentNummer = studentNummer;
}

private static Integer uniekNummer() { // This raises the unique number of the client each time it is used.
		int uniekNummer = studentNummer;
		studentNummer++;
		return uniekNummer;
	}

public void inschrijven(String Naam){
	this.Naam = Naam;
	uniekNummer();
}

}

class Examen{

}

class results{

}


