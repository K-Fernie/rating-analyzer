package org.stats;

import java.util.*;

public class ThreeAverages implements RatingAnalyzer{

    private int[] ratings = {};

    public ThreeAverages(int[] ratings) {
        setRatings(ratings);
    }

    @Override
    public double mean() {
        double meanCalc = 0;

        for(Integer rating : ratings){
            meanCalc += rating;
        }

        meanCalc = meanCalc/ratings.length;

        return meanCalc;
    }

    @Override
    public double median() {
        Arrays.sort(ratings);

        double medianCalc;
        int midIndex = Math.round((int)(ratings.length / 2d));
        int midIndexLower = midIndex - 1;

        if(ratings.length % 2 != 0){
            medianCalc = ratings[midIndex];
        }else{
            medianCalc = (ratings[midIndex] + ratings[midIndexLower]) / 2d;
        }

        return medianCalc;
    }

    @Override
    public int[] mode() {

        //TODO try to make some of the logic compartmentalized in methods OR inner classes
        List<Integer> modeReturn = new ArrayList<>();
        Map<Integer, Integer> modeMap = new HashMap<>();

        int keyCount = 1;
        int maxCountValue = 0;

        for(Integer rating: ratings){
            if(modeMap.get(rating) == null){
                modeMap.put(rating, keyCount);
            }else{
                int newCount = modeMap.get(rating) + 1;
                modeMap.put(rating, newCount);

                maxCountValue = Math.max(maxCountValue, newCount);
            }
        }

        for (Map.Entry<Integer, Integer> entry: modeMap.entrySet()){
            if(maxCountValue > 1 && entry.getValue() == maxCountValue){
                modeReturn.add(entry.getKey());
            }
        }

        modeReturn.sort(Comparator.comparingInt(int1 -> int1));
        return modeReturn.stream().mapToInt(i -> i).toArray();
    }


    public int[] getRatings() {
        return ratings;
    }

    public void setRatings(int[] ratings) {
        if(ratings.length > 0){
            this.ratings = ratings;
        }else{
            throw new IllegalArgumentException("ratings array cannot be null or empty");
        }
    }

    //TODO should I override the toString, equals, and hash methods?
}
