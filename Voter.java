import java.util.ArrayList;
import java.util.Scanner;

public class Voter {
    
    public String name;
    public String[] votes;
    public Scanner scanner;

    public Voter(String name) {
        this.name = name;
        this.scanner = new Scanner(System.in);
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
        RankVoting.clearScreen();
        displayVotes();
        System.out.println(this.name + ", it's your turn to vote!");
        System.out.println("Please enter the numbers of the two entries you would like to switch. Type \"quit\" when you're finished sorting.\n");
        

        while (true) {
            System.out.println("First number:");

            int firstIndexToSwitch = getValidIndex();
            if (firstIndexToSwitch == -1) return;

            System.out.println("Second number:");

            int secondIndexToSwitch = getValidIndex();
            if (secondIndexToSwitch == -1) return;
            
            switchEntries(firstIndexToSwitch, secondIndexToSwitch);
            
            RankVoting.clearScreen();
            displayVotes();
        }

    }

    public void displayVotes() {
        for (int i = 0; i < votes.length; i++) {
            System.out.println(i+1 + ") " + votes[i]);
        }
        System.out.println();
    }

    public void switchEntries(int first, int second) {
        String temp = votes[first];
        votes[first] = votes[second];
        votes[second] = temp;
    }

    public int getValidIndex() {
        int input = 0;

        while(scanner.hasNext()) {
            if (scanner.hasNext("quit")) return -1;
            if (scanner.hasNextInt()) {
                input = Integer.parseInt(scanner.next())-1;
                if ((input < votes.length) && input > -1) break;
            }

            System.out.println("Invalid input, please enter a number.");
            scanner.nextLine();
        }
        return input;
    }
}
