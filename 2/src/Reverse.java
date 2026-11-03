import stdlib.StdIn;
import stdlib.StdOut;

public class Reverse {
    // Entry point.
    public static void main(String[] args) {
        // TODO
         // read all string as a input 
        String[] a = StdIn.readAllStrings();
        // set n to the size of a 
        int n = a.length;

       // exchange the elements of a
       for (int i = 0; i < n/2; i++) {
           String temp = a[i];
           a[i] = a[n -1 - i];
           a[n - 1 - i] = temp;
       }
       // print the reversed array
       for (int i = 0; i < n; i ++) {
            if ( i < n-1){
                StdOut.print(a[i] + " ");
            } else {
                StdOut.println(a[i]);
            }
       }

    }
    
}
