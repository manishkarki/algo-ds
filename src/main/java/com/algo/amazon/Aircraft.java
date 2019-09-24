package com.algo.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mkarki
 */
public class Aircraft {

    /**
     * Given max. travel distance and forward and backward route list, return pair of ids of forward and backward
     * routes that optimally utilized the max travel distance.:
     *
     * eg: max travel distance is : 11000
     * forward route list : [1,3000],[2,5000],[3,4000],[4,10000]
     * backward route list : [1,2000],[2,3000],[3,4000]
     * @param maxTravelDist
     * @param forwardRouteList
     * @param returnRouteList
     * @return
     */
    public static List<List<Integer>> getIdPairsForOptimal(int maxTravelDist, List<List<Integer>> forwardRouteList,
                                                           List<List<Integer>> returnRouteList) {
        if (forwardRouteList == null || forwardRouteList.size() == 0 || returnRouteList == null || returnRouteList.size() == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < forwardRouteList.size(); i++) {
            for (int j = 0; j < returnRouteList.size(); j++) {
                int currentMax = forwardRouteList.get(i).get(1) + returnRouteList.get(j).get(1);
                if (currentMax <= maxTravelDist) {
                    if (currentMax > max) {
                        max = currentMax;
                        result = new ArrayList<>();
                        result.add(Arrays.asList(forwardRouteList.get(i).get(0), returnRouteList.get(j).get(0)));
                    } else if (currentMax == max) {
                        result.add(Arrays.asList(forwardRouteList.get(i).get(0), returnRouteList.get(j).get(0)));
                    }

                }
            }

        }
        return result;
    }
}
