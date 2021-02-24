import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = Integer.parseInt(scanner.nextLine());
        for (int stars = 1; stars <= n; stars++) {
            printRow(n, stars);
        }
        for (int stars = n - 1; stars >= 1; stars--) {
            printRow(n, stars);
        }
    }
    public static void printRow(int sizeOfFigure, int stars){
        for (int s = 0; s < sizeOfFigure - stars; s++) {
            System.out.print(" ");
        }
        for (int i = 0; i < stars; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
