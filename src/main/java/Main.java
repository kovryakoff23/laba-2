import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Main {
    public static void main(@NotNull String[] args) {
        System.out.println("Please, input Math expression");
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        MyParser myParser = new MyParser(expression);
        System.out.println(expression + " = " + myParser.foundSolve());

    }
}
