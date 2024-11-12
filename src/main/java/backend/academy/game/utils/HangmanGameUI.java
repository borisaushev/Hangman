package backend.academy.game.utils;

import java.util.HashSet;

@SuppressWarnings({"RegexpSinglelineJava", "FileTabCharacter", "MagicNumber"})
public class HangmanGameUI {

    private HangmanGameUI() {
    }

    public static void getCurrentGameRepresentation(
        int remainingAttempts,
        char[] wordLetters,
        HashSet<Character> alreadyGuessedLetters
    ) {
        if (remainingAttempts < 0) {
            throw new RuntimeException("Отрицательное значение оставшихся попыток");
        }

        alreadyGuessedLetters.forEach(letter -> System.out.print(letter + " "));
        System.out.println();

        if (remainingAttempts == 0) {
            System.out.println("""
                     _______
                    |  /  |
                    | /  _|_
                    |/	/# #\\
                    |	\\_-_/
                    |	  |
                    |	 |||
                    |	 |||
                    |	  |
                    |	 | |
                    |	 | |
                    |_____________
                """);
        } else if (remainingAttempts < 4) {
            System.out.println("""
                     _______
                	|  /
                	| /	 ___
                	|/	/0 0\\
                	|	\\_~_/
                	|	  |
                	|	 /|\\
                	|	/ | \\
                	|	  |
                	|	 / \\
                	|	/   \\
                 	|_____________
                """);
        } else if (remainingAttempts < 6) {
            System.out.println("""
                     _______
                    |
                    | 	 ___
                    |	/0 0\\
                    |	\\_-_/
                    |	  |
                    |	 /|\\
                    |	/ | \\
                    |	  |
                    |	 / \\
                    |	/   \\
                    |_____________
                """);
        } else if (remainingAttempts < 8) {
            System.out.println("""
                    |
                    | 	 ___
                    |	/0 0\\
                    |	\\_-_/
                    |	  |
                    |	 /|\\
                    |	/ | \\
                    |	  |
                    |	 / \\
                    |	/   \\
                    |_____________
                """);
        } else {
            System.out.println("""
                         ____
                        /0 0 \\
                        \\_﹀_/
                        \\ | /
                         \\|/
                          |
                          |
                         / \\
                        /   \\
                     _____________
                """);
        }

        for (char letter : wordLetters) {
            System.out.print(letter + " ");
        }

        System.out.println();
    }
}
