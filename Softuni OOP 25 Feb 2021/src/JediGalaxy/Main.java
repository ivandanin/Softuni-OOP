package JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int[] dimensions = readArray(scanner);
            int x = dimensions[0];
            int y = dimensions[1];

            int[][] matrix = new int[x][y];

            int value = 0;
            for (int i = 0; i < x; i++)
            {
                for (int j = 0; j < y; j++)
                {
                    matrix[i][j] = value++;
                }
            }

            String command = scanner.nextLine();
            long sum = 0;
            while (!command.equals("Let the Force be with you"))
            {
                int[] ivoS = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
                int[] evil = readArray(scanner);
                int xE = evil[0];
                int yE = evil[1];

                while (evilIsInBounds(xE, yE))
                {
                    if (xE < matrix.length && yE < matrix[0].length) {
                        matrix[xE][yE] = 0;
                    }
                    xE--;
                    yE--;
                }

                int xI = ivoS[0];
                int yI = ivoS[1];

                while (ivoIsInBounds(xI, yI, matrix))
                {
                    if (xI < matrix.length && yI >= 0)
                    {
                        sum += matrix[xI][yI];
                    }

                    yI++;
                    xI--;
                }

                command = scanner.nextLine();
            }

        System.out.println(sum);


    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
    private static boolean evilIsInBounds(int xE, int yE) {
        return xE >= 0 && yE >= 0;
    }
    private static boolean ivoIsInBounds(int xI, int yI, int[][] matrix) {
        return xI >= 0 && yI < matrix[1].length;
    }
}
