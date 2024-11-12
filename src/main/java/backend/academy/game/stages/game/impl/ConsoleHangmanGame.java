package backend.academy.game.stages.game.impl;

import backend.academy.game.input.InputSource;
import backend.academy.game.settings.DifficultyLevel;
import backend.academy.game.settings.HangmanGameGuess;
import backend.academy.game.settings.HangmanGameSettings;
import backend.academy.game.stages.game.Game;
import backend.academy.game.utils.HangmanGameUI;
import backend.academy.game.utils.WordsList;
import java.util.Arrays;
import java.util.HashSet;
import lombok.Getter;

@SuppressWarnings("RegexpSinglelineJava")
@Getter
public class ConsoleHangmanGame implements Game<Character> {
    private final HashSet<Character> alreadyGuessedLetters;
    private final char[] wordLetters;
    private final String word;
    private final InputSource<Character> inputSource;
    private int remainingAttempts;
    private int remainingLetters;
    private boolean gameIsOver = false;
    private boolean userWon = false;

    public ConsoleHangmanGame(HangmanGameSettings gameSettings, InputSource<Character> gameInputSource) {
        inputSource = gameInputSource;

        //инициализируем все что потребуется дальше
        alreadyGuessedLetters = new HashSet<>();

        HangmanGameGuess guessedWord = WordsList.getWordAndHint(gameSettings.wordsCategory());
        guessedWord.word = guessedWord.word.toLowerCase();

        wordLetters = guessedWord.word.toCharArray();
        word = guessedWord.word;

        remainingAttempts = DifficultyLevel.getAttemptsCount(gameSettings.difficultyLevel());
        remainingLetters = word.length();

        Arrays.fill(wordLetters, '_');
    }

    @Override
    public void startGame() {
        System.out.println("Угадайте слово!");

        while (!gameIsOver) {
            char input = inputSource.getNextInput();
            processUserInput(input);
        }

        finishGame();
    }

    public void processUserInput(Character input) {
        if (alreadyGuessedLetters.contains(input)) {
            System.out.println("Буква уже использована");
            return;
        }

        //проходим по всем символам слова в поиске совпадений
        int startingRemainingLetters = remainingLetters;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == input) {
                wordLetters[i] = input;
                remainingLetters -= 1;
            }
        }

        //добавляем в список использованных букв
        alreadyGuessedLetters.add(input);

        //если выбранной буквы нет в слове
        if (remainingLetters == startingRemainingLetters) {
            remainingAttempts -= 1;
        }

        //делаем вывод в консоль в зависимости от состояния переменных
        HangmanGameUI.getCurrentGameRepresentation(remainingAttempts, wordLetters, alreadyGuessedLetters);

        if (remainingLetters == 0) {
            gameIsOver = true;
            userWon = true;
        } else if (remainingAttempts == 0) {
            gameIsOver = true;
            userWon = false;
        }
    }

    @Override
    public void finishGame() {
        if (userWon) {
            System.out.println("Вы угадали!");
        } else {
            System.out.println("Игра окончена!");
        }
    }
}
