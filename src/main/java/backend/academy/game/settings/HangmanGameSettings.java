package backend.academy.game.settings;

import backend.academy.game.input.InputSource;
import backend.academy.game.input.impl.HangmanMenuInputSource;
import lombok.Getter;

@SuppressWarnings({"RegexpSinglelineJava"})
public class HangmanGameSettings {
    final static int DONT_CHANGE_DIFFICULTY_OPTION = 5;
    final static int DONT_CHANGE_WORD_CATEGORY_OPTION = 6;
    private final InputSource<Integer> inputSource;
    @Getter private WordsCategory wordsCategory;
    @Getter private DifficultyLevel difficultyLevel;

    public HangmanGameSettings(WordsCategory wordsCategory, DifficultyLevel difficultyLevel) {
        inputSource = new HangmanMenuInputSource();

        this.difficultyLevel = difficultyLevel;
        this.wordsCategory = wordsCategory;
    }

    public void changeDifficultyLevel() {
        showDifficultyLevelOptions();

        Integer input = inputSource.getNextInput();
        processUserInputForDifficultyLevel(input);
    }

    private void showDifficultyLevelOptions() {
        System.out.println(
            """
                ------------
                1. Мирный (бесконечно попыток)
                2. Легкий (15 попыток)
                3. Средний (8 попыток)
                4. Хардкор (1 попытка)
                5. Ничего не менять
                -----------
                """
        );
    }

    private void processUserInputForDifficultyLevel(Integer input) {
        //Если пользователь не выбрал опцию "ничего не менять"
        if (input != DONT_CHANGE_DIFFICULTY_OPTION) {
            difficultyLevel = DifficultyLevel.getDifficultyById(input);
        }
    }

    public void changeWordsCategory() {
        showWordsCategoryOptions();

        Integer input = inputSource.getNextInput();
        processUserInputForWordsCategory(input);
    }

    private void showWordsCategoryOptions() {
        System.out.println(
            """
                ------------
                1. Случайный выбор
                2. Еда
                3. Профессии
                4. Животные
                5. Страны
                6. Ничего не менять
                -----------
                """
        );
    }

    private void processUserInputForWordsCategory(Integer input) {
        //Если пользователь не выбрал опцию "ничего не менять"
        if (input != DONT_CHANGE_WORD_CATEGORY_OPTION) {
            wordsCategory = WordsCategory.getCategoryById(input);
        }
    }
}
