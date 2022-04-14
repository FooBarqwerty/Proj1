import model.Menu;
import serviceproviders.DataService;

public class App {

	public static void main(String[] args){
		DataService.AddExams();
		DataService.initilizeStudents();
		//Menu.displayLogIn();
		Menu.PrintMenu();
	}
}