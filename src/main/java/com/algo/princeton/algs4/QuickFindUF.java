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

    public boolean areConnected(int p, int q) {
        //
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pID = id[p];
        int qID = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }
}
