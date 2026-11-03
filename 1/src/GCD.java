import stdlib.StdOut;

public class GCD {
    // Entry point.
    public static void main(String[] args) {
        // TODO
        // Compute the GCD of two numbers.
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        while ( a % b !=0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        StdOut.println(b);
    }
}
