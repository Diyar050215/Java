import stdlib.StdOut;

public class Factorial {
    // Entry point.
    public static void main(String[] args) {
        // TODO
        // receive command line input 
        int n = Integer.parseInt(args[0]);

        // start result with 1
        long result = 1;

        // Compute the factorial
        for(int i = 1; i < n + 1; i++){
            result *= i;
        }
        
        StdOut.println(result);



    }
}
