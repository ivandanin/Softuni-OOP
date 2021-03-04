package NeedForSpeed;

public class Main {
    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle(50, 150);
        Motorcycle motorcycle = new Motorcycle(20, 100);
        RaceMotorcycle raceMotorcycle = new RaceMotorcycle(10, 200);
        CrossMotorcycle crossMotorcycle =new CrossMotorcycle(5, 58);
        Car car = new Car(34, 75);
        FamilyCar familyCar = new FamilyCar(45, 510);
        SportCar sportCar = new SportCar(15, 780);

        System.out.println(vehicle);
        System.out.println(motorcycle);
        System.out.println(raceMotorcycle);
        System.out.println(crossMotorcycle);
        System.out.println(car);
        System.out.println(familyCar);
        System.out.println(sportCar);
    }
}
