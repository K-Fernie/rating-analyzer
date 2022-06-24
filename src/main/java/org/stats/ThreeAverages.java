package org.stats;

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

        List<Integer> modeReturn = new ArrayList<>();
        Map<Integer, Integer> modeMap = new HashMap<>();

        int keyCount = 1;
        int maxCountValue = 0;


        for (Integer rating : ratings) {
            if (modeMap.get(rating) == null) {
                modeMap.put(rating, keyCount);
            } else {
                int newCount = modeMap.get(rating) + 1;
                modeMap.put(rating, newCount);

                maxCountValue = Math.max(maxCountValue, newCount);
            }
        }

        for (Map.Entry<Integer, Integer> entry : modeMap.entrySet()) {
            if (maxCountValue > 1 && entry.getValue() == maxCountValue) {
                modeReturn.add(entry.getKey());
            }
        }

        return modeReturn.stream().sorted(Comparator.comparingInt(int1 -> int1)).mapToInt(i -> i).toArray();
    }

    public void setRatings(int[] ratings) {

        if (ratings.length > 0) {
            this.ratings = ratings;
        } else {
            throw new IllegalArgumentException("ratings array cannot be null or empty");
        }
    }

}
