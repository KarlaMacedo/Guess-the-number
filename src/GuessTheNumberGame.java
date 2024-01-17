public class GuessTheNumberGame { // Defines class
    public static void main(String[] args) { // Starts main method (this method, will be executed in program start)
        Player player = new HumanPlayer(); // Creates an instance of the HumanPlayer class on variable of type Player named player, because HumanPlayer is a Player´s subclass
        System.out.println("¡Welcome, " + player.getName() + "!"); // Welcome message with player´s name obtained to getName() method of the player instance
    }
}