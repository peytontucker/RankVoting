import java.util.ArrayList;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);

        displayVotes();

        System.out.println("Please enter the numbers of the two entries you would like to switch. Type \"quit\" when you're finished sorting.\n");
        

        while (true) {

            System.out.println("First number:");

            while (!scanner.hasNext("quit") && !scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Please enter a valid option.");
            }

            if (scanner.hasNext("quit")) {
                System.out.println("quit detected");
                return;
            }

            int firstIndexToSwitch = Integer.parseInt(scanner.next())-1;

            System.out.println("Second number:");

            while (!scanner.hasNext("quit") && !scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Please enter a valid option.");
            }

            if (scanner.hasNext("quit")) {
                System.out.println("quit detected");
                return;
            }

            int secondIndexToSwitch = Integer.parseInt(scanner.next()) - 1;
            
            switchEntries(firstIndexToSwitch, secondIndexToSwitch);
            displayVotes();
        }

    }

    public void displayVotes() {
        for (int i = 0; i < votes.length; i++) {
            System.out.println(i+1 + ") " + votes[i]);
        }
    }

    public void switchEntries(int first, int second) {
        String temp = votes[first];
        votes[first] = votes[second];
        votes[second] = temp;
    }
}
