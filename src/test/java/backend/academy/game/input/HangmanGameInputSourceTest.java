package backend.academy.game.input;

import backend.academy.game.input.impl.HangmanGameInputSource;
import backend.academy.game.input.impl.HangmanMenuInputSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HangmanGameInputSourceTest {

    @ParameterizedTest
    @ValueSource(strings = {"а", "в", "я", "А", "Я"})
    public void charInputValidationValidTest(String validChar) {
        assertTrue(HangmanGameInputSource.charInputIsValid(validChar));
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "1", "Z", "z", "a", "Az", "Фг", "ЯАая"})
    public void charInputValidationInvalidTest(String invalidChar) {
        assertFalse(HangmanGameInputSource.charInputIsValid(invalidChar));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "24", "1555", "9"})
    public void digitInputValidationValidTest(String validInput) {
        assertTrue(HangmanMenuInputSource.digitInputIsValid(validInput));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-12", "0", "asd", "A123", "1A2", "-a"})
    public void digitInputValidationInvalidTest(String invalidInput) {
        assertFalse(HangmanMenuInputSource.digitInputIsValid(invalidInput));
    }

}
