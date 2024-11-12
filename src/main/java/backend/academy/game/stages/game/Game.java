package backend.academy.game.stages.game;

@SuppressWarnings("unused")
public interface Game<T> {
    void startGame();

    void processUserInput(T input);

    void finishGame();
}
