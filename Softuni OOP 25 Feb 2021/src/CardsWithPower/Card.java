package CardsWithPower;

public class Card {
    SuitPowers suit;
    RankPowers rank;
    int power;

    public Card(SuitPowers suit, RankPowers rank) {
        this.suit = suit;
        this.rank = rank;
        this.power = rank.getPower() + suit.getPower();
    }

    public String print() {
        return String.format("Card name: %s of %s; Card power: %d", rank, suit, this.power);
    }
}
