import java.util.*;
import java.util.concurrent.Flow;
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
        Collections.shuffle(questions);
        System.out.println("\n============= QUIZ =============");
        for(Question q:questions){
            System.out.println("\n---------------------------------------------------");
            System.out.println(q.getQuestion());
            System.out.println("--------------------------------------------------");
            String [] ops = q.getOptions();
            for(int i=0;i<ops.length;i++){
                System.out.println((i+1)+"."+ops[i]);
            }
            long startCounter=System.currentTimeMillis();
            System.out.print("Enter the Correct Option:");
            int enteredOption=in.nextInt();
            if(enteredOption<1 || enteredOption>4){
                System.out.println("Invalid Question");
                System.out.println("Skipping.....!!");
                continue;
            }
            long endCounter=System.currentTimeMillis();
            if(endCounter-startCounter>=20000){
                System.out.println("Time's Up");
                System.out.println("Question Skipped");
                continue;
            }
            if(enteredOption==q.getCorrectOption()) score+=1;
        }
        System.out.println("\n================= RESULT ================");
        System.out.println("Final Score :"+score+"/"+ questions.size());
        double percentage=(score*100.0)/questions.size();
        if(percentage>=85) System.out.println("Performance : Excellent performance");
        else if(percentage>=50) System.out.println("Performance : Average");
        else System.out.println("Performance : Poor");
    }
}
