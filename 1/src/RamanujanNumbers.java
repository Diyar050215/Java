import stdlib.StdOut;

public class RamanujanNumbers {
    // Entry point.
    public static void main(String[] args) {
        // TODO
        // receive command line input
        int n = Integer.parseInt(args[0]);

        // find Ramanujan Number
         int a = 1;
        

         // check and find Ramanujan Numbers
         while (a * a * a < n){
            int b = a + 1;
            while ( (a * a * a) + (b * b * b) <= n){
                int c = a + 1;
                while (c * c * c <= n){
                    int d = c + 1;
                    while ((c * c * c) + (d * d * d) <= n){
                        int x = (a * a * a) + (b * b * b);
                        int y = (c * c * c) + (d * d * d);
                        if (x == y) {
                            StdOut.println( x + " = " + a + "^3 + " + b + "^3 = " + c + "^3 + " + d + "^3");
                        }
                        d++;
                    }
                    c++;
                }
                b++;
            }
            a++;
        }

    }
}
