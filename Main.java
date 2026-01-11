package flashcards;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deck flashcards = new Deck(scan);

        boolean running = true;
        String userInput;

        while (running) {
            System.out.println("Input the action (add, remove, import, export, ask, exit):");
            userInput = scan.nextLine();
            switch (userInput) {
                case "add" -> addCard(flashcards, scan);
                case "remove" -> removeCard(flashcards, scan);
                case "import" -> importCards(flashcards, scan);
                case "export" -> exportCards(flashcards, scan);
                case "exit" -> running = false;
                default -> System.out.println("Invalid selection");
            }
        }
        System.out.println("Bye bye!");
    }

    public static void addCard(Deck cards, Scanner scan) {
        String term, definition;

        System.out.println("The card:");
        term = scan.nextLine();
        if (cards.containsTerm(term)) {
            System.out.printf("The term \"%s\" already exists.\n\n", term);
            return;
        }

        System.out.println("The definition of the card: ");
        definition = scan.nextLine();
        if (cards.containsDefinition(definition)) {
            System.out.printf("The definition \"%s\" already exists.\n\n", definition);
            return;
        }

        cards.addCard(term, definition);
        System.out.printf("The pair (\"%s\":\"%s\") has been added.\n\n", term, definition);
    }

    public static void removeCard(Deck cards, Scanner scan) {
        String card;
        System.out.println("Which card?");
        card = scan.nextLine();
        if (cards.containsTerm(card)) {
            cards.removeCard(card);
            System.out.println("The card has been removed.");
        } else {
            System.out.printf("Can't remove \"%s\": there is no such card.\n", card);
        }

        System.out.println();
    }

    public static void importCards(Deck cards, Scanner scan) {
        String fileName;
        System.out.println("File name:");
        fileName = scan.nextLine();
        int numImportedCards = cards.readFromFile(fileName);
        if (numImportedCards == 0) {
            System.out.println("File not found.");
        } else {
            System.out.printf("%d cards have been loaded.\n", numImportedCards);
        }
        System.out.println();
    }

    public static void exportCards(Deck cards, Scanner scan) {
        System.out.println("File name:");
        String fileName = scan.nextLine();
        int numSavedCards = cards.writeToFile(fileName);
        System.out.printf("%d cards have been saved.\n\n", numSavedCards);
    }
}
