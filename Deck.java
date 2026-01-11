package flashcards;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

    public void removeCard(String card) {
        cards.remove(card);
    }

    public int readFromFile(String fileName) {
        String line;
        String[] parts;
        int numLoaded = 0;

        File file = new File(fileName);
        try (Scanner fileReader = new Scanner(file)) {
            while (fileReader.hasNext()) {
                line = fileReader.nextLine();
                parts = line.split(",");
                cards.put(parts[0], parts[1]);
                numLoaded++;
            }
            return numLoaded;
        } catch (IOException e) {
            return 0;
        }
    }

    public int writeToFile(String fileName) {
        File file = new File(fileName);
        try (PrintWriter printWriter = new PrintWriter(file)) {
            for (String term: cards.keySet()) {
                printWriter.printf("%s,%s\n", term, cards.get(term));
            }
            return cards.size();
        } catch (IOException e) {
            return 0;
        }

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
