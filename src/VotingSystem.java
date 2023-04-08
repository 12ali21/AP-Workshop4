import java.util.ArrayList;
import java.util.Random;

public class VotingSystem {
    private ArrayList<Voting> votingList;

    public void createVoting(String question, boolean isAnonymous, int type, ArrayList<String> choices){
        Voting voting= new Voting(type,question,isAnonymous);
        for ( String i: choices  ) {
            voting.createChoice(i);
        }
        votingList.add(voting);

    }
    public Voting getVoting(int index){
       return votingList.get(index);
    }

    public ArrayList<Voting> getVotingList() {
        return votingList;
    }
    public void printResults(int index){
        votingList.get(index).printResults();

    }
    public void printVoters(int index){
        votingList.get(index).printVoters();

    }
    public void printVoting(int index){
        System.out.println("questions:");
        System.out.println(votingList.get(index).getQuestion());
        System.out.println("choices:");
        System.out.println(votingList.get(index).getChoices());

    }
    public void vote(int index, Person voter){
        Random random=new Random();
        Voting currentVoting = votingList.get(index);
        ArrayList<String> availableChoices = currentVoting.getChoices();
        ArrayList<String> choices = new ArrayList<>();
        choices.add(availableChoices.get(random.nextInt(availableChoices.size())));
        currentVoting.vote(voter,choices);
    }
    public void vote(int index, Person voter, ArrayList<String> choices){
        votingList.get(index).vote(voter, choices);
    }

}
