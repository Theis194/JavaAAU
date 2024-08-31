public class Card {
  Integer value;
  Suit suit;
  String name;
  
  public Card(Integer value, Suit suit) {
    this.value = value;
    this.suit = suit;
    switch (value) {
      case 10:
        this.name = "Jack";
        break;
      case 11:
        this.name = "Queen";
        break;
      case 12:
        this.name = "King";
        break;
      default:
        this.name = value.toString();
        break;
    }
  }
}
