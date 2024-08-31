public interface SimpleGameMaster {
    public void startGame();
    public void endGame();
    public void addPlayer(Player player);
    public void removePlayer(Player player);
    public void dealCard(Player player);
    public void shuffleDeck();
    public void printDeck();
    public void printPlayers();
    public void printPlayerScore(Player player);
    public void printWinner();
}
