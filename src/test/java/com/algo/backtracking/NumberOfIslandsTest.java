package com.algo.backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author mkarki
 */
class NumberOfIslandsTest {
    private NumberOfIslands numberOfIslands;

    @BeforeEach
    void setup() {
        numberOfIslands = new NumberOfIslands();
    }

    @Test
    void testGetNumberOfIslands() {
        int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };
        assertEquals(6, numberOfIslands.getNumberOfIslands(M));
    }

    @Test
    void testMedian() {
        log();
    }

    void log() {

        MedianFinder mf = new MedianFinder();
        int[] arr = {5, 15, 1, 3};
        for(int i = 0; i < 4; i++) {
            mf.addNum(arr[i]);
            System.out.println(mf.findMedian());
        }
    }

    class MedianFinder {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;
        /** initialize your data structure here. */
        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        }
        public void addNum(int num) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
            if(minHeap.size()<maxHeap.size()){
                minHeap.offer(maxHeap.poll());
            }
            System.out.println("minHeap"+minHeap);
            System.out.println("maxHeap:"+maxHeap);
        }
        public double findMedian() {
            if(minHeap.size() > maxHeap.size()){
                return minHeap.peek();
            }else {
                return (minHeap.peek()+maxHeap.peek())/2.0;
            }
        }
    }
}