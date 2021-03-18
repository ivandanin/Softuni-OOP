package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Field[] fields = RichSoilLand.class.getDeclaredFields();
		StringBuilder output = new StringBuilder();

		String input = scanner.nextLine();
		while (!input.equals("HARVEST")) {

			String modifier = input;

		Arrays.stream(fields)
				.filter(f -> Modifier.toString(f.getModifiers()).equals(modifier)
				|| modifier.equals("all"))
				.forEach(f -> output.append(String.format("%s %s %s%n", Modifier.toString(f.getModifiers()),
						f.getType().getSimpleName(),
						f.getName())));

			input = scanner.nextLine();
		}
		System.out.print(output.toString());
	}
}
