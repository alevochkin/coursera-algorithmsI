/**
 * Represent a series of computational experiments.
 */
public class PercolationStats {
    private double[] fractions;

    /**
     * Perform T independent experiments on an N-by-N grid
     *
     * @param N number of grid row and column
     * @param T number of experiments
     */
    public PercolationStats(int N, int T) {
        if (N <= 0) {
            throw new IllegalArgumentException("N must be positive");
        }
        if (T <= 0) {
            throw new IllegalArgumentException("T must be positive");
        }
        fractions = new double[T];
        for (int k = 0; k < T; k++) {
            Percolation percolation = new Percolation(N);
            int fraction = 0;
            while (!percolation.percolates()) {
                int i = StdRandom.uniform(1, N + 1);
                int j = StdRandom.uniform(1, N + 1);
                if (!percolation.isOpen(i, j)) {
                    percolation.open(i, j);
                    fraction++;
                }
            }
            fractions[k] = (double) fraction / (N * N);
        }
    }

    /**
     * Return sample mean of percolation threshold.
     *
     * @return mean of percolation threshold
     */
    public double mean() {
        return StdStats.mean(fractions);
    }

    /**
     * Return sample standard deviation of percolation threshold
     *
     * @return standard deviation of percolation threshold
     */
    public double stddev() {
        return StdStats.stddev(fractions);
    }

    /**
     * Return low endpoint of 95% confidence interval
     *
     * @return low  endpoint of 95% confidence interval
     */
    public double confidenceLo() {
        return mean() - (1.96 * stddev() / Math.sqrt(fractions.length));
    }

    /**
     * Return high endpoint of 95% confidence interval
     *
     * @return high endpoint of 95% confidence interval
     */
    public double confidenceHi() {
        return mean() + (1.96 * stddev() / Math.sqrt(fractions.length));
    }

    /**
     * test client
     *
     * @param args - array of arguments
     */
    public static void main(String[] args) {
        try {
            int N = Integer.parseInt(args[0]);
            int T = Integer.parseInt(args[0]);
            PercolationStats stats = new PercolationStats(N, T);
            System.out.println("mean\t =" + stats.mean());
            System.out.println("stddev\t =" + stats.stddev());
            System.out.println("95% confidence interval =" + stats.confidenceLo() + ", " + stats.confidenceHi());
        } catch (NumberFormatException e) {
            System.out.println("enter grid site size and number of independent computational experiments");
        }
    }
}