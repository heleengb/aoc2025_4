package software.ulpgc.aoc;

import software.ulpgc.aoc.controller.WarehouseController;
import software.ulpgc.aoc.io.TextFileReader;
import software.ulpgc.aoc.view.ConsoleResultPrinter;

import java.io.IOException;
import java.nio.file.Path;

public class Main2 {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "arroba.txt");

    public static void main(String[] args) {
        try {
            // IO
            var input = new TextFileReader(INPUT_PATH).readContent();

            // CONTROLLER
            long result = new WarehouseController().simulateFullCleanup(input);

            // VIEW
            new ConsoleResultPrinter().display(result);

        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        }
    }
}