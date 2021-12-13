import java.util.List;
import java.util.stream.Collectors;

public class Puzzle02 extends BasePuzzle {
    Puzzle02(String puzzleInput) {
        super(puzzleInput);
    }

    @Override
    public int getDay() {
        return 2;
    }

    @Override
    public String solveFirstPart() {
        List<String> movements = getPuzzleInput().lines().collect(Collectors.toList());
        int x = 0;
        int y = 0;
        for (String movement : movements) {
            String command = movement.split(" ")[0];
            int value = Integer.parseInt(movement.split(" ")[1]);
            switch (command) {
                case "forward":
                    x += value;
                    break;
                case "down":
                    y += value;
                    break;
                case "up":
                    y -= value;
                    break;
            }
        }
        return String.valueOf(x * y);
    }

    @Override
    public String solveSecondPart() {
        List<String> movements = getPuzzleInput().lines().collect(Collectors.toList());
        int x = 0;
        int y = 0;
        int aim = 0;
        for (String movement : movements) {
            String command = movement.split(" ")[0];
            int value = Integer.parseInt(movement.split(" ")[1]);
            switch (command) {
                case "forward":
                    x += value;
                    y = aim == 0 ? y : y + Math.abs(aim) * value;
                    break;
                case "down":
                    aim += value;
                    break;
                case "up":
                    aim -= value;
                    break;
            }
        }
        return String.valueOf(x * y);
    }
}
