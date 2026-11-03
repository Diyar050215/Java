import dsa.Inversions;
import dsa.LinkedQueue;
import stdlib.In;
import stdlib.StdOut;

// A data type to represent a board in the 8-puzzle game or its generalizations.
public class Board {
    private final int n;          // board size
    private final int[][] tiles;  // tile values
    private final int hamming;   // Hamming distance
    private final int manhattan;  // Manhattan distance
    private final int blankPos;


    // Constructs a board from an n x n array; tiles[i][j] is the tile at row i and column j, with 0
    // denoting the blank tile.
    public Board(int[][] tiles) {

        
        this.n = tiles.length;
        this.tiles = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.tiles[i][j] = tiles[i][j];
            }
        
        }
       int h = 0;
       int m = 0;
       for (int i = 0; i < n; i++) {
           for (int j = 0; j < n; j++) {
               if (this.tiles[i][j] != 0) {
                    int goal = i * n + j + 1;

                    if (this.tiles[i][j] != goal) {
                       h++;
                   }

                   int goalX = (this.tiles[i][j] - 1) / n;
                   int goalY = (this.tiles[i][j] - 1) % n;
                
                   m += Math.abs(i - goalX) + Math.abs(j - goalY);
               }
           }
       }
       this.hamming = h;
       this.manhattan = m;

       int p = -1;
       for (int i = 0; i < n; i++) {
           for (int j = 0; j < n; j++) {
               if (this.tiles[i][j] == 0) {
                   p = i * n + j + 1;
               }
           }
       }
       this.blankPos = p;
    }

    // Returns the size of this board.
    public int size() {
        return n;
    }

    // Returns the tile at row i and column j of this board.
    public int tileAt(int i, int j) {
        return tiles[i][j];
    }

    // Returns Hamming distance between this board and the goal board.
    public int hamming() {
        return hamming;
    }

    // Returns the Manhattan distance between this board and the goal board.
    public int manhattan() {
        return manhattan;
    }

    // Returns true if this board is the goal board, and false otherwise.
    public boolean isGoal() {
        return hamming == 0;
    }

    // Returns true if this board is solvable, and false otherwise.
    public boolean isSolvable() {
        
        int[] oneD = new int[n * n - 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tiles[i][j] != 0) {
                    oneD[index++] = tiles[i][j];
                }
            }
        }
        long inversions = Inversions.count(oneD);
        if (n % 2 == 1) {
            return inversions % 2 == 0;
        } else {
            int blankRowFromBottom = n - (blankPos - 1) / n;
            if (blankRowFromBottom % 2 == 0) {
                return inversions % 2 == 1;
            } else {
                return inversions % 2 == 0;
            }
        }
    }

    // Returns an iterable object containing the neighboring boards of this board.
    public Iterable<Board> neighbors() {
        
        LinkedQueue<Board> queue = new LinkedQueue<>();
        
        int blankRow = 0;
        int blankCol = 0;
        
          for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tiles[i][j] == 0) {
                    blankRow = i;
                    blankCol = j;
                }
            }
        }
        // Move the blank tile in all possible directions
        // Down
        if (blankRow < n - 1) {
            int [][] copy = cloneTiles();

            int temp = copy[blankRow + 1][blankCol];
            copy[blankRow + 1][blankCol] = 0;
            copy[blankRow][blankCol] = temp;
            queue.enqueue(new Board(copy));
        }
        // Up
        if (blankRow > 0) {
            int [][] copy = cloneTiles();

            int temp = copy[blankRow - 1][blankCol];
            copy[blankRow - 1][blankCol] = 0;
            copy[blankRow][blankCol] = temp;
            queue.enqueue(new Board(copy));
        }
        // Right
        if (blankCol < n - 1) {
            int [][] copy = cloneTiles();

            int temp = copy[blankRow][blankCol + 1];
            copy[blankRow][blankCol + 1] = 0;
            copy[blankRow][blankCol] = temp;
            queue.enqueue(new Board(copy));
        }
        // Left
        if (blankCol > 0) {
            int [][] copy = cloneTiles();

            int temp = copy[blankRow][blankCol - 1];
            copy[blankRow][blankCol - 1] = 0;
            copy[blankRow][blankCol] = temp;
            queue.enqueue(new Board(copy));
        }
        
        return queue;
    }

    // Returns true if this board is the same as other, and false otherwise.
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        Board otherBoard = (Board) other;
        if (this.n != otherBoard.n) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (this.tiles[i][j] != otherBoard.tiles[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Returns a string representation of this board.
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s.append(String.format("%2s", tiles[i][j] == 0 ? " " : tiles[i][j]));
                if (j < n - 1) {
                    s.append(" ");
                }
            }
            if (i < n - 1) {
                s.append("\n");
            }
        }
        return s.toString();
    }

    // Returns a defensive copy of tiles[][].
    private int[][] cloneTiles() {
        int[][] clone = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                clone[i][j] = tiles[i][j];
            }
        }
        return clone;
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tiles[i][j] = in.readInt();
            }
        }
        Board board = new Board(tiles);
        StdOut.printf("The board (%d-puzzle):\n%s\n", n, board);
        String f = "Hamming = %d, Manhattan = %d, Goal? %s, Solvable? %s\n";
        StdOut.printf(f, board.hamming(), board.manhattan(), board.isGoal(), board.isSolvable());
        StdOut.println("Neighboring boards:");
        for (Board neighbor : board.neighbors()) {
            StdOut.println(neighbor);
            StdOut.println("----------");
        }
    }
}
