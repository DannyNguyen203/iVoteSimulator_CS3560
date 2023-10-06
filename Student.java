import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Student {
    private String userID;
    ArrayList<String> answer = new ArrayList<>();
    
    public Student() {
        userID = generateRanID();
    }

    private String generateRanID() {
        Random random = new Random();
        return String.valueOf(10000 + random.nextInt(90000));
    }

    public ArrayList<String> getAnswer(){
        return answer;
    }


    public ArrayList<String> submitAnswer(Question question){
        Random r = new Random();
        ArrayList<String> answerChoices = question.getAnswerChoices();
        int numChoices = answerChoices.size();

        // Choose Multiple Choice or Not
        if (question.getQuestionType().compareToIgnoreCase("Multiple")==0){
            // Choose number of answers selected
            int numChosenAnswers = r.nextInt(numChoices)+1;
            ArrayList<Integer> selectedAnswers = new ArrayList<Integer>();

            // Create random index locations
            for (int i=0; i<numChoices; i++) {
                selectedAnswers.add(i);
            }
            Collections.shuffle(selectedAnswers);

            // Use random index locations to choose answers for multiple choice
            for (int i = 0; i <numChosenAnswers; i++ ) {
                answer.add(answerChoices.get(selectedAnswers.get(i)));
            }


        } else if (question.getQuestionType().compareToIgnoreCase("Single")==0){
            // Choose a random asnwer from answer choices as selected
            answer.add(answerChoices.get(r.nextInt(numChoices)));
        }

        return answer;
    }
}