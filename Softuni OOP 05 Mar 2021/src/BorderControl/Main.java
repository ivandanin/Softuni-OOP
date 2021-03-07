package BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> ids = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];

            if (tokens.length == 3) {
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];
                Citizen citizen = new Citizen(name, age, id);
                ids.add(citizen);
            } else if (tokens.length == 2) {
                String id = tokens[1];
                Robot robot = new Robot(name, id);
                ids.add(robot);
            }


            input = scanner.nextLine();
        }
        String fakeID = scanner.nextLine();

        for (Identifiable id : ids) {
            System.out.println(id.getId().endsWith(fakeID) ? id.getId() : "");
        }
    }
}
