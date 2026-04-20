
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileHandler {
    public ArrayList<Question> loadQuestions(String file){
        ArrayList<Question> questions= new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line=br.readLine())!=null){
                String [] tokens=line.split("\\|");
                String Qtext=tokens[0];
                String[] options=tokens[1].split(",");
                int correctOption=Integer.parseInt(tokens[2]);
                questions.add(new Question(Qtext, options, correctOption)); 
            }
            br.close();
        }catch(Exception e){
            System.out.println("Error in File");
        }
        return questions;
    }
}
