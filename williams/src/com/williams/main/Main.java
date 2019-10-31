package com.williams.main;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //Start by initializing MergeRange class
        MergeRange m1 = new MergeRange();

        //Then create input list of Zip Ranges
        List<ZipRange> input = Arrays.asList(new ZipRange(94130,94134),
            new ZipRange(94135,94299),
            new ZipRange(94301,94399));

        System.out.println(input);

        //Calling mergeRange method to get the desired method
        List<ZipRange> output = m1.mergeRange(input);

        System.out.println(output);
    }
}
