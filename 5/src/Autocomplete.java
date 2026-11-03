import dsa.Merge;
import java.util.Comparator;
import stdlib.In;
import stdlib.StdIn;
import stdlib.StdOut;

public class Autocomplete {
    private Term[] terms; // the terms that may complete prefix

    // Constructs an Autocomplete data structure from an array of terms.
    public Autocomplete(Term[] terms) {
        // TODO
        if (terms == null) {
            throw new NullPointerException("terms is null");
    }
        this.terms = new Term[terms.length];
        for (int i = 0; i < terms.length; i++) {
            this.terms[i] = terms[i];
        }
        Merge.sort(this.terms);
    }

    // Returns the number of terms that start with prefix.
    public int numberOfMatches(String prefix) {
        // TODO
        if (prefix == null) {
            throw new NullPointerException("prefix is null");
        }
        Comparator<Term> p = Term.prefixOrder(prefix.length());

        int i = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 0), p);
        if (i == -1) return 0;

        int j = BinarySearchDeluxe.lastIndexOf(terms, new Term(prefix, 0), p);
        return j - i + 1;
    }
       

    // Returns all terms that start with prefix, in descending order of 
    // their weights.
    public Term[] allMatches(String prefix) {
        // TODO
        if (prefix == null) {
            throw new NullPointerException("prefix is null");
        }
        Comparator<Term> p = Term.prefixOrder(prefix.length());

        int i = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 0), p);
        if (i == -1) return new Term[0];

        int j = BinarySearchDeluxe.lastIndexOf(terms, new Term(prefix, 0), p);
        int n = j - i + 1;

        Term[] results = new Term[n];
        for (int k = 0; k < n; k++) {
            results[k] = terms[i + k];
        }
        Merge.sort(results, Term.reverseWeightOrder());

        return results;
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        String filename = args[0];
        int k = Integer.parseInt(args[1]);
        In in = new In(filename);
        int n = in.readInt();
        Term[] terms = new Term[n];
        for (int i = 0; i < n; i++) {
            long weight = in.readLong();
            in.readChar();
            String query = in.readLine();
            terms[i] = new Term(query.trim(), weight);
        }
        Autocomplete autocomplete = new Autocomplete(terms);
        StdOut.print("Enter a prefix (or ctrl-d to quit): ");
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            String msg = " matches for \"" + prefix + 
                "\", in descending order by weight:";
            if (results.length == 0) {
                msg = "No matches";
            } else if (results.length > k) {
                msg = "First " + k + msg;
            } else {
                msg = "All" + msg;
            }
            StdOut.printf("%s\n", msg);
            for (int i = 0; i < Math.min(k, results.length); i++) {
                StdOut.println("  " + results[i]);
            }
            StdOut.print("Enter a prefix (or ctrl-d to quit): ");
        }
    }
}
