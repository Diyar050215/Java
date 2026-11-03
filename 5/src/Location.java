import dsa.Merge;
import stdlib.StdOut;

import java.util.Comparator;

public class Location implements Comparable<Location> {
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
        double dLat = Math.toRadians(other.lat - this.lat);
        double dLon = Math.toRadians(other.lon - this.lon);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(this.lat)) * Math.cos(Math.toRadians(other.lat)) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double R = 6359.83; // meters
        return R * c;
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
        return this.lat == that.lat && this.lon == that.lon || this.name.equals(that.name);
    }

    // Returns a string representation of this location.
    public String toString() {
        // TODO
        return this.name + " (" + this.lat + ", " + this.lon + ")";
    }

    // Returns a comparison of this location with other based on their 
    // respective distances to the origin, Parthenon (Greece) @ 37.971525, 
    // 23.726726.
    public int compareTo(Location other) {
        // TODO
            Location parthenon = new Location("Parthenon (Greece)", 37.971525, 23.726726);
            double thisDistance = this.distanceTo(parthenon);
            double otherDistance = other.distanceTo(parthenon);
            return Double.compare(thisDistance, otherDistance);
        }

    

    // Returns a comparator for comparing two locations by their names.
    public static Comparator<Location> nameOrder() {
        // TODO
        return new NameOrder();
    }

    // Name comparator.
    private static class NameOrder implements Comparator<Location> {
        // Returns a comparison of locations v and w by their names.
        public int compare(Location v, Location w) {
            // TODO
            return v.name.compareTo(w.name);
        }
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        Location[] wonders = new Location[7];
        wonders[0] = new Location("The Great Wall of China (China)", 40.6769, 
            117.2319);
        wonders[1] = new Location("Petra (Jordan)", 30.3286, 35.4419);
        wonders[2] = new Location("The Colosseum (Italy)", 41.8902, 12.4923);
        wonders[3] = new Location("Chichen Itza (Mexico)", 20.6829, -88.5686);
        wonders[4] = new Location("Machu Picchu (Peru)", -13.1633, -72.5456);
        wonders[5] = new Location("Taj Mahal (India)", 27.1750, 78.0419);
        wonders[6] = new Location("Christ the Redeemer (Brazil)", 22.9519, 
            -43.2106);
        Merge.sort(wonders);
        StdOut.println("Seven wonders in the order of their distance to " + 
            "Parthenon (Greece):");
        for (Location wonder : wonders) {
            StdOut.println("  " + wonder);
        }
        Merge.sort(wonders, Location.nameOrder());
        StdOut.println("Seven wonders in alphabetical order:");
        for (Location wonder : wonders) {
            StdOut.println("  " + wonder);
        }
    }
}
