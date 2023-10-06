import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class VotingService {
    Question question = new Question();
    ArrayList<Student> studentList;
    Map<String, Integer> answerCount = new HashMap<>();

    public void displayResults(){
        String questionType = question.getQuestionType();
        System.out.println(studentList.size());





        System.out.println("Results for " + questionType + ": ");


        for (int i =0; i<studentList.size(); i++){
            ArrayList<String> studentAnswers = studentList.get(i).getAnswer();

            System.out.print("Answer for Student " + i + ": ");
            for (int j = 0; j < studentList.get(i).getAnswer().size(); j++) {
                String answer = studentList.get(i).getAnswer().get(j);
                System.out.print(answer);
                answerCount.put(answer, answerCount.getOrDefault(answer, 0) + 1);
            }
            System.out.println();

        }

        for (int i = 0; i < question.getAnswerChoices().size(); i++){
            System.out.println(question.getAnswerChoices().get(i) + ": " + answerCount.get(question.getAnswerChoices().get(i)));
        }



    }



    public void configQuestion(Scanner scnr){
        String questionType = "";

        //while (!questionType.equalsIgnoreCase("Multiple") && !questionType.equalsIgnoreCase("Single")){
        System.out.println("Enter Question Type (Multiple or Single): ");
        questionType = scnr.nextLine();
        //}

        question.setQuestionType(questionType);
    }



    public void configAnswers(Scanner scnr){
        ArrayList<String> answers = new ArrayList<>();
        String answerChoices = "";

        while (answerChoices.compareToIgnoreCase("Multiple") != 0 || answerChoices.compareToIgnoreCase("Single") != 0){
            System.out.println("Enter 0 to quit");
            System.out.println("Add answer chioce: ");
            answerChoices = scnr.nextLine();
            if (answerChoices.compareTo("0") == 0){
                break;
            }
            answers.add(answerChoices);

        }


        question.setAnswerChoices(answers);
    }


    public void generateStudentAnswers(){

        int numStudents = getNumStudents(20,30);

        studentList = new ArrayList<Student>(numStudents);

        for (int i =0; i<numStudents; i++){
            Student student = new Student();
            studentList.add(student);
        }

        for (int i = 0; i<numStudents; i++){
            studentList.get(i).submitAnswer(question);
        }        
    }



    public int getNumStudents(int lowerBound, int max){

        Random rand = new Random();
        int numStudents = rand.nextInt(max-lowerBound+1)+lowerBound;
        return numStudents;
    }

    
}
