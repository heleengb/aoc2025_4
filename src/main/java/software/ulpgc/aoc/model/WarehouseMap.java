package software.ulpgc.aoc.model;

import java.util.stream.IntStream;

public record WarehouseMap(char[][] matrix, int rows, int cols) {

    public boolean isItem(int r, int c) {
        return isValid(r, c) && matrix[r][c] == '@';
    }

    private boolean isValid(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    /*
     * Un item es accesible si tiene MENOS de 4 vecinos.
     */
    public boolean isAccessible(int r, int c) {
        if (!isItem(r, c)) return false;

        long neighbors = IntStream.rangeClosed(-1, 1)
                .boxed()
                .flatMap(dr -> IntStream.rangeClosed(-1, 1)
                        .mapToObj(dc -> new int[]{r + dr, c + dc}))
                // Filtramos para no contarnos a nosotros mismos
                .filter(pos -> !(pos[0] == r && pos[1] == c))
                .filter(pos -> isItem(pos[0], pos[1]))
                .count();

        return neighbors < 4;
    }

    /*
     * Elimina un item de la coordenada dada.
     */
    public void removeItem(int r, int c) {
        if (isValid(r, c)) {
            matrix[r][c] = '.';
        }
    }
}