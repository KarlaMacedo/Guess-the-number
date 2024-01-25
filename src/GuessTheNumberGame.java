import java.util.Random;
public class GuessTheNumberGame { // Defines class
    public static void main(String[] args) { // Starts main method (this method, will be executed in program start)
        GuessTheNumberGame game = new GuessTheNumberGame(); // Initializes the GuessTheNumberGame instance for generating a new game and assign it in game variable
        System.out.println("Welcome to the Guess Number Game!"); // Welcome message
        int targetNumber = game.targetNumber(); // Generates a random target number by calling the 'targetNumber' method of the 'game' instance
        Player[] players = { new ComputerPlayer(targetNumber), new HumanPlayer() }; // Creates an array of players

        for (int turn = 1; ; turn++) { // Loop for alternating turns between players until the game is won
            Player player = players[turn % 2]; // Alternating turns between players
            System.out.println("Turn " + turn + ": It's " + player.getName() + "'s turn! "); // Who is the turn message

            int guess = player.makeGuess(); // Player makes a guess

            if (checkGuess(guess, targetNumber)) { // Calls the makeGuess() method of the 'player' instance, checks if the guess is correct by calling the checkGuess method
                System.out.println(player.getName() + " you chose: " + guess + ". You GUESSED the number. ¡CONGRATULATIONS!"); // Prints a message if the guess is correct
                displayGameSummary(turn, player, targetNumber); // Calls game summary, given it turn, player and targetNumber
                break; // Exits the loop if the guess is correct
            } else {
                System.out.println(player.getName() + " chose: " + guess + ". The number is " + ((guess < targetNumber) ? "HIGHER" : "LOWER") + ". Try again!"); // Prints a message indicating whether the guess is higher or lower than the target number
            }
        }
    }

    // Method to generate a random target number
    private int targetNumber() { // Defines the static boolean method to generate a random target number
        Random random = new Random(); // Creates an instance of the Random class
        return random.nextInt(100) + 1; // Generates a random number between 1 and 99 + 1 to include 100 ... (max-min)+min
        //return (int) (Math.random() * 100) + 1; // Generates a random number between 0-1 and * 100 + 1 to include 100
    }

    // Method to verify player´s guess
    private static boolean checkGuess(int guess, int targetNumber) { // Defines the static boolean method to verify player´s guess
        return guess == targetNumber;
    }

    // Method to get the game summary
    private static void displayGameSummary(int turns, Player player, int targetNumber) { // Defines the method to get the game summary
        System.out.println("GAME SUMMARY:");
        System.out.println("Player: " + player.getName());
        System.out.println("Guessed number: " + targetNumber);
        System.out.println("Number of total turns in the game: " + turns);
        System.out.println("Number of winner's attempts: " + player.getGuesses().size()); // Count the number of guesses
        System.out.println("Winner's guesses: " + player.getGuesses());
    }
}