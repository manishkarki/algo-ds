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
     * @param numCourses
     * @param prereq
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prereq) {
        List<Integer>[] adj = new List[numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) adj[i] = new ArrayList<>();
        for (int[] req : prereq) {
            adj[req[1]].add(req[0]);
            indegree[req[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) q.offer(i);

        int cnt = 0;
        for (; !q.isEmpty(); cnt++)
            for (int crs : adj[q.poll()])
                if (--indegree[crs] == 0) q.offer(crs);
        return cnt == numCourses;
    }

    public static void main(String[] args) {
//        System.out.println(canFinish(2, new int[][]{{1, 0}}));
        System.out.println(canFinish(4, new int[][]{{1,0},{2,0},{3,1},{3,2}}));
    }

}
