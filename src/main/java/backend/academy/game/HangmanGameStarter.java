package backend.academy.game;

import backend.academy.game.input.impl.HangmanMenuInputSource;
import backend.academy.game.stages.menu.GameMenu;
import backend.academy.game.stages.menu.impl.ConsoleGameMenu;

public class HangmanGameStarter {
    public void startNewHangmanGame() {
        GameMenu<Integer> gameMenu = new ConsoleGameMenu(new HangmanMenuInputSource());
        gameMenu.greetUserForTheFirstTime();
    }
}
