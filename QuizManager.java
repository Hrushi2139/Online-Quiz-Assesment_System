import java.util.*;

public class QuizManager {
    public void startQuiz(ArrayList<Question> questions){
        int score=0;
        Scanner in = new Scanner(System.in);
        Collections.shuffle(questions);
        System.out.println("\n================= QUIZ =====================");
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
            long endCounter=System.currentTimeMillis();
            if(endCounter-startCounter>=20000){
                System.out.println("Time's Up");
                System.out.println("Question Skipped");
                continue;
            }
            if(enteredOption<1 || enteredOption>4){
                System.out.println("Invalid Option");
                System.out.println("Skipping.....!!");
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
