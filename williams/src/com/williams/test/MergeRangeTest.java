package com.williams.test;

import static org.junit.jupiter.api.Assertions.*;

import com.williams.main.MergeRange;
import com.williams.main.ZipRange;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MergeRangeTest {

    @Test
    public void returnedListShouldBeSameTest() {
        List<ZipRange> input = Arrays.asList(new ZipRange(94133,94133),
            new ZipRange(94200,94299),
            new ZipRange(94600,94699));
        List<ZipRange> expectedOutput = Arrays.asList(new ZipRange(94133,94133),
            new ZipRange(94200,94299),
            new ZipRange(94600,94699));
        MergeRange test = new MergeRange();
        assertEquals(expectedOutput, test.mergeRange(input), "Output is same as input");
    }

    @Test
    public void returnedListShouldBeMergedTest() {
        List<ZipRange> input = Arrays.asList(new ZipRange(94133,94133),
            new ZipRange(94200,94299),
            new ZipRange(94226,94399));
        List<ZipRange> expectedOutput = Arrays.asList(new ZipRange(94133,94133),
            new ZipRange(94200,94399));
        MergeRange test = new MergeRange();
        assertEquals(expectedOutput, test.mergeRange(input), "Input should be merged");
    }

    @Test
    public void boundaryTest() {
        List<ZipRange> input = Arrays.asList(new ZipRange(00000,99999),
            new ZipRange(-1,10001));
        List<ZipRange> expectedOutput = Arrays.asList(new ZipRange(00000,99999));
        MergeRange test = new MergeRange();
        assertEquals(expectedOutput, test.mergeRange(input));
    }
}
