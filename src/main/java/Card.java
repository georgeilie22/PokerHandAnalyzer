public class Card {

    private final int face;
    private final String suit;

    // two argument constructor initializes card's face and suit
    public Card(int cardFace, String cardSuit) {
        this.face = cardFace;
        this.suit = cardSuit;
    }

    public int getFace() {
        return face;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "face='" + face + '\'' +
                ", suit='" + suit + '\'' +
                '}';
    }
}
