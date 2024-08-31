import java.util.*;;

public class CardGM implements SimpleGameMaster {
    List<Player> players = new ArrayList<Player>();
    List<Card> deck = new ArrayList<Card>();

    public CardGM() {
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                deck.add(new Card(j, Suit.values()[i]));
            }
        }

        this.shuffleDeck();
    }

    public void startGame() {
        for (int i = 0; i < 13; i++) {
            for (Player player : players) {
                this.dealCard(player);
            }
        }
        System.out.println("Game started");
    }
    
    public void endGame() {
        System.out.println("Game ended");
    }
    
    public void addPlayer(Player player) {
        players.add(player);
    }
    
    public void removePlayer(Player player) {
        for (Player p : players) {
            if (p.getName().equals(player.getName())) {
                players.remove(p);
                break;
            }
        }
    }

    public List<Player> getPlayers() {
        return this.players;
    }
    
    public void dealCard(Player player) {
        player.addCard(deck.remove(0));
    }
    
    public void shuffleDeck() {
        Collections.shuffle(deck, new Random(3));
        System.out.println("Deck shuffled");
    }
    
    public void printDeck() {
        System.out.println("Deck printed");
    }
    
    public void printPlayers() {
        System.out.println("Players printed");
    }
    
    public void printPlayerScore(Player player) {
        System.out.println("Player score printed: " + player.getName());
    }
    
    public void printWinner() {
        System.out.println("Winner printed");
    }
    
    public static void main(String[] args) {
        System.out.println("Hello, World");
    }
    
}
