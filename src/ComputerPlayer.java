import java.util.Random; // to generate random numbers
import java.util.ArrayList; // to use a dynamic list of elements

public class ComputerPlayer extends Player { // Defines ComputerPlayer class that inherits from Player abstract class
    private final Random random; // Creates an instance of the Random class for generating random numbers
    private final int targetNumber; // Stores the target number for the game

    // Constructor
    public ComputerPlayer(int targetNumber) { // Defines constructor of ComputerPlayer class. When instantiate a ComputerPlayer object, this constructor will be executed
        super("Computer"); // Calls the constructor of the base class (Player) and sets the default name to "Computer"
        this.random = new Random(); // Initializes the Random instance for generating random numbers
        this.targetNumber = targetNumber; // Sets the targetNumber for the game
    }

    @Override // This method overrides a method of the base class.
    // Method to make computer´s guess
    public int makeGuess() { // Defines the method, which generates a random guess and returns it
        int computerGuess = generateIntelligentGuess(); // Calls the generateIntelligentGuess method to calculate the computer's next guess

        recordGuess(computerGuess);// Records the guess in the history

        return computerGuess;// Returns the randomly generated guess
    }

    //Method to make computer intelligent
    private int generateIntelligentGuess() { // Defines the method to calculate the computer's intelligent guess
        int previousGuess = getPreviousGuess(); // Gets the previous guess from the history by getPreviousGuess method

        // Adjust the guess based on the relationship between the previous guess and the target number
        if (previousGuess > 0) {
            if (previousGuess < targetNumber) {
                return previousGuess + random.nextInt(10) + 1; // If previous guess was too low, make a higher guess
            } else {
                return previousGuess - random.nextInt(10) - 1; // If previous guess was too high, make a lower guess
            }
        } else {
            return random.nextInt(100) + 1; // Initial guess if no previous guess is available
        }
    }

    // Method to get the previous guess from the history
    private int getPreviousGuess() { // Defines the method to get the previous guess from the history
        // Retrieve the last guess from the guess history
        ArrayList<Integer> guesses = getGuesses(); // Gets the guess history
        if (!guesses.isEmpty()) {
            return guesses.getLast(); // Returns the last element in the list (last guess)
        }
        return -1; // Return -1 if no previous guess is available
    }
}