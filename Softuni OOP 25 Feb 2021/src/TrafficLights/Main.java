package TrafficLights;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] colors = scanner.nextLine().split("\\s+");
        int changes = Integer.parseInt(scanner.nextLine());

        ArrayList<TrafficLight> trafficLights = new ArrayList<>();

        for (String color : colors) {
            TrafficLight trafficLight = new TrafficLight(Color.valueOf(color));
            trafficLights.add(trafficLight);
        }

        for (int i = 0; i < changes; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.update();
                System.out.print(trafficLight.getColor() + " ");
            }
            System.out.println();
        }
    }
}
