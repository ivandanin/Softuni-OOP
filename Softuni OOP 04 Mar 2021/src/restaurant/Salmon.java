package restaurant;

import java.math.BigDecimal;

public class Salmon extends MainDish {

    private final double SALMON_GRAMS = 22;

    public Salmon(String name, BigDecimal price, double grams) {
        super(name, price, grams);
    }
}
