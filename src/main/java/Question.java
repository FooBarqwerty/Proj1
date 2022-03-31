import java.util.ArrayList;
import java.util.Collections;

public class Question {
    private String question; //question
    public ArrayList<String> answers; //choices
    private String correct_answer; //answer

    public Question(String question, ArrayList<String> answers, String correct_answer) {
        this.question = question;
        this.answers = answers;
        this.correct_answer = correct_answer;
    }

    //shuffle answers ArrayList
    public void shuffle() {
        Collections.shuffle(this.answers);
    }

    public ArrayList<String> getAnswers() {
        Collections.shuffle(answers);
        return answers;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }
}
/*    private String question;
    private String answer1 = "";,
    private String answer2 = "";
    private String answer3 = "";
    private String answer4 = "";

    public Question(String question, String answer1, String answer2, String answer3, String answer4) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;

    }

    public Question(String question, String answer1) {

        this.question = question;
        this.answer1 = answer1;
    }

    public Question(String question, String answer1, String answer2) {

        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
    }

    public Question(String question, String answer1, String answer2, String answer3) {

        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer1(){
        return answer1;
    }

    public String getAnswer2(){
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }
 */