package com.stats;

import org.stats.RatingAnalyzer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class ThreeAverages implements RatingAnalyzer {

    private int[] ratings = {};

    public ThreeAverages(int[] ratings) {
        setRatings(ratings);
    }

    @Override
    public double mean() {
        return (double) Arrays.stream(ratings).sum()/ratings.length;
    }

    @Override
    public double median() {
        Arrays.sort(ratings);

        int midIndex = Math.round((int) (ratings.length / 2d));
        int midIndexLower = midIndex - 1;

        return (ratings.length % 2 != 0) ?  ratings[midIndex] :
                (ratings[midIndex] + ratings[midIndexLower]) / 2d;
    }

    @Override
    public int[] mode() {

        List<Long> modeReturn = new ArrayList<>();
        Map<Integer, Long> modeMap = Arrays
                .stream(ratings)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        int maxValueInMap = (Collections.max(modeMap.values())).intValue();

        for (Map.Entry<Integer, Long> entry : modeMap.entrySet()) {
            if (maxValueInMap > 1 && entry.getValue() == maxValueInMap) {
                modeReturn.add(Long.valueOf(entry.getKey()));
            }
        }

        return modeReturn.stream().sorted(Comparator.comparingInt(Math::toIntExact)).mapToInt(Math::toIntExact).toArray();
    }

    public void setRatings(int[] ratings) {

        if (ratings.length > 0) {
            this.ratings = ratings;
        } else {
            throw new IllegalArgumentException("ratings array cannot be null or empty");
        }
    }

}
