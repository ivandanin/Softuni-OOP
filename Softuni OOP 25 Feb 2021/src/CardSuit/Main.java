package CardSuit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suits:");
        for (Deck deck : Deck.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", deck.ordinal(), deck);
        }
    }
}
