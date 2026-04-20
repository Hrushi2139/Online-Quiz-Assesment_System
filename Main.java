import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question(
            "What is the size of int in Java?",
            new String[]{"2 bytes","4 bytes","8 bytes","Depends on system"},
            2
        ));
        questions.add(new Question(
            "What Keyword is used to inherit a class in Java?",
            new String[]{"this","super","extends","implements"},
            3
        ));
        questions.add( new Question(
            "What method is entry point of Java Program?",
            new String[]{"start()","run()","main()","init()"},
            3
        ));
        Collections.shuffle(questions); 
        QuizManager quizManager = new QuizManager();
        quizManager.startQuiz(questions);
    }
}
