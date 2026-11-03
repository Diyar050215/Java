import stdlib.StdArrayIO;
import stdlib.StdIn;
import stdlib.StdOut;

public class Alignment {
    // Entry point.
    public static void main(String[] args) {
        // TODO
        // Read the input.
        String x = StdIn.readString();
        String y = StdIn.readString();

        // Compute the lengths.
        int m = GSA.length(x);
        int n = GSA.length(y);

        // Read the DP table.
        int [][] opt = StdArrayIO.readInt2D();

        // Print the initial value
        StdOut.println(opt[0][0]);

        // Backtrack to find the alignment
        int i = 0;
        int j = 0;

        // Backtrack through the DP table
        while (i < m && j < n) {
            if( opt[i][j] == opt[i + 1][j] +2){
                StdOut.println(GSA.charAt(x,i)  + " " + "- 2");
                i++;
            }else if (opt[i][j] == opt[i][j+1] + 2){
                StdOut.println("- " + GSA.charAt(y,j) + " 2");
                j++;
            } else if (GSA.charAt(x,i) == GSA.charAt(y,j)){
                StdOut.println(GSA.charAt(x,i) + " " + GSA.charAt(y,j) + " 0");
                i++;
                j++;
            } else {
                StdOut.println(GSA.charAt(x,i) + " " + GSA.charAt(y,j) + " 1");
                i++;
                j++;

            }
        }
        // Handle remaining characters in x
        while (i < m) {
            StdOut.println(GSA.charAt(x,i) + " " + "- 2");
            i++;
        }
        // Handle remaining characters in y
        while (j < n) {
            StdOut.println("- " + GSA.charAt(y,j) + " 2");
            j++;
        }

    }
}