import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Question {
    private String question;
    public ArrayList<String> answers;
    private String correct_answer;

    public Question(String question, String[] answers, String correct_answer) {
        this.question = question;
        this.answers = new ArrayList<String>(Arrays.asList(answers));
        this.correct_answer = correct_answer;
    }

    public ArrayList<String> getAnswers() {
        //werkt niet :(
        //Collections.shuffle(answers);
        return answers;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    //shuffle answers ArrayList
    //public void shuffle() {
    //    Collections.shuffle(this.answers);
    //}
}