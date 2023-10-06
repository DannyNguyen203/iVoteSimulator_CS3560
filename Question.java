import java.util.ArrayList;

public class Question {
    public ArrayList<String> answerChoices;
    public String questionType;

    public ArrayList<String> getAnswerChoices() {
        return answerChoices;
    }

    public void setAnswerChoices(ArrayList<String> newChoices) {
        answerChoices = newChoices;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String newQuestionType) {
        questionType = newQuestionType;
    }

}
