package software.ulpgc.aoc.controller;

import software.ulpgc.aoc.command.*;
import software.ulpgc.aoc.model.WarehouseMap;

import java.util.List;

public class WarehouseController {

    private WarehouseMap createMap(List<String> rawData) {
        if (rawData.isEmpty()) return new WarehouseMap(new char[0][0], 0, 0);

        char[][] matrix = rawData.stream()
                .map(String::toCharArray)
                .toArray(char[][]::new);

        return new WarehouseMap(matrix, matrix.length, matrix[0].length);
    }

    // Lógica Parte 1
    public long analyzeInitialAccessibility(List<String> input) {
        WarehouseMap map = createMap(input);
        return new CountAccessibleItemsCommand(map).execute();
    }

    // Lógica Parte 2
    public long simulateFullCleanup(List<String> input) {
        WarehouseMap map = createMap(input);
        PurgeAccessibleItemsCommand command = new PurgeAccessibleItemsCommand(map);

        long totalRemoved = 0;
        long removedInStep;

        // se ejecuta hasta que devuelva 0
        do {
            removedInStep = command.execute();
            totalRemoved += removedInStep;
        } while (removedInStep > 0);

        return totalRemoved;
    }
}