import stdlib.StdOut;

public class Location {
    private String name; // location name
    private double lat;  // latitude
    private double lon;  // longitude

    // Constructs a new location given its name, latitude, and longitude.
    public Location(String name, double lat, double lon) {
        // TODO
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    // Returns the great-circle distance between this location and other.
    public double distanceTo(Location other) {
        // TODO
        double x1 = Math.toRadians(this.lat);
        double y1 = Math.toRadians(this.lon);
        double x2 = Math.toRadians(other.lat);
        double y2 = Math.toRadians(other.lon);
        
        double d = 6359.83 * Math.acos((Math.sin(x1) * Math.sin(x2)) + (Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2)));

        return d;
    }

    // Returns true if this location is the same as other, and false otherwise.
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
        // TODO
            Location that = (Location) other;

            if ( this.lat == that.lat && this.lon == that.lon) {
                return true;
            }
        return false;
    }

    // Returns a string representation of this location.
    public String toString() {
        // TODO
        return this.name + " (" + this.lat + ", " + this.lon + ")";
    }
        

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        Location x = new Location("Paris", 48.51, -2.17);
        Location y = new Location("Boston", 42.36, -71.05);
        StdOut.println("x               = " + x);
        StdOut.println("y               = " + y);
        StdOut.println("x.distanceTo(y) = " + x.distanceTo(y));
        StdOut.println("x.equals(y)     = " + x.equals(y));
    }
}
