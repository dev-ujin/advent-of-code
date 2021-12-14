import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<BasePuzzle> puzzleList = List.of(
                new Puzzle01(new PuzzleInputHandler(1).getPuzzleInput()),
                new Puzzle02(new PuzzleInputHandler(2).getPuzzleInput()),
                new Puzzle14(new PuzzleInputHandler(14).getPuzzleInput())

        );
        for(BasePuzzle puzzle : puzzleList) {
            if (puzzle.getDay() < 10) {
                System.out.println("***************🎄 Day 0" + puzzle.getDay() + " 🎄***************");
            } else {
                System.out.println("***************🎄 Day " + puzzle.getDay() + " 🎄***************");
            }
            System.out.println("The answer for first part: " + puzzle.solveFirstPart());
            System.out.println("The answer for second part: " + puzzle.solveSecondPart());
        }
    }
}