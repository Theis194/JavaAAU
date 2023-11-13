/**
 * A class Quiz that represents a quiz with a number of multiple choice question
 *
 * @author Gabriela Montoya
 * @version 1.1, 2023-11-03
 */
 
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;

class Quiz {

    private List<Question> qs;
    private int next;
    
    public Quiz () {
        this.next = 0; 
        this.qs = new ArrayList<Question>(); 
    }
   
    public void addQuestion(Question q) {
        this.qs.add(q);
    }
    
    public double eval(List<String> es) {
        double c=0.0;
        int k = 0;
        for (Question q : qs) {
            if (q.eval(es.get(k))) {
               c++;
            }
            k++;
        }
        return c / qs.size()*100;
    }

    String getNextQuestion() {
        if (next < qs.size()) {
            return qs.get(next++).toString();
        } else {
            throw new NoSuchElementException();
        }
    }
    
    void restart() {
        next = 0;
    }
}