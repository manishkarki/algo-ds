package com.algo.leetcode.thirtydaychallenge.april.eighttofourteen;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * @author mkarki
 */
public class LastStoneWeight {

    /**
     * We have a collection of stones, each stone has a positive integer weight.
     * <p>
     * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
     * <p>
     * If x == y, both stones are totally destroyed;
     * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
     * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: [2,7,4,1,8,1]
     * Output: 1
     * Explanation:
     * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
     * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
     * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
     * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
     * <p>
     * <p>
     * Note:
     * <p>
     * 1 <= stones.length <= 30
     * 1 <= stones[i] <= 1000
     */
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length <= 0) {
            return 0;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        IntStream.range(0, stones.length)
                .forEach(i -> priorityQueue.add(stones[i]));

        while (priorityQueue.size() > 1) {
            int max = priorityQueue.poll();
            int secondMax = priorityQueue.poll();
            int diff = 0;

            if (max > secondMax) {
                diff = max - secondMax;
            }
            priorityQueue.add(diff);
        }
        return priorityQueue.isEmpty() ? 0 : priorityQueue.poll();
    }
}
