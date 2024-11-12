package backend.academy.game.stages.game;

import backend.academy.game.input.impl.HangmanGameInputSource;
import backend.academy.game.settings.DifficultyLevel;
import backend.academy.game.settings.HangmanGameSettings;
import backend.academy.game.settings.WordsCategory;
import backend.academy.game.stages.game.impl.ConsoleHangmanGame;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HangmanGameTest {

    @Test
    public void perfectGameTest() {
        HangmanGameSettings gameSettings = new HangmanGameSettings(WordsCategory.TEST, DifficultyLevel.PEACEFUL);
        HangmanGameInputSource mockInputSource = Mockito.mock(HangmanGameInputSource.class);
        Mockito.when(mockInputSource.getNextInput()).thenReturn(
            'т', 'е', 'с', 'т', 'о', 'в', 'ы', 'й', 'т', 'е', 'с', 'т'
        );
        ConsoleHangmanGame game = new ConsoleHangmanGame(gameSettings, mockInputSource);
        String expectedWord = "тестовыйтест";
        String word = game.word();

        game.startGame();

        assertEquals(word, expectedWord);
        char[] charArray = expectedWord.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            assertEquals(game.wordLetters()[i], charArray[i]);
            assertTrue(game.alreadyGuessedLetters().contains(charArray[i]));
        }
        assertTrue(game.userWon());
    }

    @Test
    public void finishedGameWithMistakesTest() {
        HangmanGameSettings gameSettings = new HangmanGameSettings(WordsCategory.TEST, DifficultyLevel.PEACEFUL);
        HangmanGameInputSource mockInputSource = Mockito.mock(HangmanGameInputSource.class);
        Mockito.when(mockInputSource.getNextInput())
            .thenReturn('я', 'к', 'т', 'е', 'с', 'р', 'т', 'о', 'в', 'ы', 'й', 'т', 'е', 'с', 'т');

        ConsoleHangmanGame game = new ConsoleHangmanGame(gameSettings, mockInputSource);
        game.startGame();

        char[] usedLetters = "яктесртовыйтест".toCharArray();
        for (char ch : usedLetters) {
            assertTrue(game.alreadyGuessedLetters().contains(ch));
        }

        assertTrue(game.userWon());

    }

    @Test
    public void lostBecauseOfAttemptsTest() {
        //всего 8 попыток
        HangmanGameSettings gameSettings = new HangmanGameSettings(WordsCategory.TEST, DifficultyLevel.MEDIUM);
        HangmanGameInputSource mockInputSource = Mockito.mock(HangmanGameInputSource.class);
        Mockito.when(mockInputSource.getNextInput())
            .thenReturn('я', 'к', 'т', 'е', 'с', 'р', 'з', 'и', 'н', 'х', 'ь');
        ConsoleHangmanGame game = new ConsoleHangmanGame(gameSettings, mockInputSource);

        game.startGame();

        assertFalse(game.userWon());
    }
}
