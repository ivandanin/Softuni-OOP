package Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Production {

    public static Map<String, VehicleImpl> info = new LinkedHashMap<>();

    public static void produce(String[] info) {
        switch (info[0]) {
            case "Car":
                Production.info.put(info[0], new Car(Double.parseDouble(info[1]), Double.parseDouble(info[2])));
                break;
            case "Truck":
            Production.info.put(info[0], new Truck(Double.parseDouble(info[1]), Double.parseDouble(info[2])));
            break;
        }
    }

    public static Map<String, VehicleImpl> getInfo() {
        return info;
    }
}
