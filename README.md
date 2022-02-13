# Poker Hand Analyzer

#### This is a java maven project. You can use this project if you want a poker hand analyzer only for determining which combo a player has. Keep in mind it doesn't look for royal combos.

Score 0 = flush

Score 1 = straight

Score 1 = straight

Score 2 = four of a kind

Score 3 = full house

Score 4 = three of a kind

Score 5 = two pairs

Score 6 = one pair

Score 100 = no combo


## Usage

```java

/*
create a hand with 5 cards
*/

public ArrayList<Card> playerPokerHand= new ArrayList<>();
        playerPokerHand.add(new Card(10, "Hearts"));
        playerPokerHand.add(new Card(10, "Diamonds"));
        playerPokerHand.add(new Card(10, "Hearts"));
        playerPokerHand.add(new Card(5, "Diamonds"));
        playerPokerHand.add(new Card(5, "Hearts"));

/*
Instantiate the HandAnalyzer object, set the hand, and then get the score.
It will return some int values that represent the score of the hand.
See the list from above.
*/

public HandAnalyzer handAnalyzer = new HandAnalyzer();
        handAnalyzer.setHand(playerPokerHand);

System.out.println("Score is: " + handAnalyzer.getScore());
```
## License
[MIT](https://choosealicense.com/licenses/mit/)