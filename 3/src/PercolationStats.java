import stdlib.StdOut;
import stdlib.StdRandom;
import stdlib.StdStats;

public class PercolationStats {
    private int m; // number of percolation experiments
    private double[] x; // fraction of sites opened for each trial until percolation

    // Performs m independent experiments on an n x n percolation system.
    public PercolationStats(int n, int m) {
        // TODO
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("Illegal n or m");
        }
        this.m = m;
        this.x = new double[m];

        // Perform m independent experiments
        for (int i = 0; i < m; i++) {
            Percolation perc = new Percolation(n);

            // Open sites until the system percolates
            while (!perc.percolates()) {
                int row = StdRandom.uniform(n);
                int col = StdRandom.uniform(n);
                
                if (!perc.isOpen(row, col)) {
                    perc.open(row, col);
                }
            }
            // Compute the fraction of open sites
            x[i] = (double) perc.numberOfOpenSites() / (n * n);
        }
    }

    // Returns sample mean of percolation threshold.
    public double mean() {
        // TODO
        double sum = 0.0;
        for (int i = 0; i < m; i++) {
            sum += x[i];
        }
        return sum / m;
    }

    // Returns sample standard deviation of percolation threshold.
    public double stddev() {
        // TODO
        double sum = 0.0;
        double mean = mean();
        for (int i = 0; i < m; i++) {
            sum += (x[i] - mean) * (x[i] - mean);
        }
        return Math.sqrt(sum / (m - 1));
    }

    // Returns low endpoint of the 95% confidence interval.
    public double confidenceLow() {
        // TODO
        return mean() - (1.96 * stddev() / Math.sqrt(m));
    }

    // Returns high endpoint of the 95% confidence interval.
    public double confidenceHigh() {
        // TODO
        return mean() + (1.96 * stddev() / Math.sqrt(m));
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(n, m);
        StdOut.printf("Percolation threshold for a %d x %d system:\n", n, n);
        StdOut.printf("  Mean                = %.3f\n", stats.mean());
        StdOut.printf("  Standard deviation  = %.3f\n", stats.stddev());
        StdOut.printf("  Confidence interval = [%.3f, %.3f]\n", stats.confidenceLow(), stats.confidenceHigh());
    }
}
