import java.util.Random;

public class ComputerPlayer extends Player { // Defines ComputerPlayer class that inherits from Player abstract class
    private final Random random; // Creates an instance of the Random class for generating random numbers

    // Constructor
    public ComputerPlayer() { // Defines constructor of ComputerPlayer class. When instantiate a ComputerPlayer object, this constructor will be executed
        super("Computer"); // Calls the constructor of the base class (Player) and sets the default name to "Computer"
        this.random = new Random(); // Initializes the Random instance for generating random numbers
    }

    @Override // This method overrides a method of the base class.
    public int makeGuess() { // Defines the method, which generates a random guess and returns it
        int computerGuess = random.nextInt(100) + 1;// Generates a random guess between 1 and 100 (inclusive) and assign in computerGuess integer variable

        recordGuess(computerGuess);// Records the guess in the history

        return computerGuess;// Returns the randomly generated guess
    }
}