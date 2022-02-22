import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Voter {
    
    public String name;
    public HashMap<String, Integer> votes;

    public Voter(String name) {
        this.name = name;
    }

    public HashMap<String, Integer> getVotes() {
        return this.votes;
    }

    public void vote() {
        displayVotes();

        System.out.println("Please enter the numbers of the two entries you would like to switch, and then press enter.");

        
    }

    public void displayVotes() {
        int i = 1;
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            System.out.println(i + ") " + "\t" + entry.getKey());
        }
    }
}
