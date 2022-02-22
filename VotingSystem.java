import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class VotingSystem {
    public ArrayList<Voter> voters;
    public Scanner scanner;
    public ArrayList<String> entries;
    public HashMap<String, Integer> results;

    public VotingSystem() {
        this.voters = new ArrayList<Voter>();
        this.scanner = new Scanner(System.in);
        this.entries = new ArrayList<String>();
    }

    public void enterEntries() {
        boolean moreToAdd = true;
        while (moreToAdd) {
        
        System.out.println("Please enter voting entry.");
        String entry = scanner.nextLine();

        entries.add(entry);

        System.out.println("Would you like to add another entry? Y/N");

        String input = scanner.nextLine();

        while (!input.toLowerCase().equals("y") && !input.toLowerCase().equals("n")) {
            System.out.println("Please respond Y/N.");
            input = scanner.nextLine();
        }

        if (input.toLowerCase().equals("y")) moreToAdd = true;
        if (input.toLowerCase().equals("n")) moreToAdd = false;
        }
    }

    public void registerVoters() {
        boolean moreToAdd = true;
        while (moreToAdd) {
        
        System.out.println("Please enter the voter's name.");
        String name = scanner.nextLine();

        Voter voter = new Voter(name);
        voters.add(voter);

        System.out.println("Would you like to add another voter? Y/N");

        String input = scanner.nextLine();

        while (!input.toLowerCase().equals("y") && !input.toLowerCase().equals("n")) {
            System.out.println("Please respond Y/N.");
            input = scanner.nextLine();
        }

        if (input.toLowerCase().equals("y")) moreToAdd = true;
        if (input.toLowerCase().equals("n")) moreToAdd = false;
        }
    }

    public void beginVote() {
        for(Voter voter : voters) {
            voter.setVotes(entries);
            System.out.println("\n\n\n\n\n\n\n\n" + voter.name + ", it's your turn to vote!");
            voter.vote();
        }
    }

    public void viewResults() {
        scanner.close();

        results = new HashMap<String, Integer>();

        //load all voters' votes into results hashmap
        for (Voter voter : voters) {
            for (int i = 0; i < voter.votes.length; i++) {
                int currentScore = results.get(voter.votes[i]) == null ? 0:results.get(voter.votes[i]);
                results.put(voter.votes[i], (currentScore + voter.votes.length-i));
            }
        }

        System.out.println("Here are the final point totals!");

        String[] orderedKeys = new String[results.size()];

        //populate orderedKeys with keys
        int i = 0;
        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            orderedKeys[i] = entry.getKey();
            i++;
        }
    
        //sort orderedKeys
        boolean hasSwapped = true;
        while (hasSwapped) {
            hasSwapped = false;
            for (int k = 0; k < orderedKeys.length-1; k++) {
                if (results.get(orderedKeys[k]) < results.get(orderedKeys[k+1])) {
                    String temp = orderedKeys[k];
                    orderedKeys[k] = orderedKeys[k+1];
                    orderedKeys[k+1] = temp;
                    hasSwapped = true;
                }
            }
        }

        //print each index in the (now sorted) orderedKeys array and cross-reference with results hashmap to print total votes cast for each entry
        for (int j = 0; j < orderedKeys.length; j++) {
            System.out.println(orderedKeys[j] + ": " + results.get(orderedKeys[j]) + " votes");
        }
        System.exit(0);
    }
}
