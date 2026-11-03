import dsa.LinkedQueue;
import stdlib.StdOut;

public class Josephus {
    // Entry point.
    public static void main(String[] args) {
        // TODO
        // Implement the Josephus problem using a queue.
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        // Create a queue and enqueue the integers from 1 to n.
        LinkedQueue<Integer> q = new LinkedQueue<Integer>();
        for (int i = 1; i < n + 1; i++) {
            q.enqueue(i);
        }
        // Eliminate every m-th person.
        while (!q.isEmpty()) {
            for (int i = 0; i < m - 1; i++) {
                q.enqueue(q.dequeue());
            }
            StdOut.println( q.dequeue());
        }
    }
}
