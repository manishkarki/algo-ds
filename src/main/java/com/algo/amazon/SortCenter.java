package com.algo.amazon;

import java.util.*;

/**
 * @author mkarki
 */
public class SortCenter {

    /**
     * In Amazon's sort center, a computer system decides what packages are to be loaded on what trucks.
     * All rooms and spaces are abstracted into space units which is represented as an integer. For each type of truck,
     * they have different space units, For each package, they will be occupying different space units.
     *
     * As a software development engineer in sort centers, you will need to write a method, Give truck space units and
     * a list of product space units, find out exactly TWO products that fit into the truck.
     * You will also implement an internal rule that the truck has to reserve exactly 30 space units for safety
     * purposes. Each package is assigned a unique ID, numered from 0 to N-1
     *
     * Conditions
     *
     * You will pick up exactly 2 packages
     * You cannot pick up one package twice.
     * If you have multiple pairs, select the pair with the largest package.
     * Input
     * The input to the function/method consists of two arguments are
     *
     * rideDuration : an integer representing the truck space.
     * songDurations : a list of integers representing the space units occupying by packages.
     *
     * Output
     * Return a list of integers representing the IDs of two packages who combine space will leave exactly 30 space units on the truck.
     *
     * Example:
     *
     * Input: rideDuration = 90, songDurations = [1, 10, 25, 35, 60]
     * Output: [2, 3]
     * Explanation: Given a truck of `90` space units, a list of packages space units `[1, 10, 25, 35, 60]`.
     * Your method should select the third(ID-2) and fourth (ID-3) package since you have to reserve exactly 30 space units.
     * @param rideDuration
     * @param songDurations
     * @return
     */
    ArrayList<Integer> IDsOfPackages(int rideDuration,
                                     ArrayList<Integer> songDurations) {
        int target = rideDuration - 30;
        List<ArrayList<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < songDurations.size(); i++) {
            int complement = target - songDurations.get(i);
            if (map.containsKey(complement)) {
                ArrayList<Integer> sub = new ArrayList<>();
                sub.add(map.get(complement));
                sub.add(i);
                result.add(sub);
            }
            map.put(songDurations.get(i), i);
        }
        if (result.size() > 1) {
            OptionalInt max = result.stream()
                    .flatMap(List::stream)
                    .mapToInt(Integer::intValue)
                    .map(i -> songDurations.get(i))
                    .max();

            if (max.isPresent()) {
                int m = max.getAsInt();
                for (ArrayList arr : result) {
                    if (arr.contains(songDurations.indexOf(m))) {
                        return arr;
                    }
                }
            }
            return new ArrayList<>();
        }
        return result.size() == 1 ? result.get(0) : new ArrayList<>();
    }

    // Check if it is possible to go to (x, y) from current position. The
    // function returns false if the cell has value 0 or already visited
    private static boolean isSafe(List<List<Integer>> area, int visited[][], int x, int y)
    {
        return !(area.get(x).get(y) == 0 || visited[x][y] != 0);
    }

    // if not a valid position, return false
    private static boolean isValid(int x, int y, int numRows, int numCol)
    {
        return (x < numRows && y < numCol && x >= 0 && y >= 0);
    }

    // Find Shortest Possible Route in a Matrix mat from source cell (0, 0)
    // to destination cell (x, y)

    // 'min_dist' stores length of longest path from source to destination
    // found so far and 'dist' maintains length of path from source cell to
    // the current cell (i, j)

    public static int findShortestPath(List<List<Integer>> area, int visited[][],
                                       int i, int j, int min_dist, int dist, int numRows, int numCol)
    {
        // if destination is found, update min_dist
        if (area.get(i).get(j) == 9)
        {
            return Integer.min(dist, min_dist);
        }

        // set (i, j) cell as visited
        visited[i][j] = 1;

        // go towards bottom cell
        if (isValid(i + 1, j, numRows, numCol) && isSafe(area, visited, i + 1, j)) {
            min_dist = findShortestPath(area, visited, i + 1, j,
                    min_dist, dist + 1, numRows, numCol);
        }

        // go towards right cell
        if (isValid(i, j + 1, numRows, numCol) && isSafe(area, visited, i, j + 1)) {
            min_dist = findShortestPath(area, visited, i, j + 1,
                    min_dist, dist + 1, numRows, numCol);
        }

        // go towards top cell
        if (isValid(i - 1, j, numRows, numCol) && isSafe(area, visited, i - 1, j)) {
            min_dist = findShortestPath(area, visited, i - 1, j,
                    min_dist, dist + 1, numRows, numCol);
        }

        // go towards left cell
        if (isValid(i, j - 1, numRows, numCol) && isSafe(area, visited, i, j - 1)) {
            min_dist = findShortestPath(area, visited, i, j - 1,
                    min_dist, dist + 1, numRows, numCol);
        }

        // Backtrack - Remove (i, j) from visited matrix
        visited[i][j] = 0;

        return min_dist;
    }

    int minimumDistance(int numRows, int numColumns, List<List<Integer>> area) {
        int[][] visited = new int[numRows][numColumns];

        return findShortestPath(area, visited, 0, 0,
                Integer.MAX_VALUE, 0, numRows, numColumns);
    }

    public static void main(String[] args) {
        SortCenter sc = new SortCenter();
        List<List<Integer>> area = new ArrayList<>();
        area.add(Arrays.asList(1, 0, 0));
        area.add(Arrays.asList(1, 0, 0));
        area.add(Arrays.asList(1, 9, 0));

        System.out.println(sc.minimumDistance(3, 3, area));
    }
}
