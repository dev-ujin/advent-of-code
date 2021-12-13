import java.util.Scanner;

public abstract class BasePuzzle {
    private final String input;

    BasePuzzle(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public abstract int getDay();

    public abstract String getTitle();

    public abstract String solveFirstPart();

    public abstract String solveSecondPart();
}
