
import java.util.*;

class Card {
    String symbol;
    String rank;

    public Card(String symbol, String rank) {
        this.symbol = symbol;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Symbol: " + symbol + ", Rank: " + rank;
    }
}

public class Problem2 {
    static List<Card> cards = new ArrayList<>();

    public static void addCard(Scanner sc) {
        System.out.print("Enter Symbol (Hearts, Diamonds, etc.): ");
        String symbol = sc.next();
        System.out.print("Enter Rank (Ace, 2, King, etc.): ");
        String rank = sc.next();
        cards.add(new Card(symbol, rank));
        System.out.println("Card added successfully!");
    }

    public static void searchBySymbol(Scanner sc) {
        System.out.print("Enter Symbol to search: ");
        String symbol = sc.next();
        boolean found = false;
        for (Card card : cards) {
            if (card.symbol.equalsIgnoreCase(symbol)) {
                System.out.println(card);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cards found for the given symbol!");
        }
    }

    public static void displayAllCards() {
        if (cards.isEmpty()) {
            System.out.println("No cards in the collection.");
        } else {
            for (Card card : cards) {
                System.out.println(card);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Card");
            System.out.println("2. Search by Symbol");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> addCard(sc);
                case 2 -> searchBySymbol(sc);
                case 3 -> displayAllCards();
                case 4 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

