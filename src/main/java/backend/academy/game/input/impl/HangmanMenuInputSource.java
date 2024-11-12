package backend.academy.game.input.impl;

import backend.academy.game.input.ConsoleInputObject;
import backend.academy.game.input.InputSource;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressWarnings("RegexpSinglelineJava") @SuppressFBWarnings({"DM_BOXED_PRIMITIVE_FOR_PARSING"})
public class HangmanMenuInputSource implements InputSource<Integer> {
    public static boolean digitInputIsValid(String input) {
        try {
            return Integer.parseInt(input) > 0;
        } catch (NumberFormatException exc) {
            return false;
        }
    }

    public Integer getNextInput() {
        String input = ConsoleInputObject.inputScanner().nextLine();

        if (!digitInputIsValid(input)) {
            System.out.println("Неправильный формат ввода, необходимо ввести число");
            return getNextInput();
        }
        return Integer.valueOf(input);
    }
}
