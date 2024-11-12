package backend.academy.game.input;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Scanner;
import lombok.Getter;

@SuppressWarnings("all")
@SuppressFBWarnings("DM_DEFAULT_ENCODING")
public class ConsoleInputObject {
    @Getter private static final Scanner inputScanner = new Scanner(System.in);
}
