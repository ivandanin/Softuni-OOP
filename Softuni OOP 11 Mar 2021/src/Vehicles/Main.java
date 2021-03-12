package Vehicles;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IntStream.range(0, 2).mapToObj(i -> scanner.nextLine().split("\\s+"))
                .forEach(Production::produce);

        IntStream.range(0, Integer.parseInt(scanner.nextLine())).mapToObj(i -> scanner.nextLine().split("\\s+"))
                .forEach(Vehicle::execute);

        Production.getInfo().forEach((k, v) ->System.out.println(v.toString()));

    }
}
