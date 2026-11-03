import stdlib.StdOut;
import stdlib.StdRandom;

public class Card {
    // Entry point.
    public static void main(String[] args) {
        // TODO
        // rank
        String rankStr = "";
        int rank = StdRandom.uniform(2, 15);
        if (rank == 11) {
               rankStr = "Jack";
        } else if (rank == 12) {
               rankStr = "Queen";
        } else if (rank == 13) {
               rankStr = "King";
        } else if (rank == 14) {
               rankStr = "Ace";
        } else if (rank == 2) {
               rankStr = "2";
        } else if (rank == 3) {
               rankStr = "3";
        } else if (rank == 4) {
               rankStr = "4";
        } else if (rank == 5) {
               rankStr = "5";
        } else if (rank == 6) {
               rankStr = "6";
        } else if (rank == 7) {
               rankStr = "7";
        } else if (rank == 8) {
               rankStr = "8";
        } else if (rank == 9) {
               rankStr = "9";
        } else if (rank == 10) {
               rankStr = "10";
        }
        

        // suit
        String suitStr = "";
        int suit = StdRandom.uniform(1,5);
        if (suit == 1) {
           suitStr = "Clubs";
        } else if (suit == 2) {
               suitStr = "Diamonds";
        } else if (suit == 3) {
               suitStr = "Hearts";
        } else if (suit == 4) {
               suitStr = "Spades";
        }
        StdOut.println(rankStr + " of " + suitStr);
    }
}