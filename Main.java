import java.util.*;

public class Main {
    public static void main(String[] args) {
        FileHandler fr=new FileHandler();
        ArrayList<Question> questions = fr.loadQuestions("questions.txt");
        QuizManager quizManager = new QuizManager();
        quizManager.startQuiz(questions);
    }
}
