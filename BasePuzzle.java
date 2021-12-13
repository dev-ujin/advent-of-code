import java.util.Scanner;

public abstract class BasePuzzle {
    private final String puzzleInput;

    BasePuzzle(String input) {
        this.puzzleInput = input;
    }

    public String getPuzzleInput() {
        return puzzleInput;
    }

    public abstract int getDay();

    public abstract String solveFirstPart();

    public abstract String solveSecondPart();
}
