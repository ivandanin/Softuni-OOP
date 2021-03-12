package Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle implements VehicleImpl {

    protected double fuelQuantity;
    protected double fuelConsumption;

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }
    public static void execute(String[] info) {
        switch (info[0]) {
            case "Drive":
                Production.getInfo().get(info[1]).drive(Double.parseDouble(info[2]));
                break;
            case "Refuel":
                Production.getInfo().get(info[1]).refuel(Double.parseDouble(info[2]));
                break;
        }
    }
    @Override
    public void drive(double distance) {
        double fuelNeeded = distance * getFuelConsumption();
        DecimalFormat format = new DecimalFormat("###.##");
        if (fuelNeeded <= getFuelQuantity()) {
            setFuelQuantity(-fuelNeeded);
            System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(), format.format(distance));
        } else {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        }
    }

    private void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity += fuelQuantity;
    }

    private double getFuelQuantity() {
        return this.fuelQuantity;
    }

    private double getFuelConsumption() {
        return this.fuelConsumption;
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(liters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), getFuelQuantity());
    }
}
