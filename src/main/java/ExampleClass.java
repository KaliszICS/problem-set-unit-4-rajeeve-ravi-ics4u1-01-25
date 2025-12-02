import java.util.ArrayList;
// the class Card with a purpose of making 3 parameters
class Card {
    //Instance of variables
    String name;
    String suit;
    int number;
    
    public Card(String name, String suit, int number) {
        this.name = name;
        this.suit = suit;
        this.number = number;

    }
    
    public String getName() {
        return name;
    }
    
    public String getSuit() {
        return suit;

    }
   
    int getNumber() {
        return number;

    }
    public Void  setName(String name) {
        this.name = name;
        return null;
    }
    public Void setSuit(String suit) {
        this.suit = suit;
        return null;
    }
    // the order of how the cards will be labeled
    public void  setNumber(int number) {
        this.number = number;
    }
    String tostring() {
        return name + " " + number + " " + suit;
    }

    }
// the constructor #1 Takes an array of cards
class Deck {
    ArrayList<Card> deck;
//
    Deck(Card[] cards) {
        deck = new ArrayList<>();
        for (Card card : cards) {
            if (card != null) {
                deck.add(card);
            }
        }
    }

    // the constructor #2 creates an unshuffled deck
    public Deck() {
        deck = new ArrayList<>();
        String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
        String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        for (int i = 0; i < number.length; i++) {
            deck.add(new Card(names[i], suits[i], number[i]));
        }
        // all the cards(52 of them)
        int size = deck.size();
        for (int i = 0; i < size; i++) {
            deck.get(i).setNumber(i);
        }
        Card draw;
        {
            if (deck.get(deck.size() - 1).getNumber() == deck.get(size - 1).getNumber()) {
                deck.remove(deck.size() - 1);
            }

        }

    }
    // Shuffles the deck of cards
    public void shuffle() {
        for (int i = 0; i < deck.size(); i++) {
            int j = (i + 1) % deck.size();
            deck.get(i).setNumber(j);
            Card shuffle = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, shuffle);
        }

    }
    // adds cards back into the deck
    public void addCard(Card card) {
        if (card != null) {
            deck.add(card);
        }
    }
    // reshuffles the deck of cards
    public void reshuffle() {
        for (Card card : deck) {
            if (card != null) {

            }
            shuffle();
        }
    }
    //print system for main class
    public void print() {
        for (Card card : deck) {
            System.out.println(card);
        }
    }
    //meant to print the cdeck of cards
    public class mainClass {
        public void main(String[] args) {
            Deck deck = new Deck();
            deck.shuffle();
            deck.print();
        }
    }
}
