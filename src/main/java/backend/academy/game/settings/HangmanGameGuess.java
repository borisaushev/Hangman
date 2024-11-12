package backend.academy.game.settings;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings(value = "URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD", justification = "Скоро будем исользовать")
@SuppressWarnings("RegexpSinglelineJava")
public class HangmanGameGuess {
    public String word;
    public String hint;

    public HangmanGameGuess(String word, String hint) {
        this.word = word;
        this.hint = hint;
    }
}
