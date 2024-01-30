import java.util.Scanner; // To read user data enter

public class HumanPlayer extends Player { // Defines HumanPlayer class that inherits from Player abstract class

    //Constructor
    public HumanPlayer() { // Defines constructor of HumanPlayer class. When instantiate a HumanPlayer object, this constructor will be executed
        super("Player"); // Calls constructor of base class (Player) and gives it default argument of name
        setName(); // Method called to request the player's name and assign it to the name variable
    }

    private void setName() { // Defines the method to request the player's name and assign it to the name variable
        Scanner scanner = new Scanner(System.in); // New scanner integer input tu obtain user data enter
        System.out.print("What is your name? \n"); // Print the question
        this.name = "\uD83D\uDE42" + scanner.nextLine(); // Assigns user data enter to the name variable
    }

    @Override // This method overrides a method of the base class
    public int makeGuess() { // Defines the method, which requests user's guess and returns the entered value as an integer
        Scanner scanner = new Scanner(System.in); // New scanner integer input tu obtain user data enter
        while (true) { // Enters an infinite loop to keep asking for a number until user enters a valid integer number
            System.out.print(name + ", enter a number between 1 and 100 to guess the selected number: "); // Print player name and message to request the guess
            if (scanner.hasNextInt()) { // Checks if the user enter is an integer number
                int guess = scanner.nextInt(); // Gets the guess entered by the user
                recordGuess(guess); // Records the guess in the history
                return guess; // Returns entered integer value and breaks the loop and exitíng the method
            } else { // if is not an integer number
                System.out.println("Invalid value. Please enter a ONLY integer numbers. ❌ \n"); // Prints an error message
                scanner.next();// Cleans the buffer to prevent an infinite loop
            }
        }
    }
}