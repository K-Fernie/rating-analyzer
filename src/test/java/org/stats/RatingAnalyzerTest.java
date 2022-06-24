package org.stats;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class RatingAnalyzerTest {

    @Test
    void newInstance_invalid() {
        assertThrows(AnalyzerConfigurationException.class, () -> RatingAnalyzer.newInstance(null));
    }

    @Test
    void mean() {
        int[] ratings = {9, 5, 6, 1, 18};

        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
        double meanVal = analyzer.mean();

        assertEquals(7.8, meanVal, .0001);
    }

    @Test
    void median_evenDataset() {
        int[] ratings = {9, 18, 6, 5, 1, 27};

        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
        double medianVal = analyzer.median();

        assertEquals(7.5, medianVal, .0001);
    }

    @Test
    void median_oddDataset() {
        int[] ratings = {9, 18, 6, 5, 1, 27, 15};

        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
        double medianVal = analyzer.median();

        assertEquals(9, medianVal, .0001);
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

    @Test
    void mode_noReturn(){
        int[] ratings = {1, 5, 6, 9, 15, 18, 27};

        RatingAnalyzer analyzer = RatingAnalyzer.newInstance(ratings);
        int[] modeVal = analyzer.mode();
        int[] assertionVal = {};

        assertArrayEquals(assertionVal, modeVal);
    }


}