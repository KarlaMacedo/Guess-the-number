import java.util.Scanner; // To read user data enter

public class HumanPlayer extends Player { // Defines HumanPlayer class that inherits from Player abstract class

    //Constructor
    public HumanPlayer() { // Defines constructor of HumanPlayer class. When instantiate a HumanPlayer object, this constructor will be executed
        super("Player"); // Calls constructor of base class (Player) and gives it default argument of name
        setName(); // Method called to request the player's name and assign it to the name variable
    }

    private void setName() { // Defines the method to request the player's name and assign it to the name variable
        Scanner scanner = new Scanner(System.in); // New scanner integer input tu obtain user data enter
        System.out.print("What is your name? "); // Print the question
        this.name = scanner.nextLine(); // Assigns user data enter to the name variable
    }

    @Override // This method overrides a method of the base class.
    public int makeGuess() { // Defines the method, which requests user guess and returns the entered value as an integer
        Scanner scanner = new Scanner(System.in); // New scanner integer input tu obtain user data enter
        System.out.print(name + ", enter your guess (between 1 and 100): "); // Print player name and message to request the guess
        return scanner.nextInt(); // Returns entered integer value
    }
}