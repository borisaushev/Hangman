package backend.academy.game.stages.menu.impl;

import backend.academy.game.input.InputSource;
import backend.academy.game.input.impl.HangmanGameInputSource;
import backend.academy.game.settings.DifficultyLevel;
import backend.academy.game.settings.HangmanGameSettings;
import backend.academy.game.settings.WordsCategory;
import backend.academy.game.stages.game.Game;
import backend.academy.game.stages.game.impl.ConsoleHangmanGame;
import backend.academy.game.stages.menu.GameMenu;

@SuppressWarnings({"RegexpSinglelineJava", "RightCurly"})
public class ConsoleGameMenu implements GameMenu<Integer> {
    final static int START_GAME_OPTION = 1;
    final static int SET_DIFFICULTY_LEVEL_OPTION = 2;
    final static int SET_WORD_CATEGORY_OPTION = 3;
    final static int END_GAME_OPTION = 4;
    private final HangmanGameSettings gameSettings;
    private final InputSource<Integer> inputSource;

    public ConsoleGameMenu(InputSource<Integer> inputSource) {
        gameSettings = new HangmanGameSettings(WordsCategory.RANDOM, DifficultyLevel.DEFAULT);
        this.inputSource = inputSource;
    }

    public void greetUserForTheFirstTime() {
        System.out.println("""
            ------------
            Добро пожаловать в игру виселица!
            Подробнее о правилах можно узнать здесь: https://en.wikipedia.org/wiki/Hangman_(game)
            ------------
            """);

        System.out.println("""
            ------------
            Вы находитесь в главном меню, используйте цифры, что бы ориентироваться
            -----------
            """);

        changeToMainMenu();
    }

    public void changeToMainMenu() {
        showMainMenuOptions();

        Integer input = inputSource.getNextInput();
        processUserInput(input);
    }

    public void processUserInput(Integer input) {
        if (input == END_GAME_OPTION) {
            finishGameSession();
            return;
        }

        if (input == START_GAME_OPTION) {
            Game<Character> newGame = new ConsoleHangmanGame(gameSettings, new HangmanGameInputSource());
            newGame.startGame();
        }

        else if (input == SET_DIFFICULTY_LEVEL_OPTION) {
            gameSettings.changeDifficultyLevel();
        }

        else if (input == SET_WORD_CATEGORY_OPTION) {
            gameSettings.changeWordsCategory();
        }

        changeToMainMenu();
    }

    public void showMainMenuOptions() {
        System.out.println("""
            ------------
            1. Начать игру
            2. Выбрать уровень сложности
            3. Выбрать категорию слов
            4. Выйти из игры
            -----------
            """);
    }

    public void finishGameSession() {
        System.out.println("Уже выключаемся");
    }
}
