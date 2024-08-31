import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CardGM game = new CardGM();
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        game.addPlayer(player1);
        game.addPlayer(player2);

        game.startGame();

        ArrayList<Player> players = (ArrayList<Player>) game.getPlayers();
        for (Player player : players) {
            System.out.println(player.getName() + " hand:");
            player.printHand();
        }
    }
}
