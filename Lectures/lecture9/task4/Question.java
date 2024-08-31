/**
 * A class Question that represents a multiple choice question
 *
 * @author Gabriela Montoya
 * @version 1.1, 2023-11-03
 */
 
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

class Question {
    private List<String> options;
    private String text;
    private int correct = -1;
   
    public Question(String t) {
        this.text = t;
        this.options = new ArrayList<String>();
    }   
   
    void addCorrect(int c) {
        if (c>=0 && c < options.size()) {
            this.correct = c;
        } else {
            throw new NoSuchElementException();
        }
    }
    
    void addOption(String o) {
        this.options.add(o);
    }
    
    public boolean eval(String x) {
        if (x == null) 
            return false;
        return x.equals(options.get(correct));
    }
    
    public String toString() {
        String str = text+"\n";
        for (String o : options) {
            str += "\t"+o+"\n";
        }
        return str;
    }
} 