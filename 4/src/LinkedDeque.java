import java.util.Iterator;
import java.util.NoSuchElementException;
import stdlib.StdOut;
import stdlib.StdRandom;

// A data type to represent a double-ended queue (aka deque), implemented using 
// a doubly-linked list as the underlying data structure.
public class LinkedDeque<T> implements Iterable<T> {
    private Node first; // the first node in the linked list
    private Node last;  // the last node in the linked list
    private int n;      // the number of nodes in the linked list

    // Constructs an empty deque.
    public LinkedDeque() {
        // TODO
        first = null;
        last = null;
        n = 0;
    }

    // Returns true if this deque is empty, and false otherwise.
    public boolean isEmpty() {
        // TODO
        return n == 0;
    }

    // Returns the number of items in this deque.
    public int size() {
        // TODO
        return n;
    }

    // Adds item to the front of this deque.
    public void addFirst(T item) {
        // TODO
        if (item == null) {
            throw new NullPointerException("item is null");
        }
        Node oldFirst = first;
        first = new Node();
        
        first.item = item;
        first.next = oldFirst;
       
        if (oldFirst != null) {
            oldFirst.prev = first;
        } else {
            last = first;
        }
        n++;
    }

    // Adds item to the back of this deque.
    public void addLast(T item) {
        // TODO
        if (item == null) {
            throw new NullPointerException("item is null");
        }
        Node oldLast = last;
       
        last = new Node();
       
        last.item = item;
       
        last.prev = oldLast;
      
        if (oldLast != null) {
            oldLast.next = last;
        } else {
            first = last;
        }
        n++;
        
    }

    // Returns the item at the front of this deque.
    public T peekFirst() {
        // TODO
        if (first == null) {
            throw new NoSuchElementException("Deque is empty");
        }
        return first.item;
    }

       

    // Removes and returns the item at the front of this deque.
    public T removeFirst() {
        // TODO
        if (first == null) {
            throw new NoSuchElementException("Deque is empty");
        }
        T item = first.item;
        
        first = first.next;

        if (first != null) {
            first.prev = null;
        } else {
            last = null;
        }
        n--;
        return item;
    }

    // Returns the item at the back of this deque.
    public T peekLast() {
        // TODO
        if (last == null) {
            throw new NoSuchElementException("Deque is empty");
        }
        return last.item;
    }

    // Removes and returns the item at the back of this deque.
    public T removeLast() {
        // TODO
        if (last == null) {
            throw new NoSuchElementException("Deque is empty");
        }
        T item = last.item;
        last = last.prev;
        if (last != null) {
            last.next = null;
        } else {
            first = null;
        }
        n--;
        return item;
    }

    // Returns an iterator to iterate over the items in this deque from front 
    // to back.
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    // Returns a string representation of this deque.
    public String toString() {
        String s = "";
        for (T item : this) {
            s += item + ", ";
        }
        return isEmpty() ? s + "[]" : 
            "[" + s.substring(0, s.length() - 2) + "]";
    }

    // A deque iterator.
    private class DequeIterator implements Iterator<T> {
        private Node current; // the current node

        // Constructs an iterator.
        public DequeIterator() {
            current = first;
        }

        // Returns true if there are more items to iterate, and false otherwise.
        public boolean hasNext() {
            return current != null;
        }

        // Returns the next item.
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Iterator is empty");
            }
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    // A data type to represent a doubly-linked list. Each node in the list 
    // stores a generic item and references to the next and previous nodes 
    // in the list.
    private class Node {
        private T item;  // the item
        private Node next;  // the next node
        private Node prev;  // the previous node
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        LinkedDeque<Character> deque = new LinkedDeque<Character>();
        String quote = "There is grandeur in this view of life, with its " +
            "several powers, having been originally breathed into a few " + 
            "forms or into one; and that, whilst this planet has gone " + 
            "cycling on according to the fixed law of gravity, from so " + 
            "simple a beginning endless forms most beautiful and most " + 
            "wonderful have been, and are being, evolved. ~ Charles Darwin, " + 
            "The Origin of Species";
        int r = StdRandom.uniform(0, quote.length());
        StdOut.println("Filling the deque...");
        for (int i = quote.substring(0, r).length() - 1; i >= 0; i--) {
            deque.addFirst(quote.charAt(i));
        }
        for (int i = 0; i < quote.substring(r).length(); i++) {
            deque.addLast(quote.charAt(r + i));
        }
        StdOut.printf("The deque (%d characters): ", deque.size());
        for (char c : deque) {
            StdOut.print(c);
        }
        StdOut.println();
        StdOut.println("Emptying the deque...");
        double s = StdRandom.uniform();
        for (int i = 0; i < quote.length(); i++) {
            if (StdRandom.bernoulli(s)) {
                deque.removeFirst();
            } else {
                deque.removeLast();
            }
        }
        StdOut.println("deque.isEmpty()? " + deque.isEmpty());
    }
}
