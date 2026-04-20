import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner  in = new Scanner(System.in);
        System.out.println("1. Quiz");
        System.out.println("2. Add Question - Admin");
        System.out.println("Enter the Choice :");
        int ch = in.nextInt();
        in.nextLine();
        FileHandler fr=new FileHandler();
        if(ch==1){
            ArrayList<Question> questions = fr.loadQuestions("questions.txt");
            QuizManager quizManager = new QuizManager();
            quizManager.startQuiz(questions);

        }else if(ch==2){
            System.out.println("Enter question: ");
            String text=in.nextLine();
            String [] opts=new String[4];
            for(int i=0;i<4;i++){
                System.out.print("Enter option "+(i+1) + ": ");
                opts[i]=in.nextLine();
            }
            System.out.println("Enter correct option : ");
            int crtOpt=in.nextInt();
            if(crtOpt<1 || crtOpt>4){
                System.out.println("Invalid Option");
                return;
            }
            Question que= new Question(text,opts,crtOpt);
            fr.appendQuestion("questions.txt",que);
        }
    }
}
