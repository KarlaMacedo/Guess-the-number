import java.util.Random; // to generate random numbers
import java.util.ArrayList; // to use a dynamic list of elements

public class ComputerPlayer extends Player { // Defines ComputerPlayer class that inherits from Player abstract class
    //Instance of immutable and private variables
    private final Random random;
    private final int targetNumber;

    // Constructor. When instantiate a ComputerPlayer object, will be executed
    public ComputerPlayer(int targetNumber) {
        super("\uD83D\uDDA5\uFE0F Computer"); // Calls constructor of the base class (Player) and sets default name
        this.random = new Random(); // Initializes instance for generating random numbers
        this.targetNumber = targetNumber; // Sets the targetNumber for the game
    }

    @Override // This method overrides a method of the base class.
    // Method to make computer´s guess, call a method to generate a random guess with intelligent, record it and returns it
    public int makeGuess() {
        int computerGuess = generateIntelligentGuess();

        recordGuess(computerGuess);// Method of the base class (Player)

        return computerGuess;
    }

    //Method to make computer intelligent based on past Computer´s guesses
    int generateIntelligentGuess() {
        int previousGuess = getPreviousGuess();

        if (previousGuess < 0) {
            return random.nextInt(100) + 1; // Initial guess if no previous guess is available
        } else {
            if (previousGuess < targetNumber) {
                return previousGuess + random.nextInt(10) + 1;
            } else {
                return previousGuess - random.nextInt(10) - 1;
            }
        }

    }

    // Method to get the previous guess from the history or -1 if no previous guess is available
    private int getPreviousGuess() {
        ArrayList<Integer> guesses = getGuesses(); // Method of the base class (Player)

        if (!guesses.isEmpty()) {
            return guesses.getLast(); //last element in the list
        }

        return -1;
    }
}