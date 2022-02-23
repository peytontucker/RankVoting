import java.util.Scanner;

public class RankVoting {
    public static void main(String[] args) {
        RankVoting session = new RankVoting();
        session.run();
    }

    public void run() {
        VotingSystem system = new VotingSystem();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Rank Voting system.");
        
        while (true) {

            clearScreen();
            System.out.println("\n\n\n\nWhat would you like to do?");
            displayMainMenu();

            while(!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Invalid input, please enter a number.");
            }

            //read int
            int choice = Integer.parseInt(scanner.next());
            scanner.nextLine();

            switch (choice) {
                case 1:
                    system.enterEntries();
                    break;
                case 2:
                    system.registerVoters();
                    break;
                case 3:
                    system.beginVote();
                    break;
                case 4:
                    system.viewResults();
                    break;
                default:
                    System.out.println("Please enter a valid entry.");
            }
        }
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    public void displayMainMenu() {
        System.out.println("1) Enter Voting Entries\n2) Register Voters\n3) Begin Rank Vote\n4) View Voting Results");
    }
}