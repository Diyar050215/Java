import stdlib.StdOut;

public class Quadratic {
    // Entry point.
    public static void main(String[] args) {
        // TODO
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            double c = Double.parseDouble(args[2]);

        // calculate discriminant
            double dis = b * b - 4 * a * c;
        // value of must not be 0
        if (a == 0) {
            StdOut.println("Value of a must not be 0");

           // check the dis is small than 0 or not
        } else if (dis < 0) {
            StdOut.println("Value of discriminant must not be negative");

        } else {
            double root1 = (-b + Math.sqrt(dis)) / (2 * a);
            double root2 = (-b - Math.sqrt(dis)) / (2 * a);
            StdOut.println(root1 + " " + root2);
        }
        
    }
}

