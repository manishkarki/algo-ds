package com.algo.dailyProblem;

import java.util.Arrays;

/**
 * Given an array arr[] of n integers, construct a Product Array prod[] (of same size) such that prod[i] is
 * equal to the product of all the elements of arr[] except arr[i]. Solve it without division operator and in O(n).
 * Example :
 * arr[] = {10, 3, 5, 6, 2}
 * prod[] = {180, 600, 360, 300, 900}
 * @author mkarki
 */
public class ProductArray {
    
    public int[] prodArrayPuzzle(int[] inputs) {
        if(inputs == null || inputs.length == 0) {
            throw new IllegalArgumentException("");
        }
        int len = inputs.length;
        int[] prodArray = new int[inputs.length];
        Arrays.fill(prodArray, 1);
        int temp = 1;
        // construct prod on left side
        for(int i = 0; i < len; i++) {
            temp *= inputs[i];
            prodArray[i] = temp;
        }

        temp = 1;
        for(int i = len - 1; i >= 0; i--) {
            prodArray[i] *= temp;
            temp *= inputs[i];
        }

        return prodArray;
    }
}
