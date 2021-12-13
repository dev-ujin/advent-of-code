import java.util.List;
import java.util.stream.Collectors;
public class Puzzle01 extends BasePuzzle {

    Puzzle01(String input) {
        super(input);
    }

    @Override
    public int getDay() {
        return 1;
    }

    @Override
    public String getTitle() {
        return "Sonar Sweep";
    }

    @Override
    public String solveFirstPart() {
        int increased = 0;
        List<Integer> depth = getInput().lines().map(Integer::parseInt).collect(Collectors.toList());
        Integer previous = depth.get(0);
        for (int i = 1 ; i < depth.size() ; i++) {
            Integer current = depth.get(i);
            if (current > previous) {
                increased++;
            }
            previous = current;
        }
        return String.valueOf(increased);
    }

    @Override
    public String solveSecondPart() {
        int increased = 0;
        List<Integer> depth = getInput().lines().map(Integer::parseInt).collect(Collectors.toList());
        Integer first = depth.get(0);
        Integer second = depth.get(1);
        Integer third = depth.get(2);
        for (int i = 3 ; i < depth.size() ; i++) {
            Integer fourth = depth.get(i);
            if (fourth > first) {
                increased++;
            }
            first = second;
            second = third;
            third = fourth;
        }
        return String.valueOf(increased);
    }
}
