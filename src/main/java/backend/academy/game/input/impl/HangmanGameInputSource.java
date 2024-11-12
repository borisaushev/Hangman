package backend.academy.game.input.impl;

import backend.academy.game.input.ConsoleInputObject;
import backend.academy.game.input.InputSource;

@SuppressWarnings("RegexpSinglelineJava")
public class HangmanGameInputSource implements InputSource<Character> {
    public static boolean charInputIsValid(String input) {
        return input.length() == 1 && input.charAt(0) <= 'я' && input.charAt(0) >= 'А';
    }

    @Override
    public Character getNextInput() {
        String input = ConsoleInputObject.inputScanner().nextLine();

        if (!charInputIsValid(input)) {
            System.out.println("Неправильный формат ввода, необходимо ввести Букву");
            return getNextInput();
        }

        char inputNumber = Character.toLowerCase(input.charAt(0));

        return inputNumber;
    }
}
