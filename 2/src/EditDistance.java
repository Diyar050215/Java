import stdlib.StdIn;
import stdlib.StdOut;

public class EditDistance {
    // Entry point.
    public static void main(String[] args) {
        // TODO

        // Read the input.
        String x = StdIn.readString();
        String y = StdIn.readString();

        // Compute the lengths.
        int m = GSA.length(x);
        int n = GSA.length(y);

        // Initialize the DP table.
        int [][] opt = new int[m +1][n+1];

        // Initialize the first column.
        for (int i = 0; i <= m; i++){
            opt[i][n] = 2 * (m - i);
        }
        // Initialize the last row.
        for (int j = 0; j <= n; j++){
            opt[m][j] = 2 * (n - j);
        }
        // Fill the DP table.
        for(int i = m-1; i >= 0; i--){
            for (int j = n-1; j >= 0;j--){
                if (GSA.charAt(x,i) == GSA.charAt(y,j)) {
                    opt[i][j] = GSA.min(opt[i + 1][j + 1],opt[i+1][j]+2, opt[i][j+1]+2);
                } else {
                    opt[i][j] = GSA.min(opt[i + 1][j + 1] + 1,opt[i+1][j]+2, opt[i][j+1]+2);
                }
            }
        }
        // Output the results.
        StdOut.println(x);
        StdOut.println(y);

        // output dimensions
        StdOut.println((m + 1) + " " + (n + 1));

        // Print the DP table.
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
               if (j < n) {
                   StdOut.printf("%3d ", opt[i][j]);
               } else {
                   StdOut.printf("%3d\n", opt[i][j]);
               }
            }
        }
    }
}
