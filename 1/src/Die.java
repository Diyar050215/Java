import stdlib.StdOut;
import stdlib.StdRandom;

public class Die {
    // Entry point.
    public static void main(String[] args) {
        // TODO
        // roll a die
        int die = StdRandom.uniform(1,7);

        // Display the die roll
        if (die == 1) {
            StdOut.println( " " + " " + " " + " " + " " + "\n" + " " + " " + "*" + " " + " " + "\n" + " " + " " + " " + " " + " ");
        } else if (die == 2) {
            StdOut.println( "*" + " " + " " + " " + " " + "\n" + " " + " " + " " + " " + " " + "\n" + " " + " " + " " + " " + "*");
        }  else if (die == 3) {
            StdOut.println( "*" + " " + " " + " " + " " + "\n" + " " + " " + "*" + " " + " " + "\n" + " " + " " + " " + " " + "*");
        }  else if (die == 4) {
            StdOut.println( "*" + " " + " " + " " + "*" + "\n" + " " + " " + " " + " " + " " + "\n" + "*" + " " + " " + " " + "*");
        }  else if (die == 5) {
            StdOut.println( "*" + " " + " " + " " + "*" + "\n" + " " + " " + "*" + " " + " " + "\n" + "*" + " " + " " + " " + "*");
        }  else if (die == 6) {
            StdOut.println( "*" + " " + "*" + " " + "*" + "\n" + " " + " " + " " + " " + " " + "\n" + "*" + " " + "*" + " " + "*");
        }
    }
}
