import stdlib.StdOut;
import stdlib.StdRandom;

public class Stats {
    // Entry Point.
    public static void main(String[] args) {
        // TODO
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        // generates three random dubouls
        double x1 = StdRandom.uniform((double) a, (double) b);
        double x2 = StdRandom.uniform((double) a, (double) b);
        double x3 = StdRandom.uniform((double) a, (double) b);

        // computes the average
        double m = (x1 + x2 + x3) / 3;

        //variance 
        double var = ((x1 - m) * (x1 - m) + (x2 - m) * (x2 - m) + (x3 - m) * (x3 - m)) / 3;

        // make var in square root
        double std = Math.sqrt(var);

        // print the results
        StdOut.println( m + " " + var + " " + std); 



    }
}