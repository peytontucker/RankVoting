import java.util.ArrayList;
import java.util.Scanner;

public class VotingSystem {
    public ArrayList<Voter> voters;
    public static Scanner scanner;
    public ArrayList<String> entries;

    public VotingSystem() {
        this.voters = new ArrayList<Voter>();
        this.scanner = new Scanner(System.in);
    }

    public void enterEntries() {
        boolean moreToAdd = true;
        while (moreToAdd) {
        
        System.out.println("Please enter voting entry.");
        String entry = scanner.nextLine();

        entries.add(entry);

        System.out.println("Would you like to add another entry? Y/N");

        String input = scanner.nextLine();

        while (input.toLowerCase().equals("y") || input.toLowerCase().equals("n")) {
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

        while (input.toLowerCase().equals("y") || input.toLowerCase().equals("n")) {
            System.out.println("Please respond Y/N.");
            input = scanner.nextLine();
        }

        if (input.toLowerCase().equals("y")) moreToAdd = true;
        if (input.toLowerCase().equals("n")) moreToAdd = false;
        }
    }

    public void beginVote() {
        for(Voter voter : voters) {
            int i = 1;
            for(String entry : entries) {
                voter.votes.put(entry, i);
                i++;
            }
            voter.vote();
        }


    }

    public void viewResults() {

    }
}
