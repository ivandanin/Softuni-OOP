import java.util.Scanner;
import java.util.stream.IntStream;

public class EnterNumbers {
    private static boolean isTrue = true;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (isTrue) {
            try {
        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        printNumbers(start, end);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Enter valid Integers in range 1 < start < end < 100");
            }
        }
    }
    public static void printNumbers(int start, int end) {
        if (1 > start || start > end || end > 100) {
            throw new NumberFormatException("Enter valid Integers in range 1 < start < end < 100");
        }
        IntStream.rangeClosed(start, end).forEach(System.out::println);
        isTrue = false;
    }
}
