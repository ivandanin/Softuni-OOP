package onlineShop.models.products.components;

public class RandomAccessMemory extends BaseComponent {

    private static double MULTIPLIER = 1.2;

    public RandomAccessMemory(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, MULTIPLIER * overallPerformance, generation);
    }
}
