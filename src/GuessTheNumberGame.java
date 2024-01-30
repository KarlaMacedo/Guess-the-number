import java.util.Random; // to generate a random numbers
public class GuessTheNumberGame {
    public static void main(String[] args) { //main method will be executed in program start
        GuessTheNumberGame game = new GuessTheNumberGame(); // Initializes the GuessTheNumberGame instance for generating a new game and assign it in game object

        System.out.println("❓⁉\uFE0F  Welcome to the Guess Number Game!  ❓⁉\uFE0F");

        int targetNumber = game.targetNumber(); // Generates a random target number by calling the 'targetNumber' method
        Player[] players = { new ComputerPlayer(targetNumber), new HumanPlayer() }; // "Composition". Creates an array of players

        for (int turn = 1; ; turn++) { // Loop for alternating turns between players until the game is won
            Player player = players[turn % 2];
            System.out.println("Turn " + turn + ": It's " + player.getName() + "'s turn! ");

            int guess = player.makeGuess(); // Player makes a guess

            if (checkGuess(guess, targetNumber)) { // Checks if the guess is correct by calling the checkGuess method and passing the call to makeGuess() method
                System.out.println(player.getName() + " you chose: " + guess + ". You GUESSED the number. \uD83D\uDE4C ¡CONGRATULATIONS! \uD83E\uDD47 \n");
                displayGameSummary(turn, player, targetNumber); // Calls game summary
                break; // Exits the loop if the guess is correct
            } else {
                System.out.println("\n" + player.getName() + " chose: " + guess + ". The number is " + ((guess < targetNumber) ? "HIGHER ⤴\uFE0F" : "LOWER ⬇\uFE0F") + ". Try again! \n");
            }
        }
    }

    // Method to generate a random target number
    int targetNumber() {
        Random random = new Random(); // Creates an instance of the Random class on the random object
        return random.nextInt(100) + 1; // 1 and 99 + 1 to include 100 ... (max-min)+min
        //return (int) (Math.random() * 100) + 1; // between 0-1 and * 100 + 1 to include 100
    }

    // Static Boolean Method to verify player´s guess
    static boolean checkGuess(int guess, int targetNumber) {
        return guess == targetNumber;
    }

    // Method to get the game summary
    static void displayGameSummary(int turns, Player player, int targetNumber) {
        System.out.println(" \uD83C\uDFC6 GAME SUMMARY \uD83C\uDFC6");
        System.out.println("Winner: " + player.getName());
        System.out.println("Guessed number: " + targetNumber);
        System.out.println("Number of total turns in the game: " + turns);
        System.out.println("Number of winner's attempts: " + player.getGuesses().size()); // Count the number of guesses
        System.out.println("Winner's guesses: " + player.getGuesses());
    }
}