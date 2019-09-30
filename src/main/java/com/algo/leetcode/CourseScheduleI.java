package com.algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mkarki
 */
public class CourseScheduleI {

    /**
     * There are a total of n courses you have to take, labeled from 0 to n-1.
     *
     * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
     * which is expressed as a pair: [0,1]
     *
     * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
     *
     * Example 1:
     *
     * Input: 2, [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 courses to take.
     *              To take course 1 you should have finished course 0. So it is possible.
     * Example 2:
     *23280666868295
     * Input: 2, [[1,0],[0,1]]
     * Output: false
     * Explanation: There are a total of 2 courses to take.
     *              To take course 1 you should have finished course 0, and to take course 0 you should
     *              also have finished course 1. So it is impossible.
     * @param num
     * @param preRequisites
     * @return
     */
    public static boolean canFinish(int num, int[][] preRequisites) {
        List<Integer>[] adjList = new List[num];
        int[] indegree = new int[num];

        for (int i = 0; i < num; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] preRequisite : preRequisites) {
            adjList[preRequisite[1]].add(preRequisite[0]);
            indegree[preRequisite[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            count++;
            for (int course : adjList[q.poll()]) {
                if (--indegree[course] == 0) {
                    q.add(course);
                }
            }
        }
        return count == num;
    }

    public static void main(String[] args) {
//        System.out.println(canFinish(2, new int[][]{{1, 0}}));
        System.out.println(canFinish(4, new int[][]{{1,0},{2,0},{3,1},{3,2}}));
    }

}
