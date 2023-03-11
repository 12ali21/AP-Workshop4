import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Voting {
    private int type;
    private String question;
    private boolean isAnonymous;
    private ArrayList<Person> voters;
    private HashMap<String, HashSet<Vote>> choices;

    public Voting(int type, String question, boolean isAnonymous) {
        this.type = type;
        this.question = question;
        this.isAnonymous = isAnonymous;
    }




    public void createChoice(String choice){
        choices.put(choice,new HashSet<Vote>());
    }

    public ArrayList<String> getChoices(){
        if (choices.size()>0) {
            ArrayList<String> keyChoices = new ArrayList<String>(choices.keySet());
            return keyChoices;
        }
        return null;
    }

    public void printResults(){
        for (String choice:choices.keySet()) {
            System.out.println(choice + " count: " + choices.get(choice).size());
        }
    }

    public void printVoters(){
        for (String choice: choices.keySet()) {
            System.out.println(choice + " voters: ");
            for (Vote voter: choices.get(choice)) {
                System.out.print(voter.getVoter().toString() + " , ");

            }
            System.out.println();
        }
    }

    public void vote(Person voter, ArrayList<String> voter_choices){
        for (String choice : voter_choices) {
            Vote newVote = new Vote(voter, LocalDateTime.now().toString());
            HashSet<Vote> votes=choices.get(choice);
            votes.add(newVote);
            choices.put(choice, votes);
        }
    }

    public void vote(ArrayList<String> voter_choices){
        for (String choice : voter_choices) {
            Person voter=new Person("Anonymous","Anonymous");
            Vote newVote = new Vote(voter, LocalDateTime.now().toString());
            HashSet<Vote> votes=choices.get(choice);
            votes.add(newVote);
            choices.put(choice, votes);
        }

    }




















    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }

    public ArrayList<Person> getVoters() {
        return voters;
    }

    public void setVoters(ArrayList<Person> voters) {
        this.voters = voters;
    }


    public void setChoices(HashMap<String, HashSet<Vote>> choices) {
        this.choices = choices;
    }
}
