package backend.academy.game.settings;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressWarnings("all")
public enum WordsCategory {
    RANDOM, ANIMALS, FOOD, JOBS, COUNTRIES, TEST;

    private static final WordsCategory[] CERTAIN_CATEGORIES = {ANIMALS, FOOD, JOBS, COUNTRIES};
    private static final WordsCategory[] ALL_CATEGORIES = {null, RANDOM, FOOD, JOBS, ANIMALS, COUNTRIES};

    @SuppressFBWarnings(value = "MS_EXPOSE_REP", justification = "Так и должно быть")
    public static WordsCategory[] getAllCertainCategories() {
        return CERTAIN_CATEGORIES;
    }

    public static WordsCategory getCategoryById(Integer categoryId) {
        if (categoryId >= ALL_CATEGORIES.length || categoryId <= 0) {
            throw new RuntimeException("Неправильный индекс кадегории слов: " + categoryId);
        }
        return ALL_CATEGORIES[categoryId];
    }
}
