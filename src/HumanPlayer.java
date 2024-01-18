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

    @Override // This method overrides a method of the base class
    public int makeGuess() { // Defines the method, which requests user's guess and returns the entered value as an integer
        Scanner scanner = new Scanner(System.in); // New scanner integer input tu obtain user data enter
        System.out.print(name + ", enter a number between 1 and 100 to guess the selected number: "); // Print player name and message to request the guess
        int guess = scanner.nextInt(); // Gets the guess entered by the user
        recordGuess(guess); // Records the guess in the history
        return guess; // Returns entered integer value
    }
}