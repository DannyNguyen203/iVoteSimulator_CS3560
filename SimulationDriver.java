import java.util.Scanner;

public class SimulationDriver {
    public static void main(String[] args){
        VotingService voteSimulator = new VotingService();
        Scanner scnr = new Scanner(System.in);

        voteSimulator.configQuestion(scnr);
        voteSimulator.configAnswers(scnr);
        voteSimulator.generateStudentAnswers();
        voteSimulator.displayResults();

        scnr.close();

    }


}
