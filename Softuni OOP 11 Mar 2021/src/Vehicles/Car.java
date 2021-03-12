package Vehicles;

public class Car extends Vehicle {

    private static double INCREASE_FUEL_PER_KM = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + INCREASE_FUEL_PER_KM);
    }
}
