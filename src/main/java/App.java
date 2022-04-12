import model.Menu;
import serviceproviders.DataService;

public class App {

	public static void main(String[] args){
		DataService.initilizeStudents();
		DataService.AddExams();
		Menu.PrintMenu();
	}
	public void examenOpslaan	() {

	}
}