package software.ulpgc.aoc.command;

import software.ulpgc.aoc.model.WarehouseMap;
import java.util.stream.IntStream;

// Parte 1: Solo contar
public class CountAccessibleItemsCommand implements InventoryCommand {
    private final WarehouseMap map;

    public CountAccessibleItemsCommand(WarehouseMap map) {
        this.map = map;
    }

    @Override
    public long execute() {
        return IntStream.range(0, map.rows()).parallel()
                .boxed()
                .flatMapToLong(r -> IntStream.range(0, map.cols())
                        .filter(c -> map.isAccessible(r, c))
                        .mapToLong(c -> 1))
                .sum();
    }
}