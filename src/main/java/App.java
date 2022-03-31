import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.*;
import java.util.Collections;
import java.util.List;

public class App {

	public static void main(String[] args){

		System.out.println();
		String a = "Amsterdam";
		String b = "Amsterdam";
		String c = "Amsterdam";
		String d = "Amsterdam";
		ArrayList<String> antwoorden = new ArrayList<>();
		Collections.addAll(antwoorden, a, b, c, d);
		System.out.println(antwoorden.get(0));

		Question question1 = new Question("Wat is de hoofdstad van Nederland?", antwoorden, a);

		ArrayList<Question> questions = new ArrayList<>();
		questions.add(question1);




	}
}





/* import java.util.*;
import java.io.*;

public class App {

	public static void main(String[] args){
		//System.out.println(33113);
		//ArrayList<Question> questionArrayList = new ArrayList<Question>();
		//questionArrayList.add(new Question("Wat is the hoofdstad van Nederland?", "Amsterdam"));

		//Question sad = new Question("Wat is de hoofdstad van de USA?","Washington DC");
		//Question france = new Question("Wat is de hoofdstad van Frankrijk?", "Nice", "Parijs");

		//questionArrayList.add(sad);
		//questionArrayList.add(france);



		//System.out.println(questionArrayList.get(0).getQuestion());
		Menu.PrintMenu();

		try {
			List<String> questions_1 = Files.readAllLines(Paths.get("vragen.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

*/