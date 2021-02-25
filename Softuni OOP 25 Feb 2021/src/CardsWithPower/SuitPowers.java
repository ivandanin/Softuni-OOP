package CardsWithPower;

public enum SuitPowers {
    CLUBS (0),
    DIAMONDS (13),
    HEARTS (26),
    SPADES (39);

    private int power;

    SuitPowers(int suit) {
        this.power = suit;
    }

    public int getPower() {
        return power;
    }
}
