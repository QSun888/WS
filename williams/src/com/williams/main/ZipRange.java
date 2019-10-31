package com.williams.main;

/**
 * The class is the data structure of the Zip code ranges
 * @version 1.0 10/30/2019
 * @author Q.Sun
 */
public class ZipRange {

    private int lowerBound, upperBound;

    public ZipRange(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public int getLowerBound() {
        return this.lowerBound;
    }

    public int getUpperBound() {
        return this.upperBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    @Override
    public String toString() {
        return this.lowerBound + "," + this.upperBound;
    }

    // Overriding equals() to compare two ZipRange objects
    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        // Check if o is an instance of ZipRange or not
        if (!(o instanceof ZipRange)) {
            return false;
        }

        // Typecast Object o to ZipRange z
        ZipRange z = (ZipRange) o;

        // Compare the data members and return accordingly
        return z.getLowerBound() == this.lowerBound
            && z.getUpperBound() == this.upperBound;
    }
}
