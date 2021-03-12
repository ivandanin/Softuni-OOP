package Vehicles;

public class Truck extends Vehicle {

    private static double INCREASE_FUEL_PER_KM = 1.6;
    private static double REDUCE_FUEL = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + INCREASE_FUEL_PER_KM);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * REDUCE_FUEL);
    }
}
