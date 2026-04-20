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
        int score =0;
        System.out.println("QUIZ");
        for(Question q:questions){
            System.out.println(q.getQuestion());
            String [] ops = q.getOptions();
            for(int i=0;i<ops.length;i++){
                System.out.println((i+1)+"."+ops[i]);
            }
            System.out.print("Enter the Correct Option:");
            int enteredOption=in.nextInt();
            if(enteredOption==q.getCorrectOption()) score+=1;
        }
        System.out.println("Final Score :"+score+"/"+ questions.size());
    }
}
