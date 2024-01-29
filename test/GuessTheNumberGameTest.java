import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class GuessTheNumberGameTest {

    @Test
    public void testTargetNumber() {
        GuessTheNumberGame game = new GuessTheNumberGame();
        int targetNumber = game.targetNumber();
        assertTrue(targetNumber >= 1 && targetNumber <= 100);
    }

    @Test
    public void testCheckGuessCorrect() {
        GuessTheNumberGame game = new GuessTheNumberGame();
        int targetNumber = game.targetNumber();
        assertTrue(GuessTheNumberGame.checkGuess(targetNumber, targetNumber));
    }

    @Test
    public void testCheckGuessIncorrect() {
        GuessTheNumberGame game = new GuessTheNumberGame();
        int targetNumber = game.targetNumber();
        assertFalse(GuessTheNumberGame.checkGuess(targetNumber - 1, targetNumber));
    }

    @Test
    public void testComputerPlayerMakeGuess() {
        Player computerPlayer = new ComputerPlayer(20);
        int guess = computerPlayer.makeGuess();
        assertTrue(guess >= 1 && guess <= 100);
    }

    @Test
    public void testGenerateIntelligentGuess() {
        int targetNumber = 50;
        ComputerPlayer computerPlayer = new ComputerPlayer(targetNumber);

        int previousGuess1 = 25;
        int previousGuess2 = 75;

        int distance1 = (previousGuess1 - targetNumber);
        int distance2 = (previousGuess2 - targetNumber);

        computerPlayer.recordGuess(previousGuess1);
        computerPlayer.recordGuess(previousGuess2);

        int intelligentGuess = computerPlayer.generateIntelligentGuess();

        assertTrue((intelligentGuess - targetNumber) < (distance1) || (intelligentGuess - targetNumber) < (distance2));
    }

    @Test
    public void testPlayerNameValidation() {
        String playerName = "John Doe";
        provideMockedInput(playerName);

        HumanPlayer humanPlayer = new HumanPlayer();

        assertEquals(playerName, humanPlayer.getName());
    }

    private void provideMockedInput(String input) {
        InputStream mockedInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(mockedInputStream);
    }
    @Test
    public void testHumanPlayerMakeGuess() {
        HumanPlayer humanPlayer = mock(HumanPlayer.class);

        when(humanPlayer.makeGuess()).thenReturn(5);

        int guess = humanPlayer.makeGuess();

        assertEquals(5, guess);
    }

}