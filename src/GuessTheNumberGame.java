public class GuessTheNumberGame { // Defines class
    public static void main(String[] args) { // Starts main method (this method, will be executed in program start)
        GuessTheNumberGame game = new GuessTheNumberGame();
        Player player = new HumanPlayer(); // Creates an instance of the HumanPlayer class on variable of type Player named player, because HumanPlayer is a Player´s subclass
        int targetNumber = game.targetNumber(); // Generates a random target number by calling the 'targetNumber' method of the 'game' instance
        System.out.println("¡Welcome, " + player.getName() + "! "); // Welcome message with player´s name obtained to getName() method of the player instance

        while (true) { // Enters the loop
            if (checkGuess(player.makeGuess(), targetNumber)) { // Calls the makeGuess() method of the 'player' instance, checks if the guess is correct by calling the checkGuess method
                System.out.println(player.getName() + " you guessed the number. ¡Congratulations!"); // Prints a message if the guess is correct
                break; // Exits the loop if the guess is correct
            }
        }
    }

    // Method to generate a random target number
    private int targetNumber() {
        return (int) (Math.random() * 100) + 1; // Generates a random number between 1 and 100 (inclusive)
    }

    // Method to verify player´s guess
    private static boolean checkGuess(int guess, int targetNumber) {
        if (guess == targetNumber) { // Checks if guess matches the target number
            System.out.println("¡Correct! The number was: " + targetNumber); // Print message
            return true; // Returns true if the guess is correct
        } else {
            System.out.println("The number is " + ((guess < targetNumber) ? "higher" : "lower") + ". Try again."); // Prints a message indicating whether guess is higher or lower than target number
            return false; // Returns false if the guess is incorrect
        }
    }
}