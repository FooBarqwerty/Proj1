import model.Menu;
import serviceproviders.DataService;

public class App {

	public static void main(String[] args){
		Menu.initializeList();
		App.initializeLists();
		Menu.PrintMenu();
	}
	public void examenOpslaan	() {

	}
	public static void initializeLists () {
		DataService.AddExams();

	}
}