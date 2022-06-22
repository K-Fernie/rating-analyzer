package org.stats;

import java.util.ArrayList;

public interface RatingAnalyzer {
    /**
     * Property specifying fully-qualified implementation classname.
     */
    //TODO property specifying fully-qualified implementation classname
    static String IMPLEMENTATION_PROPERTY = "rating-analyzer";

    /**
     * Classpath-relative name of properties file
     */
    //TODO
    static String PROPERTIES_FILENAME = "rating-analyzer.properties";

    /**
     * Computes (if needed) and returns the arithmetic mean of this analyzer's dataset.
     * @return Arithmetic mean of this analyzer's dataset
     */
    double mean();
    /**
     * Computes (if needed) and returns the median value in this analyzer's dataset
     * @return Median value of this analyzer's dataset
     */
    double median();
    /**
     * The mode(s) of this analyzer's dataset.
     * Nate: for a multi-modal result, the mode values are returned in ascending order.
     * @return Mode(s) of this analyzer's dataset.
     */
    int mode();

    /**
     * Factory method creates and returns an instance of an implementation of this interface.
     * @return instance of RatingAnalyzer implementation class
     */
    //TODO create a class that extends this interface
    //TODO wrap the Factory method in a try/catch statement
    static RatingAnalyzer newInstance(ArrayList ratings)
            throws AnalyzerConfigurationException{

        return null;//new RatingAnalyzer();
    }

}
