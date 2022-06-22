package org.stats;

import java.util.ArrayList;

public interface RatingAnalyzer {

    /**
     * Property specifying fully-qualified implementation classname.
     */
    static String IMPLEMENTATION_PROPERTY = "rating-analyzer";
    /**
     * Classpath-relative name of properties file
     */
    static String PROPERTIES_FILENAME = "rating-analyzer.properties";

    /**
     * Computes (if needed) and returns the arithmetic mean of this analyzer's dataset.
     *
     * @return Arithmetic mean of this analyzer's dataset
     */
    double mean();
    double mean(ArrayList<Integer> rating);
    /**
     * Computes (if needed) and returns the median value in this analyzer's dataset
     *
     * @return Median value of this analyzer's dataset
     */
    double median();

    /**
     * The mode(s) of this analyzer's dataset.
     * Nate: for a multi-modal result, the mode values are returned in ascending order.
     *
     * @return Mode(s) of this analyzer's dataset.
     */
    int mode();

    /**
     * Factory method creates and returns an instance of an implementation of this interface.
     *
     * @return instance of RatingAnalyzer implementation class
     */
    /*
        Implementation notes for providers:

        The implementation class must be a public class that implements this RatingAnalyzer
         interface.

        It must have a public constructor that accepts the ratings as a parameter of
        type int[].

        For example:

       public RatingAnalyzerImpl(int[] ratings) throws IllegalArgumentException {
           ...
       }
        This constructor must throw IllegalArgumentException if the ratings array
        is null or empty. If that occurs, this newInstance method will wrap that exception
        in an AnalyzerConfigurationException and throw that.

        The rating-analyzer.properties file (which must be located on the class path)
        is used by this method to instantiate the implementation class, and must contain
        the fully-qualified name of that class. See example file provided with this
        specification.
     */
    static RatingAnalyzer newInstance(ArrayList<Integer> ratings) {

        RatingAnalyzer ratingAnalyzer = null;

        try {
            ratingAnalyzer = new ThreeAverages(ratings);
        } catch (Exception e) {
            throw new AnalyzerConfigurationException(e.getCause());
        }

        return ratingAnalyzer;

    }

}
