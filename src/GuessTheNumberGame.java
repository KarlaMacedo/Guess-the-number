public class GuessTheNumberGame { // Defines class
    public static void main(String[] args) { // Starts main method (this method, will be executed in program start)
        GuessTheNumberGame game = new GuessTheNumberGame();
        System.out.println("Welcome to the Guess Number Game!");
        Player[] players = {new ComputerPlayer(), new HumanPlayer()};
        // Player player = new HumanPlayer(); // Creates an instance of the HumanPlayer class on variable of type Player named player, because HumanPlayer is a Player´s subclass
        int targetNumber = game.targetNumber(); // Generates a random target number by calling the 'targetNumber' method of the 'game' instance
        //System.out.println("¡Welcome, " + player.getName() + "! "); // Welcome message with player´s name obtained to getName() method of the player instance



        for (int turn = 1; ; turn++) {
            Player player = players[turn % 2]; // Alternating turns between players
            System.out.println("Turn " + turn + ": It's " + player.getName() + "'s turn! ");

            int guess = player.makeGuess();

            if (checkGuess(guess, targetNumber)) { // Calls the makeGuess() method of the 'player' instance, checks if the guess is correct by calling the checkGuess method
                System.out.println(player.getName() + " you chose: " + guess + ". You GUESSED the number. ¡CONGRATULATIONS!"); // Prints a message if the guess is correct
                displayGameSummary(turn, player, targetNumber);
                break; // Exits the loop if the guess is correct
            } else {
                System.out.println(player.getName() + " chose: " + guess + ". The number is "
                        + ((guess < targetNumber) ? "HIGHER" : "LOWER") + ". Try again!");
            }
        }
    }

    // Method to generate a random target number
    private int targetNumber() {
        return (int) (Math.random() * 100) + 1; // Generates a random number between 1 and 100 (inclusive)
    }

    // Method to verify player´s guess
    private static boolean checkGuess(int guess, int targetNumber) {
        return guess == targetNumber;
    }

    private static void displayGameSummary(int turns, Player player, int targetNumber) {
        System.out.println("GAME SUMMARY:");
        System.out.println("Player: " + player.getName());
        System.out.println("Guessed number: " + targetNumber);
        System.out.println("Number of total turns in the game: " + turns);
        System.out.println("Number of winner's attempts: " + player.getGuesses().size()); // Count the number of guesses
        System.out.println("Winner's guesses: " + player.getGuesses());
    }
}