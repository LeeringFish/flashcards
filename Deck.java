package flashcards;

import java.util.ArrayList;
import java.util.Scanner;

public class Deck {
    private ArrayList<Card> cards;
    private final Scanner scan;
    private int numCards;

    public Deck(int numCards, Scanner scan) {
        this.cards = new ArrayList<>();
        this.scan = scan;
        this.numCards = numCards;
    }

    public void createCards() {
        String term, definition;

        for (int i = 1; i <= numCards; i++) {
            System.out.printf("Card #%d:\n", i);
            term = scan.nextLine();
            System.out.printf("The definition for card #%d:\n", i);
            definition = scan.nextLine();
            cards.add(new Card(term, definition));
        }
    }

    public void useCards() {
        String answer;

        for (Card card : cards) {
            System.out.printf("Print the definition of \"%s\":\n", card.getTerm());
            answer = scan.nextLine();
            if (answer.equals(card.getDefinition())) {
                System.out.println("Correct!");
            } else {
                System.out.printf("Wrong. The right answer is \"%s\".\n", card.getDefinition());
            }
        }
    }
}
