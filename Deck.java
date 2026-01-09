package flashcards;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Deck {
    private Map<String, String> cards;
    private final Scanner scan;
    private int numCards;

    public Deck(int numCards, Scanner scan) {
        this.cards = new LinkedHashMap<>();
        this.scan = scan;
        this.numCards = numCards;
    }

    public void createCards() {
        String term, definition;

        for (int i = 1; i <= numCards; i++) {
            System.out.printf("Card #%d:\n", i);
            term = scan.nextLine();
            while (cards.containsKey(term)) {
                System.out.printf("The term \"%s\" already exists. Try again:", term);
                term = scan.nextLine();
            }
            System.out.printf("The definition for card #%d:\n", i);
            definition = scan.nextLine();
            while (cards.containsValue(definition)) {
                System.out.printf("The definition \"%s\" already exists. Try again:", definition);
            }
            cards.put(term, definition);
        }
    }

    public void useCards() {
        String answer;

        for (String term : cards.keySet()) {
            System.out.printf("Print the definition of \"%s\":\n", term);
            answer = scan.nextLine();
            if (answer.equals(cards.get(term))) {
                System.out.println("Correct!");
            } else if (cards.containsValue(answer)) {
                System.out.printf("Wrong. The right answer is \"%s\", but your definition is correct for \"%s\".\n",
                        cards.get(term), getTermFromDefinition(answer));
            } else {
                System.out.printf("Wrong. The right answer is \"%s\".\n", cards.get(term));
            }
        }
    }

    private String getTermFromDefinition(String definition) {
        for (String term : cards.keySet()) {
            if (definition.equals(cards.get(term))) {
                return term;
            }
        }
        return null;
    }
}
