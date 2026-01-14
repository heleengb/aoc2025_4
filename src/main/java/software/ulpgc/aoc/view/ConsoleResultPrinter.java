package software.ulpgc.aoc.view;

public class ConsoleResultPrinter implements SolutionPrinter {
    @Override
    public void display(long value) {
        System.out.println("Total: " + value);
    }
}