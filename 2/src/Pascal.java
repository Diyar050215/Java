import stdlib.StdOut;

public class Pascal {
    // Entry point.
    public static void main(String[] args) {
        // TODO

        // Read the input.
        int n = Integer.parseInt(args[0]);

        // Create the 2D array.
        int [][] a = new int[n+1][];

        // Initialize the array.
        for (int i = 0; i <= n; i++){
            a[i] = new int[i+1];
            for (int j=0; j <=i ; j++){
                a[i][j] = 1;
            }
        }
        // Compute the values.
        for (int i = 2; i <= n; i++){
            for (int j = 1; j < i; j++){
                a[i][j] = a[i-1][j-1] + a[i-1][j];
            }
        }
        // Print the triangle.
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= i; j++){
                if (j < i) {
                    StdOut.print(a[i][j] + " ");
                } else {
                    StdOut.println(a[i][j]);
                }
            }
        }
    }
}
