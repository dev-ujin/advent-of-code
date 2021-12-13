import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Puzzle01 puzzle01 = new Puzzle01(new PuzzleInputHandler(1).getInput());
        System.out.println("The answer for first part: " + puzzle01.solveFirstPart());
        System.out.println("The answer for second part: " + puzzle01.solveSecondPart());
    }
}