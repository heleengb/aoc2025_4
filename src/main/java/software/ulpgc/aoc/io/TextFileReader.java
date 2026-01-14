package software.ulpgc.aoc.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class TextFileReader implements InputReader {
    private final Path path;

    public TextFileReader(Path path) {
        this.path = path;
    }

    @Override
    public List<String> readContent() throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.toList();
        }
    }
}