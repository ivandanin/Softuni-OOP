package ShoppingSpree;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Map<String, Person> people = new LinkedHashMap<>();
    private static final Map<String, Product> products = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            setObject(scanner, "Person");
            setObject(scanner, "Product");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return;
        }

        String command = scanner.nextLine();

        while (!"END".equals(command)) {
            String[] tokens = command.split("\\s+");
            try {
                people.get(tokens[0]).addProduct(products.get(tokens[1]));
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }

            command = scanner.nextLine();
        }

        people.values().forEach(System.out::println);
    }
    public static void setObject(Scanner scanner, String clazz) {
        String[] input = scanner.nextLine().split(";");
        Arrays.stream(input)
                .map(s -> s.split("="))
                .forEach(data ->{
            var object = clazz.equals("Person")
                    ? people.put(data[0].trim(), new Person(data[0].trim(), Double.parseDouble(data[1].trim())))
                    : products.put(data[0].trim(), new Product(data[0].trim(), Double.parseDouble(data[1].trim())));
        });
    }
}
/*
Pesho=11;Gosho=4
Bread=10;Milk=2
Pesho Bread
Gosho Milk
Gosho Milk
Pesho Milk
END
 */