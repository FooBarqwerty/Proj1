import java.util.ArrayList;

public class App {

	public static void main(String[] args){
		System.out.println(33113);
		ArrayList<Question> questionArrayList = new ArrayList<Question>();
		questionArrayList.add(new Question("Wat is the hoofdstad van Nederland?", "Amsterdam"));

		Question sad = new Question("Wat is de hoofdstad van de USA?","Washington DC");
		Question france = new Question("Wat is de hoofdstad van Frankrijk?", "Nice", "Parijs");

		questionArrayList.add(sad);
		questionArrayList.add(france);



		System.out.println(questionArrayList.get(0).getQuestion());

	}
}
