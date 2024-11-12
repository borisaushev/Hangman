package backend.academy.game.utils;

import org.junit.jupiter.api.RepeatedTest;
import static backend.academy.game.settings.WordsCategory.ANIMALS;
import static backend.academy.game.settings.WordsCategory.COUNTRIES;
import static backend.academy.game.settings.WordsCategory.FOOD;
import static backend.academy.game.settings.WordsCategory.JOBS;
import static backend.academy.game.settings.WordsCategory.RANDOM;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WordListUtilTest {

    @RepeatedTest(100)
    public void randomWordTest() {
        String animalsWord = WordsList.getWordAndHint(ANIMALS).word;
        Object[] animalsArray = WordsList.ANIMALS();

        String foodWord = WordsList.getWordAndHint(FOOD).word;
        Object[] foodArray = WordsList.FOOD();

        String jobsWord = WordsList.getWordAndHint(JOBS).word;
        Object[] jobsArray = WordsList.JOBS();

        String countriesWord = WordsList.getWordAndHint(COUNTRIES).word;
        Object[] countriesArray = WordsList.COUNTRIES();

        assertThat(animalsWord).isIn(animalsArray);
        assertThat(foodWord).isIn(foodArray);
        assertThat(jobsWord).isIn(jobsArray);
        assertThat(countriesWord).isIn(countriesArray);
        WordsList.getWordAndHint(RANDOM);
    }
}
