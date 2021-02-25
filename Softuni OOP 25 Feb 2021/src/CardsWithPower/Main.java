package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rank = scanner.nextLine();
        String suit = scanner.nextLine();

        Card card = new Card(SuitPowers.valueOf(suit), RankPowers.valueOf(rank));

        System.out.println(card.print());
    }
}
