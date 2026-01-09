package flashcards;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Deck {
    private Map<String, String> cards;
    private final Scanner scan;

    public Deck(Scanner scan) {
        this.cards = new LinkedHashMap<>();
        this.scan = scan;
    }

    public void addCard(String term, String definition) {
        cards.put(term, definition);
    }

    public boolean containsTerm(String term) {
        return cards.containsKey(term);
    }

    public boolean containsDefinition(String definition) {
        return cards.containsValue(definition);
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
