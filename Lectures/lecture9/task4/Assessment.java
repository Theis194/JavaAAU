/**
 * A class Assessment that represents an assessment based on a 
 * quiz with a number of multiple choice question
 *
 * @author Gabriela Montoya
 * @version 1.1, 2023-11-03
 */
 
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Assessment {
    private Quiz q;
    
    public Assessment(Quiz q){
        this.q = q; 
    }
    
    public void take() {
        List<String> answers = new ArrayList<String>();
        try {
            while(true) {
                String str = q.getNextQuestion();
                String answer = getInput(str);
                if (answer == null) {
                    q.restart();
                } else {
                    answers.add(answer);
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("You are done with this quiz!");
        }
        display(q.eval(answers));
    }
    
    public String getInput(String text) {
        System.out.println(text);
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }
    
    public void display(double d) {
        System.out.println("Your score is "+d+"%");
    }
}