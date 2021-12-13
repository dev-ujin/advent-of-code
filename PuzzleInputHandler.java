import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PuzzleInputHandler {
    private final int day;

    PuzzleInputHandler(int day) {
        this.day = day;
    }

    public String getInput() throws IOException {
        try {
            return Files.readString(Paths.get(buildPath()));
        } catch (IOException e) {
            throw new IOException("Cannot read the file in the path.");
        }
    }

    private String buildPath() {
        return day < 10 ? "src/input/PuzzleInput0" + day + ".txt" : "src/input/PuzzleInput" + day + ".txt";
    }
}
