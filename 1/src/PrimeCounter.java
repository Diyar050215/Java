import stdlib.StdOut;

public class PrimeCounter {
    // Entry point.
    public static void main(String[] args) {
        // TODO
        // receive command line input
        int n = Integer.parseInt(args[0]);

        // count primes
        int count = 0;
        for (int i = 2; i < n + 1; i ++) {
            int j = 2;
            while ( j <= i/j) {
                if ( i % j == 0) {
                    break;
                }
                j++;
            }
            
            if ( j > i/j) {
                count++;
            }
        }
        StdOut.println(count);
    }
}
