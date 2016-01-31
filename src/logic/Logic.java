package logic;

import algorithm.Algorithm;
import constants.AlgorithmNames;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Razi on 1/31/2016.
 */
public class Logic {
    public static List<String> getPeriodicAlgorithmList () {
        List<String> periodicAlgorithmList = new ArrayList<>();
        periodicAlgorithmList.add(AlgorithmNames.PERIODIC_RATE_MONOTONIC);
        //TODO ADD OTHER ALGORITHMS

        return periodicAlgorithmList;
    }

    public static List<String> getAperiodicAlgorithmList () {
        List<String> aperiodicAlgorithmList = new ArrayList<>();
        aperiodicAlgorithmList.add(AlgorithmNames.APERIODIC_HORN);
        //TODO ADD OTHER ALGORITHMS

        return aperiodicAlgorithmList;
    }

    public static List<String> getMixedAlgorithmList () {
        List<String> mixedAlgorithmList = new ArrayList<>();
        mixedAlgorithmList.add(AlgorithmNames.MIXED_BACKGROUND_SCHEDULING);
        //TODO ADD OTHER ALGORITHMS

        return mixedAlgorithmList;
    }

    public static Algorithm periodicAlgorithmFactory(String name) {
        return null;//TODO
    }

    public static Algorithm aperiodicAlgorithmFactory(String name) {
        return null;//TODO
    }

    public static Algorithm mixedAlgorithmFactory(String name) {
        return null;//TODO
    }
}