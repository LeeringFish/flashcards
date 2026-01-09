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
}
