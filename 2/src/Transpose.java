import stdlib.StdIn;
import stdlib.StdOut;

public class Transpose {
    // Entry point.
    public static void main(String[] args) {
        // TODO
        // Read matrix dimensions from input
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        // make a 2D array
        double [][] a = new double[m][n];

        // Read values into the array
        for (int i=0; i < m; i++){
            for (int j=0; j < n; j++){
                a[i][j] = StdIn.readDouble();
            }
        }
        //make a new array and transpose the values
        double [][] b = new double[n][m];
        for (int i=0; i < n; i++){
            for (int j=0; j < m; j++){
                b[i][j] = a[j][i];
            }
        }
        // Print the transposed array 
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (j < m-1) {
                    StdOut.printf("%.6f ", b[i][j]);
                } else {
                    StdOut.printf("%.6f\n", b[i][j]);
                }
            }
        }
    }
}
