package CarShopExtend;

import CarShopExtend.Car;

import java.io.Serializable;

public class Seat implements Car, Serializable {
    String model;
    String color;
    Integer horsePower;
    String countryProduced;

    public Seat(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }


    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Integer getHorsePower() {
        return horsePower;
    }

    @Override
    public String countryProduced() {
        return countryProduced;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
