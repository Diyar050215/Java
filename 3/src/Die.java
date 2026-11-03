import stdlib.StdOut;
import stdlib.StdRandom;

public class Die {
    private int value; // the face value

    // Constructs a die.
    public Die() {
        // TODO
        this.value = -1;
    }
    
    // Rolls this die.
    public void roll() {
        // TODO
        this.value = StdRandom.uniform(1,7);
    }

    // Returns the face value of this die.
    public int value() {
        // TODO
        return this.value;
    
    }

    // Returns true if this die is the same as other, and false otherwise.
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        // TODO
        Die that = (Die) other;
        if (this.value == that.value) {
            return true;
        }
        return false;
    }

    // Returns a string representation of this die.
    public String toString() {
        // TODO
        if (this.value == 1) {
            return ( " " + " " + " " + " " + " " + "\n" + " " + " " + "*" + " " + " " + "\n" + " " + " " + " " + " " + " ");
        } else if (this.value == 2) {
            return ( "*" + " " + " " + " " + " " + "\n" + " " + " " + " " + " " + " " + "\n" + " " + " " + " " + " " + "*");
        } else if (this.value == 3) {
            return ( "*" + " " + " " + " " + " " + "\n" + " " + " " + "*" + " " + " " + "\n" + " " + " " + " " + " " + "*");
        } else if (this.value == 4) {
            return ( "*" + " " + " " + " " + "*" + "\n" + " " + " " + " " + " " + " " + "\n" + "*" + " " + " " + " " + "*");
        } else if (this.value == 5) {
            return ( "*" + " " + " " + " " + "*" + "\n" + " " + " " + "*" + " " + " " + "\n" + "*" + " " + " " + " " + "*");
        } else if (this.value == 6) {
            return ( "*" + " " + "*" + " " + "*" + "\n" + " " + " " + " " + " " + " " + "\n" + "*" + " " + "*" + " " + "*");
        }

        return "Error";
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        Die die = new Die();
        die.roll();
        StdOut.println(die);
    }
}
