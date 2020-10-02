package com.algo.princeton.algs4;

import java.util.stream.IntStream;

/**
 * |0|1|2|3|4|5|6|7|
 * |0|1|2|3|4|5|6|7|
 *
 * @author mkarki
 */
public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int N) {
        id = new int[N];
        IntStream.range(0, N)
                .forEach(i -> id[i] = i);
    }

    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    public boolean areConnected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);

        id[pRoot] = qRoot;
    }
}
