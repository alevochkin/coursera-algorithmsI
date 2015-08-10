/**
 * Class models percolation system.
 */
public class Percolation {
    private boolean[] opened;
    private WeightedQuickUnionUF unionFind;
    private WeightedQuickUnionUF unionFind1;
    private int N;
    private int top;
    private int bottom;

    /**
     * Create N-by-N grid, with all sites blocked.
     *
     * @param N number of row (column)
     */
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N must be positive");
        }
        this.N = N;
        int count = N * N;
        opened = new boolean[count];
        top = count;
        bottom = count + 1;
        unionFind = new WeightedQuickUnionUF(count + 2);
        unionFind1 = new WeightedQuickUnionUF(count + 2);
        for (int i = 0; i < N; i++) {
            unionFind1.union(top, i);
            unionFind.union(top, i);
        }
        for (int i = 0; i < N; i++) {
            unionFind1.union(bottom, i + (N * (N - 1)));
        }
    }

    /**
     * Open site (row i, column j) if it is not open already.
     *
     * @param i row number
     * @param j column number
     */
    public void open(int i, int j) {
        checkIndex(i);
        checkIndex(j);
        int index = getIndex(i, j);
        opened[index] = true;
        if (i - 1 > 0 && isOpen(i - 1, j)) {
            unionFind.union(index, getIndex(i - 1, j));
            unionFind1.union(index, getIndex(i - 1, j));
        }
        if (i + 1 <= N && isOpen(i + 1, j)) {
            unionFind.union(index, getIndex(i + 1, j));
            unionFind1.union(index, getIndex(i + 1, j));
        }
        if (j - 1 > 0 && isOpen(i, j - 1)) {
            unionFind.union(index, getIndex(i, j - 1));
            unionFind1.union(index, getIndex(i, j - 1));
        }
        if (j + 1 <= N && isOpen(i, j + 1)) {
            unionFind.union(index, getIndex(i, j + 1));
            unionFind1.union(index, getIndex(i, j + 1));
        }
    }

    /**
     * Check site (row i, column j) is open.
     *
     * @param i row number
     * @param j column number
     * @return true if site is open else return false
     */
    public boolean isOpen(int i, int j) {
        checkIndex(i);
        checkIndex(j);
        return opened[getIndex(i, j)];
    }

    /**
     * Check  site (row i, column j) is full.
     *
     * @param i row number
     * @param j column number
     * @return return true if site is full else return false.
     */
    public boolean isFull(int i, int j) {
        checkIndex(i);
        checkIndex(j);
        return isOpen(i, j) && unionFind.connected(top, getIndex(i, j));
    }

    /**
     * Check the system percolates.
     *
     * @return true if system percolate else return false
     */
    public boolean percolates() {
        if (N == 1) {
            return isOpen(1, 1);
        }
        return unionFind1.connected(top, bottom);
    }

    private int getIndex(int i, int j) {
        return (i - 1) * N + (j - 1);
    }

    private void checkIndex(int index) {
        if (1 > index || index > N) {
            throw new IndexOutOfBoundsException(index + "must be in rage [1, " + N + "]");
        }
    }

}