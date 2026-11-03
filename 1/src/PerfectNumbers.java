import stdlib.StdOut;

public class PerfectNumbers {
    // Entry point.
    public static void main(String[] args) {
        // TODO
        // receive command line input
        int n = Integer.parseInt(args[0]);

        // find perfect numbers
        for(int i =2; i < n + 1; i++){

            // initialize sum of divisors
            int total = 0;

            // find divisors
            for(int j = 1; j <= i/2;j++){
               if(i % j == 0){
                    total += j;
                }
            }
            // check if perfect
            if (total == i) {
                StdOut.println(i);
            }
        }
    }
}