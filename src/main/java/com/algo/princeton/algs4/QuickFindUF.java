package com.algo.princeton.algs4;

import java.util.stream.IntStream;

/**
 * @author mkarki
 */
public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N) {
        this.id = new int[N];
        IntStream.range(0, N).forEach(
                i -> id[i] = 1
        );
    }
}
