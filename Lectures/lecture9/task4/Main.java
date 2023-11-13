/**
 * A Main class that uses the classes Question, Quiz, and Assesment 
 *
 * @author Gabriela Montoya
 * @version 1.4, 2023-11-03
 */
 
class Main {
    
    public static void main(String[] args) {
    
        String[] questions = {"Is the class String immutable?", 
              "How many methods can you use on an instace of type Catalog?" };
        String[][] options = { { "No", "Yes"},
                            {"0", "1-4", "4-7", "7 or more"}};
        int[] solution = { 1, 3 };
        Quiz quiz = new Quiz();
        
        for (int i = 0; i < questions.length; i++) {
            Question q =  new Question(questions[i]);
            String[] opts = options[i];
            for (int j = 0; j < opts.length; j++) {
                q.addOption(opts[j]);
            }
            q.addCorrect(solution[i]);
            quiz.addQuestion(q);
        }
        Assessment a = new Assessment(quiz);
        
        a.take();
    }
}