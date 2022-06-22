package org.stats;

import java.util.*;

public class ThreeAverages implements RatingAnalyzer{

    private List<Integer> ratings = new ArrayList<>();

    public ThreeAverages(ArrayList<Integer> ratings) {
        setRatings(ratings);
    }

    @Override
    public double mean() {
        double meanCalc = 0;

        for(Integer rating : ratings){
            meanCalc += rating;
        }

        meanCalc = meanCalc/ratings.size();

        return meanCalc;
    }

    //TODO do you need this?
    @Override
    public double mean(ArrayList<Integer> ratings){
        double meanCalc = 0;

        for(Integer rating : ratings){
            meanCalc += rating;
        }
        meanCalc = meanCalc/ratings.size();

        return meanCalc;
    }

    @Override
    public double median() {
        //TODO modify this so it's more succinct
        ratings.sort(Comparator.comparingInt(r -> r));

        double medianCalc;
        int midIndex = Math.round(ratings.size()/2);
        int midIndexLower = midIndex - 1;
        ArrayList<Integer> meanCalc = new ArrayList<>();

        if(ratings.size() % 2 != 0){
            medianCalc = ratings.get(midIndex);
        }else{
            meanCalc.add(ratings.get(midIndex));
            meanCalc.add(ratings.get(midIndexLower));
            medianCalc = mean(meanCalc);
        }

        return medianCalc;
    }

    @Override
    public int mode() {
        //TODO find the values in the data set that occur most frequently
        //TODO put the data in order least to greatest
        //TODO iterate over the list and create a new list of duplicated data
        //TODO if list is > 0 repeat until only a single value remains
        //TODO return value
        Map<Integer, Integer> modeMap = new HashMap<>();
        int countValue = 1;
        for(Integer rating: ratings){
            if(modeMap.get(rating) != null){
                modeMap.put(rating, countValue);
            }else
            {
                int newCount = modeMap.get(rating) + 1;
                modeMap.put(rating, newCount);
            }
        }
        return 0;
    }

    public List<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        if(!ratings.isEmpty()){
            this.ratings = ratings;
        }else{
            throw new IllegalArgumentException("ratings array cannot be null or empty");
        }
    }

    //TODO should I override the toString, equals, and hash methods?
}
