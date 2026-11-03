import stdlib.StdOut;

public class PrimalityTest {
    // Entry point.
    public static void main(String[] args) {
        // TODO
        // receive command line input
        int n = Integer.parseInt(args[0]);

        //check if n is prime
        int i = 2;
        while (i <= n/i) {
            if( n % i == 0) {
                break;
            }
            i++;
        }
        if ( i > n/i) {
            StdOut.println("true");
        } else {
            StdOut.println("false");
            }
        }
    }
    