package org.stats;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RatingAnalyzerTest {

    @Test
    void mean() {
        int[] ratings = {9, 10, 12, 13, 13, 13, 15, 15, 16, 16, 18, 22, 23, 24, 24, 25};

        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
        double meanVal = analyzer.mean();

        assertEquals(16.75, meanVal, .0001);
    }

    @Test
    void median() {
        int[] ratings = {9, 10, 12, 13, 13, 13, 15, 15, 16, 16, 18, 22, 23, 24, 24, 25};

        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
        double medianVal = analyzer.median();

        assertEquals(15.5, medianVal, .0001);
    }

    @Test
    void mode_singleReturn() {
        int[] ratings = {9, 10, 12, 13, 13, 13, 15, 15, 16, 16, 18, 22, 23, 24, 24, 25};

        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
        int[] modeVal = analyzer.mode();
        int[] assertionVal = {13};

        assertArrayEquals(assertionVal, modeVal);
    }

    @Test
    void mode_multipleReturn() {
        int[] ratings = {9, 10, 12, 13, 13, 15, 15, 16, 16, 18, 22, 23, 24, 24, 25};

        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
        int[] modeVal = analyzer.mode();
        int[] assertionVal = {13, 15, 16, 24};

        assertArrayEquals(assertionVal, modeVal);
    }

    //TODO test the valid instantiation of the class vs. the invalid instantiation of the class
    @Test
    void newInstance_valid() {
    }

    @Test
    void newInstance_invalid() {
    }
}