import stdlib.StdOut;

public class Fibonacci {
    // Entry point.
    public static void main(String[] args) {
        // TODO
        // receive command line input
        int n = Integer.parseInt(args[0]);

        // compute the fibonacci squence
        long a = -1;
        long b = 1;
        int i = 0;
        while (i <= n) {
            long temp = a + b;
            a = b;
            b = temp;
            i++;
        }
        StdOut.println(b);
    }
}
