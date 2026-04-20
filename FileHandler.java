
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
    public void appendQuestion(String file,Question que){
       try {
           BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
           StringBuilder Stringline=new StringBuilder();
           Stringline.append(que.getQuestion()).append("|");
           String [] options = que.getOptions();
           for(int i=0;i<options.length;i++){
                Stringline.append(options[i]);
                if(i!=options.length-1) Stringline.append(",");
           }
           Stringline.append("|");
           Stringline.append(que.getCorrectOption());
           bw.write(Stringline.toString());
           bw.newLine();
           bw.close();
           System.out.println("Question Added Successfully");
       } catch (Exception e) {
            System.out.println("Error in adding the Question");
       }
    }
}
