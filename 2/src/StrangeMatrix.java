import stdlib.StdOut;

public class StrangeMatrix {
    public static void main(String[] args) {
        // TODO
        // Implement the main logic
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        // create a new 2D array
        int [][] a = new int[m][n];

        // initialize the last column
        for (int i = 0; i < m; i++){
            a[i][n-1] = m - i - 1;
        }
        // initialize the last row
        for ( int j = 0; j < n; j++){
            a[m-1][j] = n - j - 1;
        }
        // fill in the rest of the array
        for (int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                a[i][j] = a[i][j+1] + a[i+1][j+1] + a[i+1][j];
            }
        }

        // print the array in 2D format
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (j < n-1) {
                    StdOut.printf("%5d ", a[i][j]);
                } else {
                    StdOut.printf("%5d\n", a[i][j]);
                }
            }
        }
    }
}
