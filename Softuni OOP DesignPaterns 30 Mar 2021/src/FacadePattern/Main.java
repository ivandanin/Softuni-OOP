package FacadePattern;

public class Main {
    public static void main(String[] args) {
        Car car = new CarBuilderFacade()
                .info()
                .withType("BMW")
                .withColor("Black")
                .withNumberOfDoors(2)
                .built()
                .inCity("Bavaria")
                .atAddress("BMW Gmbh")
                .build();

        System.out.println(car);
    }
}
