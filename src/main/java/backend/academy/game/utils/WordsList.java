package backend.academy.game.utils;

import backend.academy.game.settings.HangmanGameGuess;
import backend.academy.game.settings.WordsCategory;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Random;
import lombok.Getter;

@SuppressWarnings("all")
@SuppressFBWarnings({"PL_PARALLEL_LISTS", "PREDICTABLE_RANDOM", "RV_ABSOLUTE_VALUE_OF_RANDOM_INT"})
public class WordsList {

    @Getter private static final String[]
        ANIMALS = {"Лев", "Зебра", "Дикобраз", "Медуза", "Обезьяна", "Муравей", "Паук", "Шмель"};

    @Getter private static final String[]
        HINTS_FOR_ANIMALS =
        {"Царь, не скажу чей", "На дороге не валяется, хотя ...", "самый ненавистный персонаж Дота 2", "Почти что вода",
            "Ближе всех к человеку", "Мелкий да сильный", "Восьминогий супергерой",
            "Его полет довольно интересно слушать на пианино"};

    @Getter private static final String[]
        COUNTRIES = {"Россия", "Бразилия", "Австралия", "Китай", "Египет", "Ватикан", "Италия", "Япония"};

    @Getter private static final String[]
        HINTS_FOR_COUNTRIES = {"вы находитесь здесь", "её столица называется так же", "страна-континент",
        "больше всего ассоциируется со стеной", "что то про пирамиды", "самая маленькая страна в мире",
        "что то про пиццу и пасту", "страна не покоренная монголами"};

    @Getter private static final String[]
        FOOD = {"Яблоко", "Помидор", "Банан", "Пицца", "Попкорн", "Оливье", "Мандарины", "Орешек"};

    @Getter private static final String[]
        HINTS_FOR_FOOD =
        {"известный бренд смартфонов", "толи синьер толи синьёр", "миньёны его обожают", "лучшее изобретение из Италии",
            "есть в любом кинотеатре", "едят на новый год", "любимое лакомство чебурашки", "Крепкий _ _ _ _ _ _"};

    @Getter private static final String[]
        JOBS = {"Программист", "Электрик", "Стоматолог", "Космонавт", "Водитель", "Сварщик", "Пожарный", "Повар"};

    @Getter private static final String[]
        HINTS_FOR_JOBS =
        {"желанная работа всех участников АБ", "несет вам свет", "страх всех детей", "человек на высоте",
            "Райан Гослинг в фильме Драйв", "парень работящий", "приходит когда все очень плохо", "утоляет голод"};
    private static final Random RANDOM = new Random();

    @Getter private static final String[]
        TEST = {"Тестовыйтест"};

    @Getter private static final String[]
        HINTS_FOR_TEST =
        {"Тестоваяподсказка"};

    private WordsList() {
    }

    public static HangmanGameGuess getWordAndHint(WordsCategory category) {
        //Берём случайную категорию и вызываем себя же
        if (category == WordsCategory.RANDOM) {
            var allCertainCategories = WordsCategory.getAllCertainCategories();

            int randomCategoryIndex = Math.abs(RANDOM.nextInt()) % (allCertainCategories.length);
            var randomCategory = allCertainCategories[randomCategoryIndex];

            return getWordAndHint(randomCategory);
        }

        //Тут простейшие проверки на тип
        if (category == WordsCategory.ANIMALS) {
            int index = Math.abs(RANDOM.nextInt()) % ANIMALS.length;
            return new HangmanGameGuess(ANIMALS[index], HINTS_FOR_ANIMALS[index]);
        } else if (category == WordsCategory.COUNTRIES) {
            int index = Math.abs(RANDOM.nextInt()) % COUNTRIES.length;
            return new HangmanGameGuess(COUNTRIES[index], HINTS_FOR_COUNTRIES[index]);
        } else if (category == WordsCategory.JOBS) {
            int index = Math.abs(RANDOM.nextInt()) % JOBS.length;
            return new HangmanGameGuess(JOBS[index], HINTS_FOR_JOBS[index]);
        } else if (category == WordsCategory.FOOD) {
            int index = Math.abs(RANDOM.nextInt()) % FOOD.length;
            return new HangmanGameGuess(FOOD[index], HINTS_FOR_FOOD[index]);
        } else if (category == WordsCategory.TEST) {
            return new HangmanGameGuess(TEST[0], HINTS_FOR_TEST[0]);
        }

        throw new UnsupportedOperationException("Несуществующий тип слов: " + category);
    }
}

