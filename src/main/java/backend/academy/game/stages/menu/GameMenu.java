package backend.academy.game.stages.menu;

@SuppressWarnings("unused")
public interface GameMenu<T> {

    void greetUserForTheFirstTime();

    void changeToMainMenu();

    void processUserInput(T input);

    void showMainMenuOptions();

    void finishGameSession();

}
