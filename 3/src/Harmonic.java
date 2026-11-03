import stdlib.StdOut;

public class Harmonic {
    // Entry point.
    public static void main(String[] args) {
        // TODO
        // save command line argument
        int n = Integer.parseInt(args[0]);

        // create a new Rational number to hold the total
        Rational total = new Rational(0);

        // compute the harmonic number
        for (int i = 1; i <= n; i++) {
            Rational term = new Rational(1, i);
            total = total.add(term);
        }
        StdOut.println(total);
    }
}
