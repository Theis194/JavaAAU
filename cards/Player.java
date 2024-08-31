import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    Integer score;
    List<Card> hand;
    
    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.hand = new ArrayList<Card>();
    }
    
    public void addCard(Card card) {
        this.hand.add(card);
    }
    
    public void removeCard(Card card) {
        for (Card c : this.hand) {
            if (c.name.equals(card.name) && c.suit.equals(card.suit)) {
                this.hand.remove(c);
                break;
            }
        }
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getScore() {
        return this.score;
    }
    
    public void setScore(Integer score) {
        this.score = score;
    }
    
    public void increaseScore(Integer score) {
        this.score += score;
    }
    
    public void printHand() {
        for (Card card : this.hand) {
            System.out.println(card.name + " of " + card.suit);
        }
    }
    
    public void printScore() {
        System.out.println(this.name + " has " + this.score + " points");
    }
}
