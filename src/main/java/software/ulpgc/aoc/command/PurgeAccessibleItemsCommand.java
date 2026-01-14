package software.ulpgc.aoc.command;

import software.ulpgc.aoc.model.WarehouseMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Parte 2: ir eliminando los accesibles y contarlos
public class PurgeAccessibleItemsCommand implements InventoryCommand {
    private final WarehouseMap map;

    public PurgeAccessibleItemsCommand(WarehouseMap map) {
        this.map = map;
    }

    @Override
    public long execute() {
        // identificar candidatos
        List<int[]> toRemove = IntStream.range(0, map.rows()).parallel()
                .boxed() // de IntStream a Stream<Int>
                .flatMap(r -> IntStream.range(0, map.cols())
                        .mapToObj(c -> new int[]{r, c}))
                .filter(pos -> map.isAccessible(pos[0], pos[1]))
                .collect(Collectors.toList());

        // eliminar rollo
        toRemove.forEach(pos -> map.removeItem(pos[0], pos[1]));

        return toRemove.size();
    }
}