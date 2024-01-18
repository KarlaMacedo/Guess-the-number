public class GuessTheNumberGame { // Defines class
    public static void main(String[] args) { // Starts main method (this method, will be executed in program start)
        GuessTheNumberGame game = new GuessTheNumberGame();
        Player player = new HumanPlayer(); // Creates an instance of the HumanPlayer class on variable of type Player named player, because HumanPlayer is a Player´s subclass
        int targetNumber = game.targetNumber();
        System.out.println("¡Welcome, " + player.getName() + "! "); // Welcome message with player´s name obtained to getName() method of the player instance

        while (true) {
            if (checkGuess(player.makeGuess(), targetNumber)) {
                System.out.println(player.getName() + " you guessed the number. ¡Congratulations!");
                break;
            }
        }
    }

    private int targetNumber() {
        return (int) (Math.random() * 100) + 1;
    }

    // Method to verify player´s guess
    private static boolean checkGuess(int guess, int targetNumber) {
        if (guess == targetNumber) {
            System.out.println("¡Correct! The number was: " + targetNumber);
            return true;
        } else {
            System.out.println("The number is " + ((guess < targetNumber) ? "higher" : "lower") + ". Try again.");
            return false;
        }
    }
}