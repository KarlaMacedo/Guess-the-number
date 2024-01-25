import java.util.ArrayList; // to use a dynamic list of elements

// abstract player class
public abstract class Player { // Defines the abstract class Player. Serves as a base for specific classes of players
    // Attributes
    protected String name; // Protected attribute name that will store the players name
    protected ArrayList<Integer> guesses; // Protected attribute ArrayList that will store players guess history as a list of integers

    // Constructor
    public Player(String name) { // Defines the constructor of the Player class. Executed when creating an instance of any class it inherits
        this.name = name; // Initialize name
        this.guesses = new ArrayList<>(); // Initialize guesses
    }

    // Abstract method to make a guess
    public abstract int makeGuess(); // Declare the abstract method makeGuess(). Its subclasses must do their own implementation

    // Method to get player name
    public String getName() { // Defines the method to obtain player´s name
        return name; // Returns players name
    }
    // Method to get guess history
    public ArrayList<Integer> getGuesses() { // Defines the method to obtain player's guess history
        return guesses; // Returns player´s guess history
    }

    // Method to record a guess
    public void recordGuess(int guess) { // Defines the method to record player's guess
        guesses.add(guess); // Adds the guess to the history
    }
}