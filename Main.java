package flashcards;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Input the number of cards:");
        int numCards = Integer.parseInt(scan.nextLine());

        Deck flashcards = new Deck(numCards, scan);
        flashcards.createCards();
        flashcards.useCards();
    }
}
