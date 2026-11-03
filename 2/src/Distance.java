import stdlib.StdIn;
import stdlib.StdOut;

public class Distance {
    // Entry point.
    public static void main(String[] args) {
        // TODO
        // Read input
        int n = Integer.parseInt(args[0]);

        // Initialize arrays
        double[] x = new double[n];
        double[] y = new double[n];

        // Read input with for loop in list x
        for (int i = 0; i < n; i++) {
            x[i] = StdIn.readDouble();
        }
        // Read input with for loop in list y
        for ( int i = 0; i < n; i++) {
            y[i] = StdIn.readDouble();
        }
        // Compute distance
        Double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += Math.pow(x[i] - y[i], 2);
        }
        StdOut.println(Math.sqrt(sum));
    }
}
