package backend.academy;

import backend.academy.game.HangmanGameStarter;

@SuppressWarnings("HideUtilityClassConstructor")
public class Main {
    public static void main(String[] args) {
        HangmanGameStarter newGame = new HangmanGameStarter();
        newGame.startNewHangmanGame();
    }
}
