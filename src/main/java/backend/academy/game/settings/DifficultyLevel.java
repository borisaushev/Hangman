package backend.academy.game.settings;

@SuppressWarnings({"RegexpSinglelineJava", "ReturnCount"})
public enum DifficultyLevel {
    DEFAULT, PEACEFUL, EASY, MEDIUM, HARDCORE;

    final static int DEFAULT_ATTEMPTS_COUNT = 8;
    final static int MEDIUM_ATTEMPTS_COUNT = 8;
    final static int EASY_ATTEMPTS_COUNT = 15;
    final static int HARDCORE_ATTEMPTS_COUNT = 1;
    private static final DifficultyLevel[] ALL_DIFFICULTIES = {null, PEACEFUL, EASY, MEDIUM, HARDCORE};

    public static int getAttemptsCount(DifficultyLevel difficultyLevel) {
        if (difficultyLevel == PEACEFUL) {
            return Integer.MAX_VALUE;
        } else if (difficultyLevel == DEFAULT) {
            return DEFAULT_ATTEMPTS_COUNT;
        } else if (difficultyLevel == MEDIUM) {
            return MEDIUM_ATTEMPTS_COUNT;
        } else if (difficultyLevel == EASY) {
            return EASY_ATTEMPTS_COUNT;
        } else if (difficultyLevel == HARDCORE) {
            return HARDCORE_ATTEMPTS_COUNT;
        }

        throw new RuntimeException("Неправильно указан уровень сложности");
    }

    public static DifficultyLevel getDifficultyById(Integer difficultyLevelId) {
        if (difficultyLevelId >= ALL_DIFFICULTIES.length || difficultyLevelId <= 0) {
            throw new RuntimeException("Неправильный индекс уровня сложности: " + difficultyLevelId);
        }
        return ALL_DIFFICULTIES[difficultyLevelId];
    }
}
