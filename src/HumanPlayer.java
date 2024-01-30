import java.util.Scanner; // To read user data enter

public class HumanPlayer extends Player { // Defines HumanPlayer class that inherits from Player abstract class

    //Constructor. When instantiate a HumanPlayer object, will be executed
    public HumanPlayer() {
        super("Player"); // Calls constructor of base class (Player) and gives it default name
        setName(); // Method called to request the player's name and save it
    }

    // Method to request the player's name and assign it to the name variable
    private void setName() {
        Scanner scanner = new Scanner(System.in); // Input to obtain user data enter
        System.out.print("What is your name? \n");
        this.name = "\uD83D\uDE42" + scanner.nextLine(); // Assigns user data enter to the name variable
    }

    @Override // This method overrides a method of the base class
    //Method to request user's guess and returns the entered value as an integer
    public int makeGuess() {
        Scanner scanner = new Scanner(System.in); // Input to obtain user data enter

        while (true) { // Enters an infinite loop to keep asking for a number until user enters a valid integer number
            System.out.print(name + ", enter a number between 1 and 100 to guess the selected number: ");

            if (scanner.hasNextInt()) { // Checks if the user enter is an integer number
                int guess = scanner.nextInt();

                recordGuess(guess); // Method of the base class (Player)

                return guess; // Breaks the loop and exitíng the method
            } else {
                System.out.println("Invalid value. Please enter a ONLY integer numbers. ❌ \n");

                scanner.next();// Cleans to prevent an infinite loop
            }
        }
    }
}