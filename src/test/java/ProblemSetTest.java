import java.util.ArrayList;

class Card {
    private String name;
    private String suit;
    private int value;

    public Card(String name, String suit, int value) {
        this.name = name;
        this.suit = suit;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name + " of " + suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return value == card.value &&
                name.equals(card.name) &&
                suit.equals(card.suit);
    }
}

class Deck {
    private ArrayList<Card> deck;

    // Constructor 1: Takes an array of cards
    public Deck(Card[] cards) {
        deck = new ArrayList<>();
        for (Card card : cards) {
            if (card != null) {
                deck.add(card);
            }
        }
    }

    // Constructor 2: Generates an unshuffled deck
    public Deck() {
        deck = new ArrayList<>();
        String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
        String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        // Create all 52 cards
        for (String suit : suits) {
            for (int i = 0; i < names.length; i++) {
                deck.add(new Card(names[i], suit, values[i]));
            }
        }
    }

    public int size() {
        return deck.size();
    }

    public Card draw() {
        if (deck.isEmpty()) {
            return null;
        }
        return deck.remove(deck.size() - 1);
    }

    public void shuffle() {
        for (int i = deck.size() - 1; i > 0; i--) {
            int j = (int)(Math.random() * (i + 1));
            Card temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }
    }

    public void addCard(Card card) {
        if (card != null) {
            deck.add(card);
        }
    }

    public void reshuffle(Card[] cards) {
        for (Card card : cards) {
            if (card != null) {
                deck.add(card);
            }
        }
        shuffle();
    }

    public void printDeck() {
        for (Card card : deck) {
            System.out.println(card);
        }
    }
}

// Main test class
 class MainClass {
    public static void main(String[] args) {
        System.out.println("=== Testing Card Class ===");
        Card card1 = new Card("Queen", "Diamonds", 12);
        System.out.println("Card: " + card1);
        System.out.println("Name: " + card1.getName());
        System.out.println("Suit: " + card1.getSuit());
        System.out.println("Value: " + card1.getValue());

        Card card2 = new Card("Queen", "Diamonds", 12);
        System.out.println("Cards equal: " + card1.equals(card2));

        System.out.println("\n=== Testing Deck Class ===");
        Deck deck = new Deck();
        System.out.println("Initial deck size: " + deck.size());

        System.out.println("\nFirst 5 cards (unshuffled):");
        for (int i = 0; i < 5; i++) {
            System.out.println(deck.draw());
        }
        System.out.println("Deck size after drawing 5: " + deck.size());

        System.out.println("\n=== Testing Shuffle ===");
        Deck deck2 = new Deck();
        deck2.shuffle();
        System.out.println("First 10 cards after shuffle:");
        for (int i = 0; i < 10; i++) {
            System.out.println(deck2.draw());
        }

        System.out.println("\n=== Testing Add Card ===");
        deck2.addCard(new Card("Joker", "Special", 0));
        System.out.println("Deck size after adding Joker: " + deck2.size());

        System.out.println("\n=== Testing Reshuffle ===");
        Card[] newCards = {
                new Card("Ace", "Hearts", 1),
                new Card("King", "Spades", 13)
        };
        deck2.reshuffle(newCards);
        System.out.println("Deck size after reshuffle: " + deck2.size());

        System.out.println("\n=== Full Deck (shuffled) ===");
        Deck fullDeck = new Deck();
        fullDeck.shuffle();
        fullDeck.printDeck();
    }
}
