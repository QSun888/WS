package com.williams.main;

import java.util.*;

/**
 * The class merges the input collections of 5-digit ZIP code ranges
 * And output the merged ranges with minimum number of ranges required
 * to represent the same restrictions as the input
 * @version 1.0 10/30/2019
 * @author Q.Sun
 */
public class MergeRange {

    private int validUpper = 99999; // assume the upper bound of valid Zip Code is 99999
    private int validLower = 0; // assume the lower bound of valid Zip Code is 00000

    /**
     * The mergeRange method is used to merge the input collections of
     * 5-digit ZIP code ranges
     * @param  input (list of ranges that are going to be sorted)
     * @return merged ranges
     * Time Complexity: O(nlog(n)), n is the size of input
     * Space Complexity: O(n)
     */
    public List<ZipRange> mergeRange(List<ZipRange> input) {
        List<ZipRange> result = new ArrayList<>();

        if (input == null || input.size() == 0) {
            return result;
        }

        // first sort the input according to its lower bound
        sortInput(input);

        // iterate through the sorted input in order to merge the bounds
        for (ZipRange cur : input) {
            if (notValidZip(cur)) {
                continue;
            }
            /*
            If the current range begins after the previous range ends,
            then they do not overlap and we can append the current range to merged.
            Otherwise, they do overlap, and we merge them by updating the end of the
            previous range if it is less than the end of the current range.
             */
            if (result.isEmpty() || result.get(result.size() - 1).getUpperBound() + 1 < cur.getLowerBound()) {
                result.add(cur);
            } else {
                ZipRange lastZip = result.get(result.size() - 1);
                lastZip.setUpperBound(Math.max(lastZip.getUpperBound(), cur.getUpperBound()));
            }
        }

        return result;
    }

    /**
     * Sort the input based on the lower bound of the zip range
     * @param  input (list of ranges that are going to be sorted)
     */
    private void sortInput(List<ZipRange> input) {
        Collections.sort(input, new Comparator<ZipRange>() {
            @Override
            public int compare(ZipRange o1, ZipRange o2) {
                return o1.getLowerBound() - o2.getLowerBound();
            }
        });
    }

    private boolean notValidZip(ZipRange range) {
        if (range == null) {
            return true;
        }

        int lower = range.getLowerBound();
        int upper = range.getUpperBound();

        return lower > upper || lower < validLower || lower > validUpper
            || upper > validUpper;
    }
}
