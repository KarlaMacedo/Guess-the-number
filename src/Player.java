import java.util.ArrayList; // to use a dynamic list of elements

public abstract class Player { // Defines the abstract class Player. Serves as a base for specific classes of players
    // Attributes
    protected String name;
    protected ArrayList<Integer> guesses;

    // Constructor
    public Player(String name) { // Executed when creating an instance of any class it inherits
        this.name = name; // Initialize name
        this.guesses = new ArrayList<>(); // Initialize guesses
    }

    // Abstract method to make a guess. Its subclasses must do their own implementation
    public abstract int makeGuess();

    // Method to get player name
    public String getName() {
        return name;
    }

    // Method to get guess history
    public ArrayList<Integer> getGuesses() {
        return guesses;
    }

    // Method to record a guess
    public void recordGuess(int guess) {
        guesses.add(guess);
    }
}