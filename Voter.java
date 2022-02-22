import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Voter {
    
    public String name;
    public String[] votes;

    public Voter(String name) {
        this.name = name;
    }

    public void setVotes(ArrayList<String> entries) {
        votes = new String[entries.size()];

        for (int i = 0; i < votes.length; i++) {
            votes[i] = entries.get(i);
        }
    }

    public String[] getVotes() {
        return this.votes;
    }

    public void vote() {
        displayVotes();

        System.out.println("Please enter the numbers of the two entries you would like to switch, and then press enter.");
        
        
    }

    public void displayVotes() {
        
    }
}
