package BirthdayCelebration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> births = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            if (tokens.length == 5) {
                Citizen citizen = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                births.add(tokens[4]);
            } else if (tokens[0].equals("Pet")) {
                Pet pet = new Pet(tokens[1], tokens[2]);
                births.add(tokens[2]);
            } else if (tokens[0].equals("Robot")) {
                Robot robot = new Robot(tokens[1], tokens[2]);
            }

            input = scanner.nextLine();
        }
        int year = Integer.parseInt(scanner.nextLine());

        for (String birth : births) {
            if (birth.endsWith(String.valueOf(year))) {
                System.out.println(birth);
            }
        }
    }
}
