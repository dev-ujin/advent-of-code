import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PuzzleInputHandler {
    private final int day;

    PuzzleInputHandler(int day) {
        this.day = day;
    }

    public String getPuzzleInput() throws IOException {
        try {
            return Files.readString(Paths.get(buildPath()));
        } catch (IOException e) {
            throw new IOException("Cannot read the file in the path.");
        }
    }

    private String buildPath() {
        return day < 10 ? "src/PuzzleInput/PuzzleInput0" + day + ".txt" : "src/PuzzleInput/PuzzleInput" + day + ".txt";
    }
}
