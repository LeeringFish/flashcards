package flashcards;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String term, definition;

        System.out.println("Card:");
        term = scan.nextLine();
        System.out.println(term);

        System.out.println("Definition:");
        definition = scan.nextLine();
        System.out.println(definition);
    }
}
