import stdlib.StdOut;

public class ThreeSort {
    // Entry Point.
    public static void main(String[] args) {
        // TODO
        // resived x,y,z as interger from args
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);

        // find the min, max, and mid number 
        int min = Math.min( x, Math.min( y, z));
        int max = Math.max( x, Math.max( y, z));

        // totsl of the number subtract the min and max number, then we can get the mid number 
        int mid = x + y + z - min - max; 

        StdOut.println( min + " " + mid + " " + max);
    }
}
